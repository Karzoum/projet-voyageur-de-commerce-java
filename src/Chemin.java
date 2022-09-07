import java.util.ArrayList;
//import java.util.Vector;

public class Chemin {
    
    private ArrayList<Ville> Villes2;
    private int numeroDuChemin;
    private Double longueur;

    public Chemin(ArrayList<Ville> villes, int numeroDuChemin) {
        this.Villes2 = villes;
        this.numeroDuChemin = numeroDuChemin;
        this.longueur=Math.sqrt(Math.pow((Villes2.get(2).getX()-Villes2.get(1).getX()), 2) + Math.pow(Villes2.get(2).getY()-Villes2.get(1).getY(), 2));
    }

    public ArrayList<Ville> getVilles2() {
        return Villes2;
    }

    public void setVilles2(ArrayList<Ville> villes2) {
        Villes2 = villes2;
    }
    
    public Double getLongueur() {
        return longueur;
    }

    public void setLongueur(Double longueur) {
        this.longueur = longueur;
    }

    public int getNumeroDuChemin() {
        return numeroDuChemin;
    }

    public void setNumeroDuChemin(int numeroDuChemin) {
        this.numeroDuChemin = numeroDuChemin;
    }

}