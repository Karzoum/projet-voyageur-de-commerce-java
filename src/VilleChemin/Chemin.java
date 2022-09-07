package VilleChemin;
import java.util.ArrayList;
//import java.util.Vector;

public class Chemin {
    
    private ArrayList<Ville> Villes;
    private int numeroDuChemin;
    private Double longueurDuChemin;

    public Chemin(ArrayList<Ville> villes, int numeroDuChemin) {
        this.Villes = villes;
        this.numeroDuChemin = numeroDuChemin;
        this.longueurDuChemin=Math.sqrt(Math.pow((Villes.get(2).getX()-Villes.get(1).getX()), 2) + Math.pow(Villes.get(2).getY()-Villes.get(1).getY(), 2));
    }

    public ArrayList<Ville> getVilles2() {
        return Villes;
    }

    public void setVilles2(ArrayList<Ville> villes2) {
        Villes = villes2;
    }
    
    public Double getLongueur() {
        return longueurDuChemin;
    }

    public void setLongueur(Double longueur) {
        this.longueurDuChemin = longueur;
    }

    public int getNumeroDuChemin() {
        return numeroDuChemin;
    }

    public void setNumeroDuChemin(int numeroDuChemin) {
        this.numeroDuChemin = numeroDuChemin;
    }

}
