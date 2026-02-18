package medmanager1erec;
import java.util.Scanner;

public class Medman {
	    // ── Constantes ──
	    static final int MAX_PATIENTS = 100;
	    static final int MAX_SERVICES = 5;

	    static String[] nomsPatients = new String[MAX_PATIENTS];
	    static String[] prenomsPatients = new String[MAX_PATIENTS];
	    static int[] anneesNaissance = new int[MAX_PATIENTS];
	    static int[] serviceAffecte = new int[MAX_PATIENTS]; // index du service

	    static int nbPatients = 0;

	    static String[] nomsServices = {"Urgences", "Cardiologie", "Pédiatrie", "Oncologie", "Chirurgie"};
	    static int[] capacitesServices = {5, 10, 8, 6, 7};
	    static int[] nbPatientsParService = new int[MAX_SERVICES];

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int choix;

	        do {
	            afficherMenu();
	            choix = lireChoix(scanner);

	            switch (choix) {
	                case 1 -> ajouterPatient(scanner);
	                case 2 -> afficherPatients();
	                case 3 -> rechercherPatient(scanner);
	                case 4 -> afficherStatistiques();
	                case 5 -> trierPatients();
	                case 0 -> System.out.println("\n👋 Au revoir !");
	                default -> System.out.println("⚠ Choix invalide.");
	            }
	        } while (choix != 0);

	        scanner.close();
	    }

	    // ── Affichage du menu ──
	    static void afficherMenu() {
	        System.out.println("\n══════ MedManager v0.4 ══════");
	        System.out.println("  1. ➕ Ajouter un patient");
	        System.out.println("  2. 📋 Afficher tous les patients");
	        System.out.println("  3. 🔍 Rechercher un patient");
	        System.out.println("  4. 📊 Statistiques");
	        System.out.println("  5. 🔠 Trier les patients par nom");
	        System.out.println("  0. 🚪 Quitter");
	        System.out.print("Votre choix : ");
	    }

	    // ── Lire un choix entier en toute sécurité ──
	    static int lireChoix(Scanner scanner) {
	        while (!scanner.hasNextInt()) {
	            System.out.print("⚠ Entrez un nombre : ");
	            scanner.next();  // consomme l'entrée invalide
	        }
	        int choix = scanner.nextInt();
	        scanner.nextLine();  // nettoie le buffer
	        return choix;
	    }

	    // ── Ajouter un patient ──
	    static void ajouterPatient(Scanner scanner) {
	        if (nbPatients >= MAX_PATIENTS) {
	            System.out.println("⚠ Capacité maximale atteinte !");
	            return;
	        }

	        System.out.println("\n--- Nouveau Patient ---");

	        System.out.print("Nom : ");
	        nomsPatients[nbPatients] = scanner.nextLine();

	        System.out.print("Prénom : ");
	        prenomsPatients[nbPatients] = scanner.nextLine();

	        int anneeNaissance;
	        int age;
	        int anneeCourante = java.time.Year.now().getValue();

	        // Boucle de validation
	        while (true) {
	            System.out.print("Année de naissance : ");
	            anneeNaissance = lireChoix(scanner);
	            age = anneeCourante - anneeNaissance;

	            if (age < 0 || age > 150) {
	                System.out.println("⚠ Âge invalide (" + age + " ans). Veuillez réessayer.");
	            } else {
	                break; // sortie de la boucle si l'âge est valide
	            }
	        }

	        // Choix du service
	        System.out.println("\nAffecter à un service :");
	        for (int i = 0; i < MAX_SERVICES; i++) {
	            System.out.printf("  %d. %s (Capacité %d, Occupés %d)%n",
	                    (i + 1), nomsServices[i], capacitesServices[i], nbPatientsParService[i]);
	        }

	        int choixService;
	        while (true) {
	            System.out.print("Votre choix : ");
	            choixService = lireChoix(scanner) - 1;
	            if (choixService < 0 || choixService >= MAX_SERVICES) {
	                System.out.println("⚠ Service invalide.");
	            } else if (nbPatientsParService[choixService] >= capacitesServices[choixService]) {
	                System.out.println("⚠ Capacité du service atteinte !");
	            } else {
	                break;
	            }
	        }

	        anneesNaissance[nbPatients] = anneeNaissance;
	        serviceAffecte[nbPatients] = choixService;
	        nbPatientsParService[choixService]++;
	        nbPatients++;

	        System.out.println("✅ Patient enregistré (" + age + " ans, Service : " + nomsServices[choixService] + ")");
	    }

	    // ── Afficher tous les patients ──
	    static void afficherPatients() {
	        if (nbPatients == 0) {
	            System.out.println("\nAucun patient enregistré.");
	            return;
	        }

	        int anneeCourante = java.time.Year.now().getValue();

	        System.out.println("\n--- Liste des Patients ---");
	        System.out.println("─────┬────────────────┬────────────────┬───────┬────────────────┐");
	        System.out.printf("│ %-3s │ %-14s │ %-14s │ %-5s │ %-14s │%n", "#", "Nom", "Prénom", "Âge", "Service");
	        System.out.println("├─────┼────────────────┼────────────────┼───────┼────────────────┤");

	        for (int i = 0; i < nbPatients; i++) {
	            int age = anneeCourante - anneesNaissance[i];
	            System.out.printf("│ %-3d │ %-14s │ %-14s │ %-5d │ %-14s │%n",
	                    (i + 1), nomsPatients[i], prenomsPatients[i], age, nomsServices[serviceAffecte[i]]);
	        }
	        System.out.println("└─────┴────────────────┴────────────────┴───────┴────────────────┘");
	        System.out.println("Total : " + nbPatients + " patient(s)");
	    }

	    // ── Rechercher un patient par nom ──
	    static void rechercherPatient(Scanner scanner) {
	        System.out.print("\nRechercher (nom) : ");
	        String recherche = scanner.nextLine().toLowerCase();
	        boolean trouve = false;
	        int anneeCourante = java.time.Year.now().getValue();

	        for (int i = 0; i < nbPatients; i++) {
	            if (nomsPatients[i].toLowerCase().contains(recherche)) {
	                int age = anneeCourante - anneesNaissance[i];
	                System.out.println("→ " + prenomsPatients[i] + " "
	                        + nomsPatients[i] + " (" + age + " ans, Service : " + nomsServices[serviceAffecte[i]] + ")");
	                trouve = true;
	            }
	        }
	        if (!trouve) {
	            System.out.println("Aucun résultat pour \"" + recherche + "\"");
	        }
	    }

	    // ── Statistiques ──
	    static void afficherStatistiques() {
	        if (nbPatients == 0) {
	            System.out.println("\nAucun patient enregistré.");
	            return;
	        }

	        int anneeCourante = java.time.Year.now().getValue();
	        int sommeAges = 0;
	        int minAge = Integer.MAX_VALUE;
	        int maxAge = Integer.MIN_VALUE;

	        for (int i = 0; i < nbPatients; i++) {
	            int age = anneeCourante - anneesNaissance[i];
	            sommeAges += age;
	            if (age < minAge) minAge = age;
	            if (age > maxAge) maxAge = age;
	        }

	        double ageMoyen = (double) sommeAges / nbPatients;

	        System.out.println("\n--- Statistiques ---");
	        System.out.println("Nombre total de patients : " + nbPatients);
	        System.out.printf("Âge moyen : %.2f ans%n", ageMoyen);
	        System.out.println("Âge du plus jeune : " + minAge + " ans");
	        System.out.println("Âge du plus vieux : " + maxAge + " ans");
	    }

	 // ── Tri à bulles par nom ──
	    static void trierPatients() {
	        for (int i = 0; i < nbPatients - 1; i++) {
	            for (int j = 0; j < nbPatients - i - 1; j++) {
	                if (nomsPatients[j].compareToIgnoreCase(nomsPatients[j + 1]) > 0) {
	                    // Échange des noms
	                    String tmpNom = nomsPatients[j];
	                    nomsPatients[j] = nomsPatients[j + 1];
	                    nomsPatients[j + 1] = tmpNom;

	                    // Échange des prénoms
	                    String tmpPrenom = prenomsPatients[j];
	                    prenomsPatients[j] = prenomsPatients[j + 1];
	                    prenomsPatients[j + 1] = tmpPrenom;

	                    // Échange des années de naissance
	                    int tmpAnnee = anneesNaissance[j];
	                    anneesNaissance[j] = anneesNaissance[j + 1];
	                    anneesNaissance[j + 1] = tmpAnnee;

	                    // Échange des services affectés
	                    int tmpService = serviceAffecte[j];
	                    serviceAffecte[j] = serviceAffecte[j + 1];
	                    serviceAffecte[j + 1] = tmpService;
	                }
	            }
	        }
	        System.out.println("\n✅ Patients triés par ordre alphabétique de nom.");
	        afficherPatients();
	    }
	}
