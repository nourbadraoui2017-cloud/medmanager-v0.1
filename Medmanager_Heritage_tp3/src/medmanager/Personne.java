package medmanager;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Personne {

    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String telephone;

    public Personne(String id, String nom, String prenom, LocalDate dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public int getAge() {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    public abstract String getRole();

    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    @Override
    public String toString() {
        return getRole() + " " + prenom + " " + nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne p = (Personne) o;
        return id.equals(p.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}