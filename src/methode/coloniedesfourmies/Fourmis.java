package methode.coloniedesfourmies;

import java.util.ArrayList;

//import villechemin.Tour;
import villechemin.TourManager;
import villechemin.Ville;

public class Fourmis {
    
    private ArrayList<Ville> lesVillesVisite = new ArrayList<Ville>();
    private TourManager villes;

    public Fourmis(TourManager tourManager) {
        villes = tourManager;
        /*
         * for(int i =0; i < villes.ObtenirNombreDeVille(); i++){
            this.lesVillesVisite.add(null);
        }
         */
    }

    public void visiterUneVille(int index,Ville ville){
        this.lesVillesVisite.add(index,ville);
    }

    public boolean visiter(Ville ville){
        return visiter(ville);
    }

    public Double distanceParcourue(){
        Double distance = (double) 0;
        for(int i= 0; i< lesVillesVisite.size() ; i++){
            distance += lesVillesVisite.get(i).distanceEntreVille(lesVillesVisite.get(i+1));
        }
        return distance;
    }

    public Ville choixVilleDepart(){
        int index = (int) ((Math.random())*villes.ObtenirNombreDeVille());
        return villes.ObtenirUneVille(index);
    }

    public void choisirVilleSuivante(){

    }

    public double[][] depotPheronome(double[][] pheronome) {
        for(int i = 0; i < villes.ObtenirNombreDeVille(); i++){
         for(int j = 0; j < villes.ObtenirNombreDeVille(); j++){
             Double getDistance = 0.0;
             if (i != j){
             getDistance = lesVillesVisite.get(i).distanceEntreVille(lesVillesVisite.get(j));

             pheronome[i][j] = 1/getDistance;
             pheronome[j][i] = 1/getDistance;
             }
         }
        }
        return pheronome;
     }

     public double probabiliterVille(int alpha,int beta){
        double proba = 0.0;
        return proba;
     }
}
