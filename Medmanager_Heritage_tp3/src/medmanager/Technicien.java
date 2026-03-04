package medmanager;

public class Technicien extends Personne {

    private String numeroLaboratoire;

    public Technicien(String id, String nom, String prenom,
                      java.time.LocalDate dateNaissance,
                      String numeroLaboratoire) {
        super(id, nom, prenom, dateNaissance);
        this.numeroLaboratoire = numeroLaboratoire;
    }

    @Override
    public String getRole() { return "Technicien de labo"; }

    @Override
    public String toString() {
        return super.toString()
             + " - Laboratoire : " + numeroLaboratoire;
    }
}