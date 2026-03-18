package medmanager_v1_2;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static String timestamp() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static void info(String message) {
        System.out.println(timestamp() + " [INFO] " + message);
    }

    public static void warn(String message) {
        System.out.println(timestamp() + " [WARN] " + message);
    }

    public static void error(String message, Exception e) {
        System.out.println(timestamp() + " [ERROR] " + message);
        e.printStackTrace(System.out);
    }
}