package affichage;

import java.util.ArrayList;

import methode.recherchetabou.*;
import villechemin.*;

public class TabouRunnable implements Runnable{

    public int nbVilles = Fenetre.nbVilles, tailleTabuList = Fenetre.tailleTL,
                nbIteration = Fenetre.nbIteration, nb = Fenetre.nbTransf;
    public ArrayList<Ville> lesVilles = Fenetre.lesVilles;

private Trajet meilleur = null;
    private ArrayList<Trajet> tabuList;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        long time = System.currentTimeMillis();

        int n = 0;
        Trajet solution = new Trajet();
        Transformateur transformateur = new Transformateur();
        Comparateur comparateur = new Comparateur();
        solution.generateIndividual(lesVilles);
        meilleur = solution ;
        tabuList.add(solution);
        do{
            if(tabuList.size() > tailleTabuList){
                tabuList.remove(0);
            }
            ArrayList<Ville> enfant = transformateur.transformer(solution);
            Trajet solution2 = new Trajet(enfant);
            for(int m = 0; m < nb; m++){

                Trajet Solution3 = new Trajet(transformateur.transformer(solution));
                if(!comparateur.estTabu(tabuList, Solution3) && Solution3.plusCourtTour(solution2)){
                    solution2 = Solution3;
                }
            }
            if(!comparateur.estTabu(tabuList, solution2)){
                solution = solution2;
                tabuList.add(solution2);
            }
            if(meilleur == null || solution.plusCourtTour(meilleur)){
                meilleur = solution;
            }
            nbIteration ++;

        }while( n < nbIteration);
        long dureeTotal = (System.currentTimeMillis() - time);
        final int min = (int) (dureeTotal /(60*1000F));
        final int sec = (int) ((dureeTotal %(60*1000F))/1000F);

    }

    public Trajet obtenirMeilleur(){
        return this.meilleur;
    }
    
}
