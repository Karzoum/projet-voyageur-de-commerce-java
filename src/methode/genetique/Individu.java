package methode.genetique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import villechemin.*;

public class Individu implements Serializable{

    private Double valeur = 0.0;
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
        return genotype;
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
        this.scoreSelection = (1/(score+1));
    }

    public boolean estSelectionner() {
        this.estSelectionner = true;
        return this.estSelectionner;
    }

    public double getValeur(){
        return this.valeur;
    }

    /**
     * @param valeur
     */
    public void setValeur(Double valeur){
        this.valeur = valeur;
    }
    public String toString() {
        String tab = " | ";
        for(int i = 0; i< this.geneIndividu.size(); i++){
            tab +=  this.geneIndividu.get(i)+" | ";
        }
        return tab;
    }
}
