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

        Evaluateur evaluer = new Evaluateur();
        evaluer.evaluer(generation);

        for(Individu individu : generation.obtenirLesIndividu()){
            System.out.println(individu.getValeur()+"\n");
        }
        
        Selecteur select = new Selecteur();
        for(int i =0;i<10;i++){
        Individu  I1 = select.Selection(generation);

        System.out.println(I1+"\n \n");
        }

        Mediateur media = new Mediateur();
        
        media.genetique(30, 15, 0.01, newtour);

    }
}
