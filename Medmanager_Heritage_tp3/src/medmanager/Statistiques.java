package medmanager;

import java.util.List;

public class Statistiques {

    public static void afficherStatistiquesPersonnel(List<Personne> personnel) {
        int nbPatients = 0;
        int nbMedecins = 0;
        int nbInfirmiers = 0;
        int nbTechniciens = 0;
        int nbAdmins = 0;

        for (Personne p : personnel) {
            if (p instanceof Patient) nbPatients++;
            else if (p instanceof Medecin) nbMedecins++;
            else if (p instanceof Infirmier) nbInfirmiers++;
            else if (p instanceof Technicien) nbTechniciens++;
            else if (p instanceof Administrateur) nbAdmins++;
        }

        System.out.println("=== Statistiques du personnel ===");
        System.out.println("Patients : " + nbPatients);
        System.out.println("Médecins : " + nbMedecins);
        System.out.println("Infirmiers : " + nbInfirmiers);
        System.out.println("Techniciens : " + nbTechniciens);
        System.out.println("Administrateurs : " + nbAdmins);
    }
}
