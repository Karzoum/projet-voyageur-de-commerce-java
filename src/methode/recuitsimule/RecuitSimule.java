package methode.recuitsimule;

import java.util.ArrayList;

import villechemin.*;

public class RecuitSimule {

    private TourManager lesVilles = new TourManager();
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

    public ArrayList<Ville> transformation(Tour solutionCourante){
        ArrayList<Ville> newSolution = solutionCourante.obtenirTour();

            int tourPos1 = (int) (newSolution.size() * Math.random());
            int tourPos2 = (int) (newSolution.size() * Math.random());

            Ville villeHasard1 = newSolution.get(tourPos1);
            Ville villeHasard2 = newSolution.get(tourPos2);

            newSolution.add(tourPos2, villeHasard1);
            newSolution.add(tourPos1, villeHasard2);
        
        return newSolution;
    }

    public void recuitsimulee(double tauxRefroidissement,TourManager tourManager,Double temp){
        this.lesVilles=tourManager;
        this.temp = temp;
        Tour solutionCourante=new Tour();

        solutionCourante.generateIndividual(lesVilles);

        System.out.println(" Distance initiale de la solution"+ solutionCourante);
        Tour meilleur = new Tour(solutionCourante.obtenirTour());

        while( temp > 1){
            // R <- Tweak(Copy(S))
            Tour newSolution = new Tour(transformation(solutionCourante));
            if(solutionCourante.EnergyTour() < newSolution.EnergyTour()){
                solutionCourante = newSolution;
            }
            else{
                double p = (Math.random() * 1);
                if(p < Math.exp(- (newSolution.EnergyTour()-solutionCourante.EnergyTour())/temp)){
                    solutionCourante = newSolution;
                }
            }
            if(solutionCourante.EnergyTour() < meilleur.EnergyTour()){
                meilleur = solutionCourante;
            }
            temp += (1-lamda) * tauxRefroidissement;
        }
        System.out.println(" Distance initiale de la solution"+ meilleur);

    }

}
