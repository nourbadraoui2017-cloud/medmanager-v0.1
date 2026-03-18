package medmanager_v1_2;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {

    // Liste des services hospitaliers
    private static final List<ServiceHospitalier> services = new ArrayList<>();
    // Liste des patients
    private static final List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialisation des services
        services.add(new ServiceHospitalier("Cardiologie", 30));
        services.add(new ServiceHospitalier("Urgences", 50));
        services.add(new ServiceHospitalier("Pédiatrie", 20));

        // Boucle principale
        while (true) {
            System.out.println("\n══════ MedManager v1.2 ══════");
            System.out.println("1. Nouveau patient");
            System.out.println("2. Affecter patient à un service");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");

            int choix = lireEntierDansPlage(sc, 1, 3, "");

            switch (choix) {
                case 1 -> creerNouveauPatient(sc);
                case 2 -> affecterPatientAuService(sc);
                case 3 -> {
                    Logger.info("Fermeture de MedManager.");
                    return;
                }
            }
        }
    }

    // ✅ Exercice 3 — lireEntierDansPlage
    public static int lireEntierDansPlage(Scanner sc, int min, int max, String invite) {
        while (true) {
            if (!invite.isBlank()) System.out.print(invite);
            try {
                int valeur = sc.nextInt();
                sc.nextLine(); // consommer le retour chariot
                if (valeur >= min && valeur <= max) {
                    return valeur;
                } else {
                    Logger.warn("Valeur hors plage [" + min + " - " + max + "]");
                }
            } catch (InputMismatchException e) {
                Logger.warn("Saisie invalide, entrez un nombre.");
                sc.nextLine(); // vider la saisie incorrecte
            }
        }
    }

    // ✅ lireDate
    static LocalDate lireDate(Scanner sc, String invite) {
        while (true) {
            System.out.print(invite);
            String saisie = sc.nextLine().trim();
            try {
                return LocalDate.parse(saisie);
            } catch (DateTimeParseException e) {
                Logger.warn("Format invalide : \"" + saisie + "\". Format attendu : AAAA-MM-JJ");
            }
        }
    }

    // ✅ lireGroupeSanguin
    static GroupeSanguin lireGroupeSanguin(Scanner sc) {
        while (true) {
            System.out.print("Groupe sanguin (A+, A-, B+, B-, AB+, AB-, O+, O-) : ");
            String saisie = sc.nextLine().trim();
            try {
                return GroupeSanguin.fromLabel(saisie);
            } catch (InvalidGroupeSanguinException e) {
                Logger.warn(e.getMessage());
            }
        }
    }

    // ✅ Création d’un nouveau patient
    static void creerNouveauPatient(Scanner sc) {
        System.out.println("\n--- Nouveau Patient ---");
        System.out.print("Nom : ");
        String nom = sc.nextLine().trim();
        System.out.print("Prénom : ");
        String prenom = sc.nextLine().trim();
        LocalDate dn = lireDate(sc, "Date de naissance (AAAA-MM-JJ) : ");
        GroupeSanguin gs = lireGroupeSanguin(sc);

        String id = "P" + (patients.size() + 1); // simple génération d’ID

        try {
            Patient p = new Patient(id, nom, prenom, dn);
            patients.add(p);
            Logger.info("✅ " + p.getIdentiteComplete() + " enregistré (" 
                + (LocalDate.now().getYear() - dn.getYear()) + " ans)");
        } catch (InvalidPatientDataException e) {
            Logger.error("Erreur lors de la création du patient", e);
        }
    }

    // ✅ affecterPatientAuService
    static void affecterPatientAuService(Scanner sc) {
        try {
            System.out.print("\nID du patient : ");
            String idPat = sc.nextLine().trim();

            Patient patient = trouverPatientParId(idPat);

            afficherServices();
            int idx = lireEntierDansPlage(sc, 1, services.size(), "Numéro du service : ") - 1;

            ServiceHospitalier service = services.get(idx);
            service.admettre(patient);

            Logger.info("✅ " + patient.getIdentiteComplete() + " admis en " + service.getNom());

        } catch (PersonneNotFoundException e) {
            Logger.warn(e.getMessage());
            Logger.warn("Vérifiez l'identifiant et réessayez.");

        } catch (ServiceCompletException e) {
            Logger.warn(e.getMessage());
            services.get(0).ajouterEnFileAttente(trouverPatientParId(e.getNomService())); // ajout en file d’attente

        } catch (DuplicatePersonneException | IllegalArgumentException e) {
            Logger.warn(e.getMessage());
        }
    }

    // ✅ Recherche patient
    static Patient trouverPatientParId(String id) {
        for (Patient p : patients) {
            if (p.id.equals(id)) return p;
        }
        throw new PersonneNotFoundException(id, "Patient");
    }

    // ✅ Affichage des services
    static void afficherServices() {
        System.out.println("Services disponibles :");
        for (int i = 0; i < services.size(); i++) {
            ServiceHospitalier s = services.get(i);
            System.out.println("  " + (i + 1) + ". " + s.getNom());
        }
    }
}