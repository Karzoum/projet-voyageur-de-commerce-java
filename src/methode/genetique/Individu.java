package methode.genetique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import villechemin.*;

public class Individu implements Serializable{

    private Double distance = 0.0;
    private Vector<Integer> geneIndividu;
    private ArrayList<Ville> genotype;
    private int numIndividu;
    private double scoreSelection = 0;
    private boolean estSelectionner;


    public Vector<Integer> getGeneIndividu() {
        return geneIndividu;
    }

    public void setGeneIndividu(Vector<Integer> geneIndividu) {
        this.geneIndividu = geneIndividu;
    }

    
    public ArrayList<Ville> getGenotype() {
        return this.genotype;
    }

    public void setGenotype(ArrayList<Ville> genotype) {
        this.genotype = genotype;
    }


    public void setNumIndividu(int numIndividu) {
        this.numIndividu = numIndividu;
    }

    public  int getNumindividu() {
        return numIndividu;
    }

    public double getScoreSelection() {
        return scoreSelection;
    }

    public void setScoreSelection(Double score) {
        this.scoreSelection = score;
    }

    public boolean estSelectionner() {
        this.estSelectionner = true;
        return this.estSelectionner;
    }

    public boolean estSolution() {
        return false;
    }  
    
    public double getValeur(){
        return this.distance;
    }

    /**
     * @param valeur
     */
    public void setValeur(Double valeur){
        this.distance = valeur;
    }
    public String toString() {
        String tab = this.numIndividu +"= | ";
        for(int i = 0; i< this.genotype.size(); i++){
            tab +=  this.geneIndividu.get(i)+" | ";
        }
        return tab;
    }
    
}
