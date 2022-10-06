package methode.genetique;

import java.util.ArrayList;
import java.util.Comparator;

import villechemin.Ville;
public class Evaluateur {

    private Ville destination = new Ville(-1);
    private Ville courante = new Ville(-1);

    public Evaluateur(Generation generation){

        double distanceLocal = 0.0;

        for(Individu individu :generation.obtenirLesIndividu() ){

            int tailleGenotype = individu.getGenotype().size();

            for(int index = 0; index < tailleGenotype; index ++){

                this.courante = individu.getGenotype().get(index);
                System.out.println(courante);
                
                /*
                 * 
                 * 
                 * if(index +1 < tailleGenotype){
                    this.destination = individu.getGenotype().get(index+1);
                }

                else{

                    this.destination = individu.getGenotype().get(0);
                }

                System.out.println(destination);
                 */
                //distanceLocal += this.courante.distanceEntreVille(destination);
            }
            System.out.println();

            individu.setValeur(distanceLocal);
            double score = 1/distanceLocal;
            individu.setScoreSelection(score);
        }

        ArrayList<Individu> lesIndividu = generation.obtenirLesIndividu();
        comparateur(lesIndividu);

    }

    public void comparateur(ArrayList<Individu> lesIndividu){
        lesIndividu.sort(new Comparator<Individu>(){

            @Override
            public int compare(Individu o1, Individu o2) {
                // TODO Auto-generated method stub
                return (int) (o2.getScoreSelection() - o1.getScoreSelection());
            }

        });
    }

}
