package medmanager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AjouterAdministrateur implements Action {
    private List<Personne> personnel;

    public AjouterAdministrateur(List<Personne> personnel) {
        this.personnel = personnel;
    }

    @Override
    public void executer(Scanner sc) {
        System.out.print("ID de l'administrateur : ");
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
        System.out.print("Département : ");
        String departement = sc.nextLine();

        Administrateur a = new Administrateur(id, nom, prenom, LocalDate.of(annee, mois, jour), departement);
        personnel.add(a);
        System.out.println("Administrateur ajouté : " + a);
    }

    @Override
    public String getLibelle() {
        return "Ajouter un administrateur";
    }
}