package villechemin;

import java.util.ArrayList;
//import java.util.Vector;

public class TourManager {
    
    private static ArrayList villesDeDestination=new ArrayList<Ville>();

    /**
     * @param ville
     */
    public static void ajouterVilleDeDestintion(Ville ville){
        villesDeDestination.add(ville);
    }

    /**
     * @param index
     * @return
     */
    public static Ville ObtenirUneVille(int index){
        return (Ville)villesDeDestination.get(index);
    }

    /**
     * @return
     */
    public static int ObtenirNombreDeVille(){
        return villesDeDestination.size();
    }
    
   
}
