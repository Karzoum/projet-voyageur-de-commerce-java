package methode.coloniedesfourmies;

import java.util.ArrayList;

import villechemin.TourManager;
import villechemin.Ville;

public class AlgorithmeColoniedesfourmis {

    private static int k;
    private int nombreDeFourmis;
    private TourManager Villes = new TourManager();
    private int nbIteration;
    
   
    public double[][] initialiserPheronome() {
        double matriceLocale[][] = {{}} ;
        for(int i = 0; i < Villes.ObtenirNombreDeVille() ; i++){
            for(int j = 0; j < Villes.ObtenirNombreDeVille() ; j++){
                matriceLocale[i][j]=0.0;
            }
        }
        return matriceLocale;
    }

    public ArrayList<Ville> enleverVille(Ville ville,ArrayList<Ville> listeVille){
        listeVille.remove(ville);
        return listeVille;
    }


    public void evaporationPheronome(Double[][] pheronome){
        for(int i =0; i< Villes.ObtenirNombreDeVille(); i++){
            for(int j = 0; j < Villes.ObtenirNombreDeVille(); j++){
                pheronome[i][j] *= k;
            }
        }
    }
}
