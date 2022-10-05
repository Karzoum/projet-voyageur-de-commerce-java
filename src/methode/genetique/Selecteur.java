package methode.genetique;

import java.util.Comparator;
//import java.util.function.BiConsumer;

public class Selecteur {

   // private BiConsumer<Individu , Integer> selecteurIndividu;

   // private int seuil;
    
    public Generation selectionner(Generation generation) {
        generation.obtenirLesIndividu().sort(new Comparator<Individu>(){

            @Override
            public int compare(Individu o1, Individu o2) {
                // TODO Auto-generated method stub
                return (int) (o2.getScore() - o1.getScore());
            }

        });
        for(int i = generation.nombreDIndividusGeneration()/2; i < generation.nombreDIndividusGeneration() ; i++ ){
            Individu individuLocal = generation.obtenirLesIndividu().get(1);
            generation.enleverIndividu(individuLocal);
        }
        return generation;
    }
}
