package methode.genetique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import villechemin.*;

public class Individu implements Serializable{

    private Double distance = 0.0;
    private Vector<Integer> geneIndividu;

    public Vector<Integer> getGeneIndividu() {
        return geneIndividu;
    }

    public void setGeneIndividu(Vector<Integer> geneIndividu) {
        this.geneIndividu = geneIndividu;
    }

    private ArrayList<Ville> genotype;
    public ArrayList<Ville> getGenotype() {
        return genotype;
    }

    public void setGenotype(ArrayList<Ville> genotype) {
        this.genotype = genotype;
    }

    private static int numIndividu;

    public static void setNumIndividu(int numIndividu) {
        Individu.numIndividu = numIndividu;
    }

    public static int getNumindividu() {
        return numIndividu;
    }

    private double scoreSelection = 0;

    public Individu(TourManager gene){
        this.genererIndividu(gene);
    }

    public double getScore() {
        return scoreSelection;
    }

    public void setScore(Double score) {
        this.scoreSelection = score;
    }

    public boolean estSelectionner() {
        return false;
    }

    public boolean estSolution() {
        return false;
    }  
    
    public double getValeur(){
        return this.distance;
    }

    public void setValeur(Double valeur){
        this.distance = valeur;
    }

    public void genererIndividu(TourManager gene){
        int randIndex;
		for (int i = 0; i < gene.ObtenirNombreDeVille(); i++) {
			do {
				randIndex = (int) (Math.random()*gene.ObtenirNombreDeVille());
			}
			while (geneIndividu.contains(randIndex));
			geneIndividu.addElement(randIndex);
           this.genotype.add(gene.ObtenirUneVille(randIndex));

		}
    }
    
}
