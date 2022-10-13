package methode.recherchetabou;

import java.util.ArrayList;

import villechemin.Ville;

public class Transformateur {

    public ArrayList<Ville> transformer(Trajet trajet){

        ArrayList<Ville> newSolution = trajet.obtenirTour();

            int tourPos1 = (int) (newSolution.size() * Math.random());
            int tourPos2 = (int) (newSolution.size() * Math.random());

            Ville villeHasard1 = newSolution.get(tourPos1);
            Ville villeHasard2 = newSolution.get(tourPos2);

            newSolution.add(tourPos2, villeHasard1);
            newSolution.add(tourPos1, villeHasard2);

        return newSolution;
    }
}
