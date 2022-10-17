package affichage;

import java.util.ArrayList;
//import java.util.Vector;

import methode.genetique.*;
import methode.recuitsimule.Tour;
import villechemin.TourManager;
import villechemin.Ville;

public class GeneRunnable implements Runnable {

    public int nbVilles = Fenetre.nbVilles,
                nbIndividu = Fenetre.nbIndividu,
                nbGeneration = Fenetre.nbGeneration,
                nbMutation = Fenetre.nbMutation;
    public double nbPourcent = Fenetre.nbPourcent;
    public int a = 0;

    public static Individu meilleur = new Individu();

    public ArrayList<Ville> lesVille;

    public static ArrayList<Ville> obtenirVilles() {
        return meilleur.getGenotype();
    }

    public static Tour obtenirMeilleurTour() {
        Tour tr = new Tour(meilleur.getGenotype());
        return tr;
    }
    
    @Override
    public void run() {

        lesVille = Fenetre.lesVilles;
        Selecteur selecteur = new Selecteur();
        EntreCroiseur croiseur = new EntreCroiseur();
        long time = System.currentTimeMillis();

        Population<Generation> population = new Population<Generation>();

        Generateur generateur = new Generateur();

        Evaluateur evaluateur = new Evaluateur();

        Generation generation = generateur.getGeneration(nbIndividu, lesVille);

        population.ajouterGeneration(generation);

        do{
            Generation newGeneration = new Generation(generation.getNumeroGeneration()+1);
            
            evaluateur.evaluer(generation);

            for(int i = 0; i < nbIndividu/2 ; i ++){

                Individu papa =selecteur.Selection(generation);
                Individu maman = selecteur.Selection(generation);
                ArrayList<Individu> lesEnfants = new ArrayList<Individu>();
                lesEnfants.addAll(croiseur.crossOver(papa, maman));
                if((double) Math.round(Math.random()*100) <= nbPourcent){
                    for(int j = 0; j < nbMutation; j++){
                        Mutateur mutateur = new Mutateur(lesEnfants.get(0));
                        lesEnfants.set(0, mutateur.obtenirMutant());
                        Mutateur mutateur2 = new Mutateur(lesEnfants.get(1));
                        lesEnfants.set(1, mutateur2.obtenirMutant());
                    }
                }
                newGeneration.ajouterGroupeIndividu(lesEnfants);
            }
            generation = newGeneration;
            a++;
        }while(a < nbGeneration);

        long dureeTotal = (System.currentTimeMillis() - time);
        final int min = (int) (dureeTotal /(60*1000F));
        final int sec = (int) ((dureeTotal %(60*1000F))/1000F);

            evaluateur.evaluer(generation);
            meilleur = generation.getMeilleurIndividu();
    
    }

}
