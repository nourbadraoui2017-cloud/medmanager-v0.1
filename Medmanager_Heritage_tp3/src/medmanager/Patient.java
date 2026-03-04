package medmanager;

import java.time.LocalDate;

public class Patient extends Personne implements Identifiable, Assignable, Affichable {

    private GroupeSanguin groupeSanguin;
    private ServiceHospitalier serviceActuel;

    public Patient(String id, String nom, String prenom, LocalDate dateNaissance) {
        super(id, nom, prenom, dateNaissance);
    }

    @Override
    public String getRole() { return "Patient"; }

    @Override
    public String getIdentiteComplete() {
        return getPrenom() + " " + getNom() + " (Patient #" + getId() + ")";
    }

    @Override
    public void affecter(ServiceHospitalier service) {
        this.serviceActuel = service;
        if (service != null) {
            service.admettre(this); // ✅ fonctionne si ServiceHospitalier a bien la méthode
        }
    }

    @Override
    public ServiceHospitalier getServiceActuel() { return serviceActuel; }

    @Override
    public String getAffichageComplet() {
        String svc = serviceActuel == null ? "Non affecté" : serviceActuel.getNom();
        String gs = groupeSanguin == null ? "-" : groupeSanguin.getLabel();
        return String.format("%-25s %3d ans %-4s %s",
                getIdentiteComplete(), getAge(), gs, svc);
    }

    public GroupeSanguin getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(GroupeSanguin gs) { this.groupeSanguin = gs; }
}