package medmanager;

import java.time.LocalDate;

public class Infirmier extends Personne implements Consultable {

    private String diplome;
    private String service;

    public Infirmier(String id, String nom, String prenom,
                     LocalDate dateNaissance, String diplome, String service) {
        super(id, nom, prenom, dateNaissance);
        this.diplome = diplome;
        this.service = service;
    }

    @Override
    public String getRole() { return "Infirmier"; }

    @Override
    public String toString() {
        return super.toString()
             + " - Service : " + service
             + " [Diplôme : " + diplome + "]";
    }

    // --- Implémentation de Consultable ---
    @Override
    public boolean peutConsulter(Patient patient) {
        // L’infirmier peut consulter seulement si le patient est dans le même service
        return patient.getServiceActuel() != null 
               && patient.getServiceActuel().getNom().equalsIgnoreCase(service);
    }
}