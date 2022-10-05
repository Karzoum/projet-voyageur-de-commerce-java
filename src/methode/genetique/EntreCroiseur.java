package methode.genetique;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;
import java.util.function.BiFunction;

import villechemin.Ville;

public class EntreCroiseur {
    private BiFunction<Individu , Individu, ArrayList<Individu>> fabriqueDescendants;
    
    public Generation getGeneration(Generation generationParent){

        Generation NouvelleGeneration = new Generation(generationParent.getNumeroGeneration() +1 );
        generationParent.obtenirLesIndividu().sort(new Comparator<Individu>(){

            @Override
            public int compare(Individu o1, Individu o2) {
                // TODO Auto-generated method stub
                return (int) (o2.getScore() - o1.getScore());
            }

        });

        int index = 0;
        while(NouvelleGeneration.nombreDIndividusGeneration() < 50 && index < generationParent.nombreDIndividusGeneration() -1){
            
            crossOver(generationParent.obtenirLesIndividu().get(index), generationParent.obtenirLesIndividu().get(index + 1));
            NouvelleGeneration.ajouterGroupeIndividu(fabriqueDescendants.apply(generationParent.obtenirLesIndividu().get(index), generationParent.obtenirLesIndividu().get(index +1)));
            index += 2;
        }

        return NouvelleGeneration;
        
        //Individu parent1 = generationParent.obtenirLesIndividu().get(0);
        //Individu parent2 = generationParent.obtenirLesIndividu().get(1);
        //int pointDeCroisement = (int) (parent1.getGeneIndividu().size()* Math.random());
        
    }

    public void crossOver(Individu parent1,Individu parent2){
        int indexParent1 = 0;
        int indexParent2 = 0;
        Vector<Integer> gene1 = parent1.getGeneIndividu();
        Vector<Integer> gene2 = parent2.getGeneIndividu();
        ArrayList<Ville> genotype1 = parent1.getGenotype();
        ArrayList<Ville> genotype2 = parent1.getGenotype();

       for(int i = 0; i < 3; i++){
        indexParent1 = (int) (parent1.getGeneIndividu().size() * Math.random());
        indexParent2 = (int) (parent2.getGeneIndividu().size() * Math.random());

        int g1 = gene1.get(indexParent1);
        int g2 = gene2.get(indexParent2);

        Ville villesP1 = genotype1.get(indexParent1);
        Ville villesP2 = genotype2.get(indexParent2);
        gene1.add(indexParent1, g2);
        gene2.add(indexParent2, g1);
        genotype1.add(indexParent1, villesP2);
        genotype2.add(indexParent2, villesP1);

        parent1.setGeneIndividu(gene1);
        parent1.setGenotype(genotype1);
        
        parent2.setGeneIndividu(gene2);
        parent2.setGenotype(genotype2);
       }

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
         