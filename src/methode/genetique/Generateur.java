package methode.genetique;

import java.util.ArrayList;
import java.util.Vector;
//import java.util.function.Supplier;

import villechemin.TourManager;
import villechemin.Ville;

public class Generateur {

    private Generation generationInitiale;
    private Individu newIndividu;
    private int nombreDIndividus;
// Algorithme glouton a faire ici mais d'abort essayé avec un aléaatoire
   // private Supplier<Individu> fabriqueIndividu;

    public Generation getGeneration(int nbIndividu, TourManager gene){
        this.nombreDIndividus = nbIndividu;
        this.generationInitiale = new Generation(0);
        Individu individu = new Individu();

        for(int i =0; i < this.nombreDIndividus; i++){
            //generationInitiale.ajouterUnIndividu(fabriqueIndividu.get());
            individu = genererIndividu(gene);
            generationInitiale.ajouterUnIndividu(individu);
        }

        return generationInitiale;
    }
    
    public Individu genererIndividu(TourManager gene){

        this.newIndividu = new Individu();

        int randIndex;

        Vector<Integer> geneIndividu = new Vector<Integer>();
        ArrayList<Ville> genotype = new ArrayList<Ville>();

        System.out.println(gene.ObtenirNombreDeVille());
        int taille = gene.ObtenirNombreDeVille();

		for (int i = 0 ; i < taille ; i++) {
            newIndividu.setNumIndividu(i);
			do {
				randIndex = (int) (Math.random() * gene.ObtenirNombreDeVille());
			}
			while (geneIndividu.contains(randIndex)); 

			geneIndividu.addElement(randIndex);

            genotype.add(gene.ObtenirUneVille(randIndex));
		}

        newIndividu.setGeneIndividu(geneIndividu);
        newIndividu.setGenotype(genotype);

        return newIndividu;
    }
}
