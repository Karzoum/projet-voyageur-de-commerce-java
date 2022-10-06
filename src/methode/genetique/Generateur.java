package methode.genetique;

import java.util.ArrayList;
import java.util.Vector;
//import java.util.function.Supplier;

import villechemin.TourManager;
import villechemin.Ville;

public class Generateur {

    private Generation generationInitiale;
    private Individu newIndividu;
// Algorithme glouton a faire ici mais d'abort essayé avec un aléaatoire
   // private Supplier<Individu> fabriqueIndividu;

    public Generation getGeneration(int nbIndividu, TourManager gene){

        this.generationInitiale = new Generation(0);
        for(int i =0; i < nbIndividu; i++){
            //generationInitiale.ajouterUnIndividu(fabriqueIndividu.get());
            generationInitiale.ajouterUnIndividu(genererIndividu(gene));
        }
        return generationInitiale;
    }
    
    public Individu genererIndividu(TourManager gene){

        this.newIndividu = new Individu();

        int randIndex;

        Vector<Integer> geneIndividu = new Vector<Integer>();
        ArrayList<Ville> genotype = new ArrayList<Ville>();

        System.out.println(gene.ObtenirNombreDeVille());

		for (int i = 0 ; i < gene.ObtenirNombreDeVille(); i++) {
            i += 1;
            newIndividu.setNumIndividu(i);
			do {
				randIndex = (int) (Math.random() * gene.ObtenirNombreDeVille());
			}
			while (geneIndividu.contains(randIndex) && randIndex == 0); 

			geneIndividu.addElement(randIndex);

            genotype.add(gene.ObtenirUneVille(randIndex));
		}

        newIndividu.setGeneIndividu(geneIndividu);
        newIndividu.setGenotype(genotype);

        return newIndividu;
    }
}
