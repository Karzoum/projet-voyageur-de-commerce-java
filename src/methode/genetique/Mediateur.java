package methode.genetique;

import villechemin.TourManager;

public class Mediateur {
    
    private Generateur generateur;
    private Generation generation;
    private Evaluateur evaluateur;
    private Population<Generation> population;
    private Selecteur selecteur ;
    private EntreCroiseur croissement;

    public void genetique(int nbIndividuGeneration, int nbIteration, Double q, TourManager L) {

        this.generation = this.generateur.generation(nbIndividuGeneration,L);
        this.population.ajouterGeneration(this.generation);
        for(int i = 0; i < nbIteration; i++){

            this.evaluateur.evaluateur(generation);

            generation = this.selecteur.selectionner(generation);

            generation = this.croissement.getGeneration(generation);

            this.population.ajouterGeneration(generation);
        }

        this.evaluateur.evaluateur(this.generation);
        System.out.println(generation.getMeilleurIndividu());

    }
}
