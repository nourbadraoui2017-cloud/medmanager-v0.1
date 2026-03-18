package medmanager_v1_2;

public class PersonneNotFoundException extends MedManagerException {
    private final String idRecherche;
    private final String roleRecherche;

    public PersonneNotFoundException(String id, String role) {
        super(role + " introuvable (ID: " + id + ")");
        this.idRecherche = id;
        this.roleRecherche = role;
    }

    public String getIdRecherche() { return idRecherche; }
    public String getRoleRecherche() { return roleRecherche; }
}