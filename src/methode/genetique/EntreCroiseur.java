package methode.genetique;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BiFunction;

public class EntreCroiseur {
    private BiFunction<Individu , Individu, ArrayList<Individu>> fabriqueDescendants;
    
    public Generation getGeneration(Generation generationParent){

        Generation NouvelleGeneration = new Generation(generationParent.getNumeroGeneration());
        generationParent.obtenirLesIndividu().sort(new Comparator<Individu>(){

            @Override
            public int compare(Individu o1, Individu o2) {
                // TODO Auto-generated method stub
                return (int) (o2.getScore() - o1.getScore());
            }

        });

        int index = 0;
        while(NouvelleGeneration.nombreDIndividusGeneration() < 50 && index < generationParent.nombreDIndividusGeneration() -1){
            NouvelleGeneration.ajouterGroupeIndividu(fabriqueDescendants.apply(generationParent.obtenirLesIndividu().get(index), generationParent.obtenirLesIndividu().get(index +1)));
            index += 2;
        }

        return NouvelleGeneration;
        
        //Individu parent1 = generationParent.obtenirLesIndividu().get(0);
        //Individu parent2 = generationParent.obtenirLesIndividu().get(1);
        //int pointDeCroisement = (int) (parent1.getGeneIndividu().size()* Math.random());
        
    }
}

        /*
        *   int tourPos1 = (int) (newSolution.tourNombreDeVille() * Math.random());
            int tourPos2 = (int) (newSolution.tourNombreDeVille() * Math.random());
    
            Ville villeHasard1 = newSolution.obtenirUneVilleVisiter(tourPos1);
            Ville villeHasard2 = newSolution.obtenirUneVilleVisiter(tourPos2);
    
            newSolution.ajouterUneVillePosition(tourPos2, villeHasard1);
            newSolution.ajouterUneVillePosition(tourPos1, villeHasard2);
            
             *     if(solutionCourante.obtenirDistanceTour() < newSolution.obtenirDistanceTour()){
             *  newSolution = new Tour(solutionCourante.obtenirTour())
             *  }
             * 
             */
         