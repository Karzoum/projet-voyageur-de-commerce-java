package villechemin;

import java.util.ArrayList;
//import java.util.Vector;

public class TourManager {
    
    private ArrayList<Ville> villesDeDestination=new ArrayList<Ville>();

    /**
     * @param ville
     */
    public void ajouterVilleDeDestintion(Ville ville){
        villesDeDestination.add(ville);
    }

    /**
     * @param index
     * @return
     */
    public Ville ObtenirUneVille(int index){
        return (Ville)villesDeDestination.get(index);
    }

    /**
     * @return
     */
    public int ObtenirNombreDeVille(){
        return villesDeDestination.size();
    }
    
   
}
