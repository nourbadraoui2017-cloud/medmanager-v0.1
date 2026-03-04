package medmanager;

import java.util.ArrayList;
import java.util.List;

public class Recherche {

    public static List<Personne> rechercherPersonne(List<Personne> personnel, String terme) {
        List<Personne> resultat = new ArrayList<>();
        String recherche = terme.toLowerCase();

        for (Personne p : personnel) {
            if (p.getId().toLowerCase().contains(recherche)
             || p.getNom().toLowerCase().contains(recherche)
             || p.getPrenom().toLowerCase().contains(recherche)) {
                resultat.add(p);
            }
        }
        return resultat;
    }
}