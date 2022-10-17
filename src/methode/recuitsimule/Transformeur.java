package methode.recuitsimule;

import java.util.ArrayList;

import villechemin.Ville;

public class Transformeur {
    public ArrayList<Ville> transforme(Tour tour){
        ArrayList<Ville> newSolution = tour.obtenirTour();

            int tourPos1 = (int) (newSolution.size() * Math.random());
            int tourPos2 = (int) (newSolution.size() * Math.random());

            Ville villeHasard1 = newSolution.get(tourPos1);
            Ville villeHasard2 = newSolution.get(tourPos2);

            newSolution.add(tourPos2, villeHasard1);
            newSolution.add(tourPos1, villeHasard2);
        
        return newSolution;
    }
}
