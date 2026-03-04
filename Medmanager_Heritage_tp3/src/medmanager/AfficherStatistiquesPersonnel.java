package medmanager;

import java.util.List;

public class AfficherStatistiquesPersonnel implements Action {
    private List<Personne> personnel;

    public AfficherStatistiquesPersonnel(List<Personne> personnel) {
        this.personnel = personnel;
    }

    @Override
    public void executer(java.util.Scanner sc) {
        int nbPatients = 0, nbMedecins = 0, nbInfirmiers = 0, nbTechniciens = 0, nbAdmins = 0;

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

    @Override
    public String getLibelle() {
        return "Afficher les statistiques du personnel";
    }
}