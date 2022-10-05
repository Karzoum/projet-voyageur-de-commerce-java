package methode.recuitsimule;

import java.util.Collections;

import villechemin.*;

public class RecuitSimule {

    private TourManager tour=new TourManager();
    private double temp;
    private double lamda;

    public static double probabiliteDacceptation(int energy, int newEnergy, Double temperature) {
        if(newEnergy<energy){
            return 1.0;
        }
        else{
            return Math.exp(-(newEnergy-energy)/temperature);
        }
    }

    public Tour transformation(Tour solutionCourante){
        Tour newSolution = new Tour(solutionCourante.obtenirTour());

            int tourPos1 = (int) (newSolution.tourNombreDeVille() * Math.random());
            int tourPos2 = (int) (newSolution.tourNombreDeVille() * Math.random());

            Ville villeHasard1 = newSolution.obtenirUneVilleVisiter(tourPos1);
            Ville villeHasard2 = newSolution.obtenirUneVilleVisiter(tourPos2);

            newSolution.ajouterUneVillePosition(tourPos2, villeHasard1);
            newSolution.ajouterUneVillePosition(tourPos1, villeHasard2);
        /*
         *     if(solutionCourante.obtenirDistanceTour() < newSolution.obtenirDistanceTour()){
         *  newSolution = new Tour(solutionCourante.obtenirTour())
         *  }
         * 
         */
        return newSolution;
    }
    public void recuitsimulee(){
        Tour solutionCourante=new Tour();

        solutionCourante.generateIndividual();

        System.out.println(" Distance initiale de la solution"+ solutionCourante);
        Tour meilleur = new Tour(solutionCourante.obtenirTour());

        while( temp > 1){
            
        }

    }

    /*public Tour recuitsimule(double T,double T_0,double lamda,int nombreIteration,TourManager tourManager){
        Tour trajetInitiale = new Tour();
        trajetInitiale.generateIndividual();
        
        for(int i = 0; i < nombreIteration; i++){
            while(T > T_0){
                
            }
        }
    }
    */
}
