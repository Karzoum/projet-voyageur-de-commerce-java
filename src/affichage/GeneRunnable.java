package affichage;

import java.util.ArrayList;
//import java.util.Vector;

import methode.genetique.*;
import methode.recuitsimule.Tour;
import villechemin.Ville;

public class GeneRunnable implements Runnable {

    public int nbVilles = Fenetre.nbVilles,
                nbIndividu = Fenetre.nbIndividu,
                nbGeneration = Fenetre.nbGeneration,
                nbMutation = Fenetre.nbMutation;
    public double nbPourcent = Fenetre.nbPourcent;
    public int a = 0;

    private static Individu meilleur;

    public static Individu getMeilleur() {
        return meilleur;
    }

    public static void setMeilleur(Individu meilleur) {
        GeneRunnable.meilleur = meilleur;
    }

    private static ArrayList<Ville> lesVille;

    public static ArrayList<Ville> obtenirVilles() {
        return lesVille;
    }

    public static Tour obtenirMeilleurTour() {
        Tour tr = new Tour(meilleur.getGenotype());
        return tr;
    }
    
    @Override
    public void run() {

        Selecteur selecteur = new Selecteur();
        EntreCroiseur croiseur = new EntreCroiseur();
        long time = System.currentTimeMillis();

        Population<Generation> population = new Population<Generation>();

        Generateur generateur = new Generateur();

        Evaluateur evaluateur = new Evaluateur();

        Generation generation = generateur.getGeneration(nbIndividu, lesVille);

        population.ajouterGeneration(generation);
       /*
SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fenetre.setInfoArea("Population créée !");	
				try {AG.frame.repaint();}catch(NullPointerException e){Fenetre.frame.repaint();}
			}
		});
        */ 
        setMeilleur(null);
        lesVille = Fenetre.lesVilles;
        /*
         * SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fenetre.setInfoArea("Population créée !");	
				try {AG.frame.repaint();}catch(NullPointerException e){Fenetre.frame.repaint();}
			}
		});
         */

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
            evaluateur.evaluer(newGeneration);
            if(meilleur == null){
                setMeilleur(newGeneration.getMeilleurIndividu());

               /*
                *  SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Fenetre.setInfoArea("Meilleur à la génération n° "+a+" au numéro "+meilleur.getNumindividu()+" : "+meilleur.getGeneIndividu()+", longueur : "+meilleur.getValeur());
						try {frame.repaint();}catch(NullPointerException e){Fenetre.frame.repaint();}
					}
				});
                */  
            }
            generation = newGeneration;
            population.ajouterGeneration(generation);
            a++;
        }
        while(a < nbGeneration);
        setMeilleur(generation.getMeilleurIndividu()); 

        System.out.println(meilleur.getNumindividu());

        long dureeTotal = (System.currentTimeMillis() - time);
        final int min = (int) (dureeTotal /(60*1000F));
        final int sec = (int) ((dureeTotal %(60*1000F))/1000F);
        
    }

}
