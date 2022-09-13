package methode.coloniedesfourmies;

import java.util.ArrayList;

import villechemin.Tour;
import villechemin.TourManager;
import villechemin.Ville;

public class Fourmis {
    
    private ArrayList<Ville> lesVillesVisite = new ArrayList<Ville>();

    public Fourmis() {
        for(int i =0; i < TourManager.ObtenirNombreDeVille(); i++){
            this.lesVillesVisite.add(null);
        }
    }

    public void visiterUneVille(int index,Ville ville){
        this.lesVillesVisite.add(index,ville);
        visiter(ville) = true;
    }

    public boolean visiter(Ville ville){
        return visiter(ville);
    }


    public Double distanceParcourue(){
        int distance = 0;
        for(int i= 0; i< lesVillesVisite.size() ; i++){

        }
    }

    public Ville choisirVilleDepart(){
        return ;
    }

    public void choisirVilleSuivante(){

    }

}
