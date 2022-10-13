package methode.recherchetabou;

import java.util.ArrayList;

public class Comparateur {

    public boolean comparer(Trajet trajet1,Trajet trajet2){
        boolean b = false ;
        for(int i = 0; i < trajet1.tourNombreDeVille();i++){
            for(int j = 0; j < trajet2.tourNombreDeVille();j++){
                if(i == j && trajet1.obtenirUneVilleVisiter(i).getNumVille() == trajet2.obtenirUneVilleVisiter(j).getNumVille()){
                    b = true;
                }
            }
        }
        return b;
    }
    public boolean estTabu(ArrayList<Trajet> tabuList,Trajet trajet){
        boolean a = false ;
        
        for(Trajet trajetTabu : tabuList){
            if(comparer(trajetTabu, trajet)){
                a = true;
            }
        }
        return a;
    }
}
