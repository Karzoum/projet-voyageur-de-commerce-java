package methode.recuitsimule;

import java.util.ArrayList;

import villechemin.*;

public class RecuitSimule {

    private ArrayList<Ville> lesVilles = new ArrayList<Ville>();
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


    public void recuitsimulee(double tauxRefroidissement,ArrayList<Ville> tourManager,Double temp){
        this.lesVilles=tourManager;
        this.temp = temp;
        
        Tour solutionCourante=new Tour();

        Transformeur transformeur = new Transformeur();

        solutionCourante.generateIndividual(lesVilles);

        System.out.println(" Distance initiale de la solution"+ solutionCourante);
        Tour meilleur = new Tour(solutionCourante.obtenirTour());

        while( temp > 1){
            // R <- Tweak(Copy(S))
            Tour newSolution = new Tour(transformeur.transforme(solutionCourante));
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
