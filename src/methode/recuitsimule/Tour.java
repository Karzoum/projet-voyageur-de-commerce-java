package methode.recuitsimule;

import java.util.ArrayList;
import java.util.Vector;

import villechemin.TourManager;
import villechemin.Ville;

public class Tour {
    
    private ArrayList<Ville> tour= new ArrayList<Ville>();
    private double distance=0;
    private Vector<Integer> randGenerate = new Vector<Integer>();
    public Vector<Integer> getRandGenerate() {
        return randGenerate;
    }
    private int numeroTour; 
    
    public int getNumeroTour() {
        return numeroTour;
    }

    public void setNumeroTour(int numeroTour) {
        this.numeroTour = numeroTour;
    }

    public Tour() {
        for (int i=0; i < this.tourNombreDeVille(); i++){
            this.tour.add(null);
        }

    }

    public Tour(ArrayList<Ville> enfant){
        this.tour = (ArrayList<Ville>) enfant;
    }
    
    public ArrayList<Ville> obtenirTour(){
        return this.tour;
    }
    
    /**
     * @param tourPosition
     * @return
     */
    public Ville obtenirUneVilleVisiter(int tourPosition){
        return this.tour.get(tourPosition);
    }

    public void ajouterUneVillePosition(int tourPosition,Ville ville){
        this.tour.set(tourPosition, ville);
    }

    public double EnergyTour(){
        if(this.distance==0){
            Double tourDistance=0.0;
            for(int indexVille=0;indexVille<tourNombreDeVille();indexVille++){

                Ville villeCourante=obtenirUneVilleVisiter(indexVille);
                Ville villeDeDestination;
                
                if(indexVille+1 < tourNombreDeVille()){
                    villeDeDestination=obtenirUneVilleVisiter(indexVille);
                }

                else{
                    villeDeDestination = obtenirUneVilleVisiter(0);
                }

                tourDistance+= villeCourante.distanceEntreVille(villeDeDestination);
            }
            
            this.distance = tourDistance;
        }
        return this.distance;
    }

    public boolean plusCourtTour(Tour tour){
        boolean etat=false;
        if(tour.EnergyTour() > this.EnergyTour()){
            etat = true;
        }
        return etat;
    }

    public int tourNombreDeVille() {
        return this.tour.size();
    }

    public String toString(){
        String geneString = "|" ;
        for(int i=0 ; i< this.tourNombreDeVille(); i++){
            geneString += obtenirUneVilleVisiter(i).getNumVille()+"|";
        }

        return geneString;
    }
      public void generateIndividual(ArrayList<Ville> lesVilles) {
        int randIndex;
		for (int i = 0; i < lesVilles.size(); i++) {
			do {
				randIndex = (int) (Math.random()*lesVilles.size());
			}
			while (randGenerate.contains(randIndex));
			randGenerate.addElement(randIndex);
            this.tour.add(lesVilles.get(randIndex));

		}
        }

}
