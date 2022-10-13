package methode.recherchetabou;

import java.util.ArrayList;

import villechemin.*; 
public class Mediateur_R_T {

    private Transformateur transformateur= new Transformateur();
    private Comparateur comparateur = new Comparateur();
    private Trajet meilleur ;
    private ArrayList<Trajet> tabuList = new ArrayList<Trajet>();

    public void recherchetabou(TourManager lesVilles, int nb, int tailleTabuList, int nbIteration){
        int n = 0;
        Trajet solution = new Trajet();
        solution.generateIndividual(lesVilles);
        meilleur = solution ;
        tabuList.add(solution);
        do{
            if(tabuList.size() > tailleTabuList){
                tabuList.remove(0);
            }
            ArrayList<Ville> enfant = this.transformateur.transformer(solution);
            Trajet solution2 = new Trajet(enfant);
            for(int m = 0; m < nb; m++){

                Trajet Solution3 = new Trajet(transformateur.transformer(solution));
                if(!this.comparateur.estTabu(tabuList, Solution3) && Solution3.plusCourtTour(solution2)){
                    solution2 = Solution3;
                }
            }
            if(!this.comparateur.estTabu(tabuList, solution2)){
                solution = solution2;
                tabuList.add(solution2);
            }
            if(solution.plusCourtTour(meilleur)){
                meilleur = solution;
            }
            nbIteration ++;

        }while( n < nbIteration);
        System.out.println(" Distance initiale de la solution"+ meilleur);

    }

}

