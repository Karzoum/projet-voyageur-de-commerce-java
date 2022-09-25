package methode.genetique;

import villechemin.Ville;
public class Evaluateur {

    public void evaluateur(Generation generation){
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
                }

                distanceLocal += villeCourante.distanceEntreVille(villeDestination);
            }
            individu.setValeur(distanceLocal);
        }
    }

}
