package methode.coloniedesfourmies;

import villechemin.*;

public class Trajet {
    private Ville courante;
    private Ville Destination;
    private double pheromoneTrajet;

    public double getPheromoneTrajet() {
        return pheromoneTrajet;
    }
    
    public void setPheromoneTrajet(double pheromoneTrajet) {
        this.pheromoneTrajet = pheromoneTrajet;
    }

    private Double distanceTrajet;
    private double desirabiliteTrajet;
    private int nb;

    public Trajet(Ville i,Ville j, double gamma){
        this.courante=i;
        this.Destination = j;
        this.distanceTrajet = i.distanceEntreVille(j);
        this.desirabiliteTrajet = 0.0;
        this.nb = 0;
        this.pheromoneTrajet = gamma;
    }
    public double getDesirabiliteTrajet() {
        return desirabiliteTrajet;
    }
    public void setDesirabiliteTrajet(double desirabiliteTrajet) {
        this.desirabiliteTrajet += desirabiliteTrajet;
    }
   
    public int getNb() {
        return nb;
    }

    public void setNb() {
        this.nb += 1;
    }
    
    public double getDistanceTrajet(){
        return this.distanceTrajet;
    }
   
    
}
