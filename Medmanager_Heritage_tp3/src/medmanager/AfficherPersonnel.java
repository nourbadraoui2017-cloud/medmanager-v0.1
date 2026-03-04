package medmanager;

import java.util.List;
import java.util.Scanner;

public class AfficherPersonnel implements Action {
    private List<Personne> personnel;

    public AfficherPersonnel(List<Personne> personnel) {
        this.personnel = personnel;
    }

    @Override
    public void executer(Scanner sc) {
        System.out.println("=== Liste du personnel ===");
        for (Personne p : personnel) {
            System.out.println(p);
        }
    }

    @Override
    public String getLibelle() {
        return "Afficher le personnel";
    }
}