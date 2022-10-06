package methode.genetique;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import villechemin.Ville;
public class Evaluateur {

    public Evaluateur(Generation generation){

        double distanceLocal = 0.0;

        for(Individu individu :generation.obtenirLesIndividu() ){

            for(int index = 0; index < individu.getGenotype().size();index ++){
                Ville villeCourante = individu.getGenotype().get(index);
                Ville villeDestination ;
                
                if(index+1 < individu.getGenotype().size()){
                    villeDestination = individu.getGenotype().get(index+1);
                }

                else{
                    villeDestination = individu.getGenotype().get(0);

                distanceLocal += villeCourante.distanceEntreVille(villeDestination);
            }
            individu.setValeur(distanceLocal);
            double score = 1/distanceLocal;
            individu.setScoreSelection(score);
        }

    }

    public void comparateur(ArrayList<Individu> lesIndividu){
        Collection.sort(lesIndividu , new Comparator<Individu>(){

            @Override
            public int compare(Individu o1, Individu o2) {
                // TODO Auto-generated method stub
                return 0;
            }

        }
    }

}
