package methode.genetique;

import villechemin.TourManager;

public class Mediateur {
    
    private Generateur generateur = new Generateur();
    private Generation generation = new Generation(0);
    private Evaluateur evaluateur ;
    private Population<Generation> population = new Population<Generation>();
    private Selecteur selecteur;
    private EntreCroiseur croissement = new EntreCroiseur();

    public void genetique(int nbIndividuGeneration, int nbIteration, Double q, TourManager L) {

        this.generation = this.generateur.getGeneration(nbIndividuGeneration,L);
        this.population.ajouterGeneration(this.generation);
        for(int i = 0; i < nbIteration; i++){

            this.evaluateur = new Evaluateur(generation);

            this.selecteur = new Selecteur(generation);

            generation = this.croissement.getGeneration(generation);

            this.population.ajouterGeneration(generation);
        }

        this.evaluateur = new Evaluateur(this.generation);
        System.out.println("Le meileur individu : "+generation.getMeilleurIndividu());

    }
}
