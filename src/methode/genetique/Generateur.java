package methode.genetique;

import java.util.ArrayList;
import java.util.Vector;
//import java.util.function.Supplier;

import villechemin.TourManager;
import villechemin.Ville;

public class Generateur {
// Algorithme glouton a faire ici mais d'abort essayé avec un aléaatoire
   // private Supplier<Individu> fabriqueIndividu;

    public Generation generation(int nbIndividu, TourManager gene){

        Generation generationInitiale = new Generation(0);
        for(int i =0; i< nbIndividu; i++){
            //generationInitiale.ajouterUnIndividu(fabriqueIndividu.get());
            generationInitiale.ajouterUnIndividu(genererIndividu(gene));
        }
        return generationInitiale;
    }
    
    public Individu genererIndividu(TourManager gene){

        Individu newIndividu = new Individu();
        int randIndex;
        Vector<Integer> geneIndividu = newIndividu.getGeneIndividu();
        ArrayList<Ville> genotype = newIndividu.getGenotype();
		for (int i = 0; i < gene.ObtenirNombreDeVille(); i++) {
			do {
				randIndex = (int) (Math.random()*gene.ObtenirNombreDeVille());
			}
			while (geneIndividu.contains(randIndex));
			geneIndividu.addElement(randIndex);
            genotype.add(gene.ObtenirUneVille(randIndex));
		}
        return newIndividu;
    }
}
