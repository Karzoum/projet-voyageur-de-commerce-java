package methode.genetique;

import java.util.ArrayList;

import villechemin.*;

public class Population {

    private ArrayList<Ville> Villes;
    private ArrayList<Individu> individus;

    public Population(int nombreDIndividus,boolean initialiser) {
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

    private int obtenirTaillePopulation() {
        return this.individus.size();
    }


    private void ajouterUnIndividu(int i, Individu newIndividu) {
        this.individus.add(i, newIndividu);
    }
    
}
