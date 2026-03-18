package medmanager_v1_2;

import java.time.LocalDate;

public class Patient extends Personne {

    public Patient(String id, String nom, String prenom, LocalDate dateNaissance) {
        super(id, nom, prenom, dateNaissance);

        if (!id.matches("^P\\d+$")) {
            throw new InvalidPatientDataException("ID", id);
        }
        if (!nom.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")) {
            throw new InvalidPatientDataException("Nom", nom);
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new InvalidPatientDataException("Date de naissance", dateNaissance.toString());
        }
    }

    public String getIdentiteComplete() {
        return prenom + " " + nom + " (Patient #" + id + ")";
    }
}