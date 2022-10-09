package methode.coloniedesfourmies;

import java.util.ArrayList;

import villechemin.*;
public class Colonie_des_fourmis {
    private ArrayList<Ville> composantes;
    private int nomberFourmis;
    private double tauxApprentissage;
    private double tauxEvaporation;
    private double valIniPhero;
    private double heurC;
    private double pheroC;
    private int t;
    private double q;
    private double[][] pheromoneComposants;
    private Tour meilleur;

    public Colonie_des_fourmis(Double val){
        for(int i =0; i < composantes.size(); i++ ){
            for(int j =0; j<composantes.size(); j++){
                pheromoneComposants[i][j] = val;
                pheromoneComposants[j][i] = val;
            }
        }
    }

    public void trouverChemin(){
        this.meilleur = new Tour(); 

    }
}
