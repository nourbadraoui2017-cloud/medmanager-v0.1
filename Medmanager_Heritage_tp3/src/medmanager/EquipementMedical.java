package medmanager;

public class EquipementMedical implements Identifiable, Assignable {

    private String id;
    private String designation;
    private ServiceHospitalier service;

    @Override
    public String getId() { return id; }

    @Override
    public String getIdentiteComplete() {
        return designation + " (#" + id + ")";
    }

    @Override
    public void affecter(ServiceHospitalier service) {
        this.service = service;
    }

    @Override
    public ServiceHospitalier getServiceActuel() { return service; }
}