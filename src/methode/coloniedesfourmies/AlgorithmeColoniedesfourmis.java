package methode.coloniedesfourmies;

import java.util.ArrayList;

import villechemin.TourManager;
import villechemin.Ville;

public class AlgorithmeColoniedesfourmis {

    private static int k;
    private int nombreDeFourmis;
    private TourManager Villes = new TourManager();
    private int nbIteration;
    
    
    public Ville choixVilleDepart(){
        int index = (int) ((Math.random())*Villes.ObtenirNombreDeVille());
        return Villes.ObtenirUneVille(index);
    }

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

    public double[][] depotPheronome(double distance) {
       double matriceLocale[][] = {{}};
       for(int i = 0; i < Villes.ObtenirNombreDeVille(); i++){
        for(int j = 0; j < Villes.ObtenirNombreDeVille(); j++){
            matriceLocale[i][j] = 1/distance;
        }
       }
       return matriceLocale;
    }

    public void evaporationPheronome(int[][] pheronome){
        for(int i =0; i< Villes.ObtenirNombreDeVille(); i++){
            for(int j = 0; j < Villes.ObtenirNombreDeVille(); j++){
                pheronome[i][j] *= k;
            }
        }
    }

    public Ville choixVilleSuivante(ArrayList<Ville> villes,double[][] pheronome ){

    }
}
