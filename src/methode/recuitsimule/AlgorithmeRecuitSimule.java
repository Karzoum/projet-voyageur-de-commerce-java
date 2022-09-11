package methode.recuitsimule;

import java.util.Collections;

import villechemin.*;

public class AlgorithmeRecuitSimule {

    private TourManager tourManager=new TourManager();

    public static double probabiliteDacceptation(int energy, int newEnergy, Double temperature) {
        if(newEnergy<energy){
            return 1.0;
        }

        Double temp = 10000.0;
        Double tauxRef = 0.003;
 
        Individu solutionCourante=new Individu();

        solutionCourante.generateIndividual();

        System.out.println(" Distance initiale de la solution"+ solutionCourante);
        Individu meilleur = new Individu(solutionCourante.obtenirTour());

        while( temp > 1){
            Individu newSolution = new Individu(solutionCourante.obtenirTour());

            int tourPos1 = (int) (newSolution.tourNombreDeVille() * Math.random());
            int tourPos2 = (int) (newSolution.tourNombreDeVille() * Math.random());

            Ville villeHasard1 = newSolution.obtenirUneVilleVisiter(tourPos1);
            Ville villeHasard2 = newSolution.obtenirUneVilleVisiter(tourPos2);

            newSolution.ajouterUneVillePosition(tourPos2, villeHasard1);
            newSolution.ajouterUneVillePosition(tourPos1, villeHasard2);

            if(solutionCourante.obtenirDistanceTour() < meilleur.obtenirDistanceTour()){
                meilleur = new Individu(solutionCourante.obtenirTour());
            }
        }

    }
}
