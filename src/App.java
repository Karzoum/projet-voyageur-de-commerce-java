import methode.genetique.*;
import villechemin.TourManager;
//import villechemin.Ville;

public class App {
    public static void main(String[] args) throws Exception {
        int nb = 500;
        int iteration = 25;
        TourManager newtour = new TourManager();
         
        newtour.ajouterVilleDeDestintion(10);

        for (int i =1 ; i<= 10 ; i++){
            System.out.println(newtour.ObtenirUneVille(i));
        }
        Generateur generer = new Generateur();

        System.out.println(newtour.ObtenirNombreDeVille());

        Generation generation = generer.getGeneration(15, newtour);
        //Evaluateur evaluer = new Evaluateur(generation);

        for(Individu individu : generation.obtenirLesIndividu()){
            System.out.println(individu+"\n");
        }

    }
}
