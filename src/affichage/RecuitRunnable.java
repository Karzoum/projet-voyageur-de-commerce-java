package affichage;

import java.util.ArrayList;

import methode.recuitsimule.Tour;
import methode.recuitsimule.Transformeur;
import villechemin.*;

public class RecuitRunnable implements Runnable {

    public int nbVille = Fenetre.nbVilles, initTemp = Fenetre.initTemp,
            tauxRef = Fenetre.tauxRef, critTemp = Fenetre.critTemp;
    public ArrayList<Ville> lesVilles = Fenetre.lesVilles;

    private Tour meilleur;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Transformeur transformeur = new Transformeur();
        Tour solutionCourante = new Tour();
        solutionCourante.generateIndividual(lesVilles);

        meilleur = new Tour(solutionCourante.obtenirTour());
        while (initTemp > critTemp) {
            Tour newSolution = new Tour(transformeur.transforme(solutionCourante));

            if (solutionCourante.EnergyTour() < newSolution.EnergyTour()) {
                solutionCourante = newSolution;
            } else {
                double p = (Math.random() * 1);
                if (p < Math.exp(-(newSolution.EnergyTour() - solutionCourante.EnergyTour()) / initTemp)) {
                    solutionCourante = newSolution;
                }
            }
            if (meilleur==null || solutionCourante.EnergyTour() < meilleur.EnergyTour()) {
                meilleur = solutionCourante;
            }
            initTemp *= (1 - tauxRef);
        }
    }

    public Tour obtenirMeilleurTour(){
        return meilleur;
    }
}
