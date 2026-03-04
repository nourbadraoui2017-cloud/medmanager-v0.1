package medmanager;

import java.util.List;
import java.util.Scanner;

public class RechercherPersonne implements Action {
    private List<Personne> personnel;

    public RechercherPersonne(List<Personne> personnel) {
        this.personnel = personnel;
    }

    @Override
    public void executer(Scanner sc) {
        System.out.print("Entrez un terme de recherche : ");
        String terme = sc.nextLine().toLowerCase();

        System.out.println("=== Résultats de la recherche ===");
        for (Personne p : personnel) {
            if (p.getId().toLowerCase().contains(terme)
             || p.getNom().toLowerCase().contains(terme)
             || p.getPrenom().toLowerCase().contains(terme)) {
                System.out.println(p);
            }
        }
    }

    @Override
    public String getLibelle() {
        return "Rechercher une personne";
    }
}
