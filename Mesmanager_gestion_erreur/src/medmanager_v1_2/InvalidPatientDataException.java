package medmanager_v1_2;

public class InvalidPatientDataException extends MedManagerException {

    private final String champ;
    private final String valeur;

    public InvalidPatientDataException(String champ, String valeur) {
        super("Donnée invalide pour " + champ + " : '" + valeur + "'");
        this.champ = champ;
        this.valeur = valeur;
    }

    public String getChamp() { return champ; }
    public String getValeur() { return valeur; }
}