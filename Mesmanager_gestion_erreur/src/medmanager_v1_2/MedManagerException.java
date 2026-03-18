package medmanager_v1_2;

public class MedManagerException extends RuntimeException {

    public MedManagerException(String message) {
        super(message);
    }

    public MedManagerException(String message, Throwable cause) {
        super(message, cause); // chaîner la cause originale
    }
}