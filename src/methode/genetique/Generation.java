package methode.genetique;

import java.util.ArrayList;

public class Generation {
    private ArrayList<Individu> lesIndividus = new ArrayList<Individu>(); 

    public Generation(int numeroGeneration) {
        this.numeroGeneration = numeroGeneration;
    }
    private int numeroGeneration;
    
    public void ajouterUnIndividu(Individu newIndividu){
        this.lesIndividus.add(newIndividu);
    } 
    public void ajouterGroupeIndividu(ArrayList<Individu> groupeIndividu){
        if(! groupeIndividu.contains(null)){
            this.lesIndividus.addAll(groupeIndividu);
        }
    }

    public void enleverIndividu(Individu individu) {
        this.lesIndividus.remove(individu);
    }

    public int nombreDIndividusGeneration(){
        return this.lesIndividus.size();
    }

    public void enleverNonSelectionner(){
        ArrayList<Individu> lesIndividuLocaux = new ArrayList<Individu>();
        lesIndividuLocaux.addAll(this.lesIndividus);
        for(Individu individu : lesIndividuLocaux){
            if(!individu.estSelectionner()){
                this.lesIndividus.remove(individu);
            }
        }
    }

    public int getSommeScore(){
        int somme = 0;
        for(Individu individu : lesIndividus){
            somme += individu.getScore();
        }
        return somme;
    }

    public int getScoreDeSelection(){
        int scoreMax = 0;
        for(Individu individu : lesIndividus){
            if(individu.getScore() > scoreMax){
                scoreMax = individu.getScore();
            }
        }
        int[] repartitionScores = new int[scoreMax+1];
        for(Individu individu : lesIndividus){
            repartitionScores[individu.getScore()]+=1;
        }
        int nbIndividus = 0;
        int sommePonderee = 0 ;
        /*
         * 
         * 
         */
        
        return (int) sommePonderee/ nbIndividus;
    }

    

}
