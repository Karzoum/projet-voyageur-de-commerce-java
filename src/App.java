import methode.genetique.*;
import villechemin.TourManager;
//import villechemin.Ville;

public class App {
    public static void main(String[] args) throws Exception {
        int nb = 500;
        int iteration = 25;
        
        TourManager newtour = new TourManager();
        newtour.ajouterVilleDeDestintion(5);
        Generateur generer = new Generateur();

        Generation generation = generer.getGeneration(5, newtour);

        for(Individu individu : generation.obtenirLesIndividu()){
            System.out.println(individu+"\n");
        }

        Evaluateur evaluer = new Evaluateur(generation);

        for(Individu individu : generation.obtenirLesIndividu()){
            System.out.println(individu+"\n");
        }

    }
}
