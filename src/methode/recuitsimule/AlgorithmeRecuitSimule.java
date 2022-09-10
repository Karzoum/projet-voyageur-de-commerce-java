package methode.recuitsimule;

import java.util.ArrayList;
import java.util.Vector;

import villechemin.*;

public class AlgorithmeRecuitSimule {
    private ArrayList<Ville> Villes;

    /**
     * @param villes
     */
    public AlgorithmeRecuitSimule(ArrayList<Ville> villes) {
        Villes = villes;
    }

    public void genererTrajetInitiak() {
        
    }

    public Double getDistance() {
        Double distance = 0;
        for (int index = 0; index < travel.size(); index++) {
            Ville starting = getCity(index);
            Ville destination;
            if (index + 1 < travel.size()) {
                destination = getCity(index + 1);
            } else {
                destination = getCity(0);
            }
                distance += starting.distanceEntreVille(destination);
        }
        return distance;
    }

    private Ville getCity(int index) {
        return this.Villes.get(index);
    }
}
