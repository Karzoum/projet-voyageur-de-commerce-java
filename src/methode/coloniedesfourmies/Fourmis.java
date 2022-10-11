package methode.coloniedesfourmies;

import java.util.ArrayList;

import villechemin.Ville;

public class Fourmis {

    private ArrayList<Trajet> trajetEmprute;
    Ville villeLocale;

    public Ville getVilleDepart(ArrayList<Ville> lesVilles){
        int n = (int) (Math.random() * lesVilles.size());
        for(Ville ville : lesVilles){
            if(n == ville.getNumVille()){
                villeLocale = ville;
            }
        }
        return villeLocale;
    }
}
