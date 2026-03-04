package medmanager;

import java.time.LocalDate;

public class Medecin extends Personne implements Consultable {

    private SpecialiteMedecin specialite;
    private String matricule;

    public Medecin(String id, String nom, String prenom,
                   LocalDate dateNaissance, SpecialiteMedecin specialite, String matricule) {
        super(id, nom, prenom, dateNaissance);
        this.specialite = specialite;
        this.matricule = matricule;
    }

    @Override
    public String getRole() { return "Médecin"; }

    public SpecialiteMedecin getSpecialite() { return specialite; }
    public String getMatricule() { return matricule; }

    @Override
    public String toString() {
        return "Dr. " + getPrenom() + " " + getNom()
             + " - " + specialite.getLabel()
             + " [Matricule : " + matricule + "]";
    }

    // --- Implémentation de Consultable ---
    @Override
    public boolean peutConsulter(Patient patient) {
        return true; // Un médecin peut toujours consulter
    }
}