package medmanager;

import java.util.Scanner;

public interface Action {
    void executer(Scanner sc);
    String getLibelle();
}