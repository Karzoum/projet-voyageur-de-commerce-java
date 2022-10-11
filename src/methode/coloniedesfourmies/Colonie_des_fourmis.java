package methode.coloniedesfourmies;

import java.util.ArrayList;

import villechemin.*;
public class Colonie_des_fourmis {
    private ArrayList<Trajet> composantes;
    private int nomberFourmis;
    private double tauxApprentissage;
    private double tauxEvaporation;
    private double valIniPhero;
    private double heurC;
    private double pheroC;
    private int t;
    private double q;
    private ArrayList<Trajet> meilleurSentier;
/* 
    public void colonie_des_fourmis(TourManager lesVilles,int nombreFourmis,double alpha,double gamma,double beta,double eta,double epsillon,int t,double q){
        this.composantes = this.InitialiserLescomposant(lesVilles,gamma);
        this.meilleurSentier = new ArrayList<Trajet>();
        do{
            for(int i = 0; i < nombreFourmis; i++){
                ArrayList<Trajet> S = new ArrayList<Trajet>();
                do{
                    this.composantes.removeAll(S);
                    ArrayList<Trajet> C = this.composantes;
                    if(C.isEmpty()){
                        S = new ArrayList();
                    }
                    else{
                       // S = S.add(null);
                    }
                }while();



            }            
        }

    }
*/
    public Ville SelectionnerVille(ArrayList<Ville> Destination,Double[][] pheromones){
        for(Ville ville : Destination){
           // if();
        }
        return null;
    }

    public ArrayList<Trajet> InitialiserLescomposant(TourManager lesVilles, double gamma){
        ArrayList<Trajet> C = new ArrayList<>();
        for(int i = 0; i < lesVilles.ObtenirNombreDeVille(); i++){
            for(int j = 0 ; j < lesVilles.ObtenirNombreDeVille(); j ++){

                Trajet tr = new Trajet(lesVilles.ObtenirUneVille(i), lesVilles.ObtenirUneVille(j),gamma);
                C.add(tr);
            }
        }
        return C;
    }

}
