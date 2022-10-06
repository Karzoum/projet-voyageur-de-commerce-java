package methode.genetique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.TreeMap;


public class Population<Individus extends Generation> implements Serializable {

    private ArrayList<Individus> lesGenerations = new ArrayList<Individus>();
    
    private NavigableMap<Integer, Integer> resencensement = new TreeMap<Integer, Integer>();

    public void ajouterGeneration(Individus generation){
        this.lesGenerations.add(generation);
    }
    /*
     * public void recencer(Individus generation){
        this.resencensement.put( generation.getNumeroGeneration(), generation.getSommeScore());
    }
     */
    

    public boolean estPopulationDecroissante(){
        int nbGenerationDecroissante = 0;
        if(resencensement.size() > 10){
            for(int i =0; i< 5; i++){
                if(resencensement.descendingMap().get(1) < resencensement.descendingMap().get(i+1))
                    nbGenerationDecroissante ++ ;
            }
        }
        return (nbGenerationDecroissante == 5);
    }
    
    /*
     *  public Population(int nombreDIndividus,boolean initialiser) {
        this.individus = new ArrayList<Individu>();
        if(initialiser){
            for(int i=0 ; i < nombreDIndividus ; i++ ){
                Individu newIndividu = new Individu();
                newIndividu.generateIndividual();
                ajouterUnIndividu( i , newIndividu);
            }
        }
    }

    public Individu getIndividu(int index) {
        return this.individus.get(index);
    }

    public Individu getFitest(){
        Individu plusApteIndividu = this.individus.get(0);

        for(int i = 1; i < obtenirTaillePopulation(); i++ ){
            if(plusApteIndividu.obtenirDistanceTour() > this.individus.get(i).obtenirDistanceTour() ){
                plusApteIndividu = this.individus.get(i);
            }
        }
        return plusApteIndividu;
    }
     */

    public int nbGeneration() {
        return this.lesGenerations.size();
    }
    
}
