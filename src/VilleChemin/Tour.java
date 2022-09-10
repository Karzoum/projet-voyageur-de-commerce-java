package villechemin;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {
    
    private ArrayList tour=new ArrayList<Ville>();
    private int distance=0;
    public Tour() {
        for (int i=0;i<TourManager.ObtenirNombreDeVille();i++){
            this.tour.add(null);
        }
    }

    public Tour(ArrayList tour){
        this.tour = (ArrayList) tour.clone();
    }
    
    public ArrayList obtenirTour(){
        return this.tour;
    }
    
    /**
     * @param tourPosition
     * @return
     */
    public Ville obtenirUneVilleVisiter(int tourPosition){
        return (Ville) this.tour.get(tourPosition);
    }

    public void ajouterUneVillePosition(int tourPosition,Ville ville){
        this.tour.set(tourPosition, ville);
    }

    public int obtenirDistanceTour(){
        if(this.distance==0){
            int tourDistance=0;
            for(int indexVille=0;indexVille<tourNombreDeVille();indexVille++){
                Ville villeCourante=obtenirUneVilleVisiter(indexVille);
                Ville villeDeDestination;
                if(indexVille+1 < tourNombreDeVille()){
                    villeDeDestination=obtenirUneVilleVisiter(indexVille+1);
                }
                else{
                    villeDeDestination = obtenirUneVilleVisiter(0);
                }
                tourDistance+= villeCourante.distanceEntreVille(villeDeDestination);
            }
            
            this.distance=tourDistance;
        }
        return this.distance;
    }

    public int tourNombreDeVille() {
        return this.tour.size();
    }

    public String toString(){
        String geneString = "|" ;
        for(int i=0 ; i< this.tourNombreDeVille(); i++){
            geneString += obtenirUneVilleVisiter(i)+"|";
        }
        return geneString;
    }
}
