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

        Generation generation = generer.getGeneration(15, newtour);

        for(Individu individu : generation.obtenirLesIndividu()){
            System.out.println(individu+"\n");
        }

        Evaluateur evaluer = new Evaluateur(generation);

        for(Individu individu : generation.obtenirLesIndividu()){
            System.out.println(individu.getValeur()+"\n");
        }
        
        Selecteur select = new Selecteur();
        for(int i =0;i<5;i++){
        Individu  I1 = select.Selection(generation);

        System.out.println(I1);
        }

    }
}
