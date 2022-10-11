package methode.coloniedesfourmies;

import java.util.ArrayList; 
public class PheromonesManageur {
    //Taux d'apprentissage
    private double alpha;
    private ArrayList<Trajet> composants;
    private ArrayList<Trajet> popSentier;

    public void Updating(ArrayList<Trajet> composants,ArrayList<Trajet> popSentier,double tauxApp){

        this.alpha = tauxApp;
        this.composants = composants;
        this.popSentier = popSentier;

        for(Trajet trajet : popSentier){
            for(Trajet trajet2:composants){
                if(trajet2 == trajet){
                    trajet.setDesirabiliteTrajet(trajet2.getDesirabiliteTrajet());
                    trajet.setNb();
                }
            }
        }

        for(Trajet trajet:composants){
            if(trajet.getNb()>0){
                double pheromone = (1 - alpha)*trajet.getPheromoneTrajet() + alpha * (trajet.getDesirabiliteTrajet()/trajet.getNb());
                trajet.setPheromoneTrajet(pheromone);
            }
        }
    }

    public void decrease(ArrayList<Trajet> composants,double tauxEva,double initialeValue){
        for(Trajet trajet : composants){
            double pheromone = (1 - tauxEva) * trajet.getPheromoneTrajet() + tauxEva*initialeValue;
            trajet.setPheromoneTrajet(pheromone);
        }
    }

    
}
