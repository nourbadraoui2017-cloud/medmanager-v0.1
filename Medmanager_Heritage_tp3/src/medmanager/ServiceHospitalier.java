package medmanager;

import java.util.ArrayList;
import java.util.List;

public class ServiceHospitalier {
    private String nom;
    private List<Patient> patients;

    public ServiceHospitalier(String nom) {
        this.nom = nom;
        this.patients = new ArrayList<>();
    }

    public String getNom() { return nom; }

    public List<Patient> getPatients() { return patients; }

    // Méthode pour admettre un patient
    public void admettre(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
        }
    }

    @Override
    public String toString() {
        return "Service : " + nom + " (patients : " + patients.size() + ")";
    }
}