package medmanager_v1_2;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Personne {
    protected final String id;
    protected final String nom;
    protected final String prenom;
    protected final LocalDate dateNaissance;

    public Personne(String id, String nom, String prenom, LocalDate dateNaissance) {
        Objects.requireNonNull(id, "L'ID ne peut pas être null");
        Objects.requireNonNull(nom, "Le nom ne peut pas être null");
        Objects.requireNonNull(prenom, "Le prénom ne peut pas être null");
        Objects.requireNonNull(dateNaissance, "La date ne peut pas être null");

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getRole() {
        return this.getClass().getSimpleName(); // Patient, Medecin, Infirmier
    }
}