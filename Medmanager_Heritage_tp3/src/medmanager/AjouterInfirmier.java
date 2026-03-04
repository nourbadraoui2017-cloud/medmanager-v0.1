package medmanager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AjouterInfirmier implements Action {
    private List<Personne> personnel;

    public AjouterInfirmier(List<Personne> personnel) {
        this.personnel = personnel;
    }

    @Override
    public void executer(Scanner sc) {
        System.out.print("ID de l'infirmier : ");
        String id = sc.nextLine();
        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Prénom : ");
        String prenom = sc.nextLine();
        System.out.print("Année de naissance : ");
        int annee = sc.nextInt();
        System.out.print("Mois : ");
        int mois = sc.nextInt();
        System.out.print("Jour : ");
        int jour = sc.nextInt();
        sc.nextLine();
        System.out.print("Diplôme : ");
        String diplome = sc.nextLine();
        System.out.print("Service : ");
        String service = sc.nextLine();

        Infirmier i = new Infirmier(id, nom, prenom, LocalDate.of(annee, mois, jour), diplome, service);
        personnel.add(i);
        System.out.println("Infirmier ajouté : " + i);
    }

    @Override
    public String getLibelle() {
        return "Ajouter un infirmier";
    }
}