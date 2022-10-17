package affichage;

import java.util.ArrayList;

import methode.recuitsimule.Tour;
import villechemin.TourManager;
import villechemin.Ville;

public class MonRunnable implements Runnable {

    public int nbVilles = Fenetre.nbVilles,
                nbIndividu = Fenetre.nbIndividu,
                nbGeneration = Fenetre.nbGeneration,
                nbMutation = Fenetre.nbMutation;
    public double nbPourcent = Fenetre.nbPourcent;

    public static TourManager lesVilles;
 

    public static ArrayList<Ville> obtenirVilles() {
        return null;
    }

    public static Tour obtenirMeilleurTour() {
        return null;
    }

    @Override
    public void run() {
        
        // TODO Auto-generated method stub
        
    }

}
