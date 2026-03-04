package medmanager;

public enum SpecialiteMedecin {
    CARDIOLOGIE("Cardiologie"),
    PEDIATRIE("Pédiatrie"),
    CHIRURGIE("Chirurgie"),
    NEUROLOGIE("Neurologie"),
    URGENCES("Urgences");

    private final String label;

    SpecialiteMedecin(String label) {
        this.label = label;
    }

    public String getLabel() { return label; }

    // Trouver une spécialité par son label
    public static SpecialiteMedecin fromLabel(String label) {
        for (SpecialiteMedecin sp : values()) {
            if (sp.label.equalsIgnoreCase(label)) {
                return sp;
            }
        }
        throw new IllegalArgumentException("Spécialité inconnue : " + label);
    }
}