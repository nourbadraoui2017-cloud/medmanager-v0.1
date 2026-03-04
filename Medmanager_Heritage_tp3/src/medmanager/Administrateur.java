package medmanager;

import java.time.LocalDate;

public class Administrateur extends Personne {

    private String departement;

    public Administrateur(String id, String nom, String prenom,
                          LocalDate dateNaissance, String departement) {
        super(id, nom, prenom, dateNaissance);
        this.departement = departement;
    }

    @Override
    public String getRole() { return "Administrateur"; }

    @Override
    public String toString() {
        return super.toString() + " - Département : " + departement;
    }
}