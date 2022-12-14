package villechemin;

import java.util.ArrayList;
//import java.util.Vector;

public class TourManager {
    
    private ArrayList<Ville> villesDeDestination= new ArrayList<Ville>();


    /**
     * @param ville
     */
    public void ajouterVilleDeDestintion(int nbVille){

        for(int i = 1 ; i <= nbVille; i++){
            Ville ville = new Ville(i);
            villesDeDestination.add(ville);
        }

    }

    /**
     * @param index
     * @return
     */
    public Ville ObtenirUneVille(int index){ 
        Ville villeLocal = null ;
        for(Ville ville : villesDeDestination){
            if(ville.getNumVille() == index)
            villeLocal = ville;
        }
        return villeLocal;
    }

    /**
     * @return
     */
    public int ObtenirNombreDeVille(){
        return villesDeDestination.size();
    }

    public ArrayList<Ville> ObtenirVilles() {
        return this.villesDeDestination;
    }
   
}
