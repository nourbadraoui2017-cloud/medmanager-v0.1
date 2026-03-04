package medmanager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AjouterPatient implements Action {
    private List<Personne> personnel;

    public AjouterPatient(List<Personne> personnel) {
        this.personnel = personnel;
    }

    @Override
    public void executer(Scanner sc) {
        System.out.print("ID du patient : ");
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
        sc.nextLine(); // consommer retour ligne

        Patient p = new Patient(id, nom, prenom, LocalDate.of(annee, mois, jour));
        personnel.add(p);
        System.out.println("Patient ajouté : " + p);
    }

    @Override
    public String getLibelle() {
        return "Ajouter un patient";
    }
}