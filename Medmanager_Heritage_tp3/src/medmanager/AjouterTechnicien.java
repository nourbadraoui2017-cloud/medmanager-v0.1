package medmanager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AjouterTechnicien implements Action {
    private List<Personne> personnel;

    public AjouterTechnicien(List<Personne> personnel) {
        this.personnel = personnel;
    }

    @Override
    public void executer(Scanner sc) {
        System.out.print("ID du technicien : ");
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
        System.out.print("Laboratoire : ");
        String labo = sc.nextLine();

        Technicien t = new Technicien(id, nom, prenom, LocalDate.of(annee, mois, jour), labo);
        personnel.add(t);
        System.out.println("Technicien ajouté : " + t);
    }

    @Override
    public String getLibelle() {
        return "Ajouter un technicien";
    }
}