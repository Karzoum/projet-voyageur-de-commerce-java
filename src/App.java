import methode.genetique.Mediateur;
import villechemin.TourManager;
//import villechemin.Ville;

public class App {
    public static void main(String[] args) throws Exception {
        int nb = 500;
        int iteration = 25;
        TourManager newtour = new TourManager();
        newtour.ajouterVilleDeDestintion(15);
        for (int i =0 ; i< 15 ; i++){
            System.out.println(newtour.ObtenirUneVille(i));
        }
        System.out.println("");
        Mediateur m = new Mediateur();
        m.genetique(nb, iteration, 0.01, newtour);
    }
}
