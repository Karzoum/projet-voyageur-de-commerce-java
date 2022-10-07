package methode.genetique;

import java.util.ArrayList;
import java.util.Vector;

import villechemin.Ville;

public class Mutateur {

    private ArrayList<Ville> genotype;
    private Vector<Integer> gene;

    private ArrayList<Ville> genotype2;
    private Vector<Integer> gene2;
    private Individu mutant = new Individu();

    public Mutateur(Individu individu) {

        this.gene = (Vector<Integer>) individu.getGeneIndividu();
        this.genotype = (ArrayList<Ville>) individu.getGenotype();

        this.gene2 = (Vector<Integer>) individu.getGeneIndividu();
        this.genotype2 = (ArrayList<Ville>) individu.getGenotype();

        int taille = this.gene.size();

        int num1 = 0;
        int num2 = 0;

        do {
            num1 = (int) (Math.random() * (taille - 1) + 1);
            num2 = (int) (Math.random() * (taille - 2) + 2);
        } while (num1 == num2);
        int tempNum = 0;

        if (num1 > 2) { // Le plus petit en premier
            tempNum = num1;
            num1 = num2;
            num2 = tempNum;
        }
        int num = num1;
        for (int i = num2; i >= num1; i--) { // Inverse les éléments un par un

            this.gene2.setElementAt(this.gene.elementAt(num), i);
            this.genotype2.set(i, this.genotype.get(num));
        }
        this.mutant.setGeneIndividu(gene2);
        this.mutant.setGenotype(genotype2);
    }

    public Individu obtenirMutant() {
        return this.mutant;
    }

}
