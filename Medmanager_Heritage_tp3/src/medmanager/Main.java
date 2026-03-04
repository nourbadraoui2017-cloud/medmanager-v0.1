package medmanager;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Personne> personnel = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        List<Action> actions = new ArrayList<>();
        actions.add(new AjouterPatient(personnel));
        actions.add(new AjouterInfirmier(personnel));
        actions.add(new AjouterTechnicien(personnel));
        actions.add(new AjouterAdministrateur(personnel));
        actions.add(new AfficherPersonnel(personnel));
        actions.add(new AfficherStatistiquesPersonnel(personnel));
        actions.add(new RechercherPersonne(personnel));

        int choix;
        do {
            System.out.println("=== MENU MEDMANAGER ===");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println((i+1) + ". " + actions.get(i).getLibelle());
            }
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            if (choix > 0 && choix <= actions.size()) {
                actions.get(choix-1).executer(sc);
            }
        } while (choix != 0);
    }
}