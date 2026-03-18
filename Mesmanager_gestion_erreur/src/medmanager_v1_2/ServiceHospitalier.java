package medmanager_v1_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServiceHospitalier {
    private final String nom;
    private final int capaciteLits;
    private final List<Patient> patients = new ArrayList<>();
    private final Queue<Patient> fileAttente = new LinkedList<>();

    public ServiceHospitalier(String nom, int capaciteLits) {
        this.nom = nom;
        this.capaciteLits = capaciteLits;
    }

    public void admettre(Patient patient) {
        if (patients.size() >= capaciteLits) {
            throw new ServiceCompletException(nom, capaciteLits);
        }
        if (patients.contains(patient)) {
            throw new DuplicatePersonneException(patient.id);
        }
        patients.add(patient);
    }

    public void ajouterEnFileAttente(Patient patient) {
        fileAttente.add(patient);
        Logger.info(patient.getIdentiteComplete() + " ajouté en file d’attente (" 
            + fileAttente.size() + "ème position)");
    }

    public String getNom() { return nom; }
}