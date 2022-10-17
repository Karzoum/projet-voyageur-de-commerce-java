package methode.genetique;

import java.util.ArrayList;

import villechemin.TourManager;

public class Mediateur {
    
    private Generateur generateur = new Generateur();
    private Generation generation = new Generation(0);
    private Evaluateur evaluateur = new Evaluateur();
     ;
    private Population<Generation> population = new Population<Generation>();
    private Selecteur selecteur = new Selecteur();
    private Mutateur mutateur;
      private EntreCroiseur croissement = new EntreCroiseur();
    private Individu lePlusApte = new Individu();
    private int tailleGeneration = 0 ;

    public void genetique(int nbIndividuGeneration, int nbIteration, Double q, TourManager L) {

        this.generation = this.generateur.getGeneration(nbIndividuGeneration,L);
        this.lePlusApte = this.generation.getMeilleurIndividu();


        for(int i = 0; i < nbIteration; i++){

            this.population.ajouterGeneration(this.generation);
            this.evaluateur.evaluer(generation);
            Generation nouvelGeneration = new Generation(this.generation.getNumeroGeneration()+1);

            for(int n = (int) tailleGeneration/2; n < tailleGeneration ; n++){

                Individu papa = this.selecteur.Selection(generation);
                Individu maman = this.selecteur.Selection(generation);

                ArrayList<Individu> lesEnfants = new ArrayList<Individu>();
                lesEnfants.addAll(this.croissement.crossOver(papa, maman));

                Individu enfant1 = lesEnfants.get(0);
                Individu enfant2 = lesEnfants.get(1);

                this.mutateur = new Mutateur(enfant1);
                enfant1 = this.mutateur.obtenirMutant();

                this.mutateur = new Mutateur(enfant2);
                enfant2 = this.mutateur.obtenirMutant();

                lesEnfants.set(0, enfant1);
                lesEnfants.set(1, enfant2);

                nouvelGeneration.ajouterGroupeIndividu(lesEnfants);

            }

            this.generation = nouvelGeneration;

        }

        this.evaluateur.evaluer(generation);
        this.lePlusApte = this.generation.getMeilleurIndividu();
        System.out.println("Le meileur individu : "+lePlusApte);

    }
}
