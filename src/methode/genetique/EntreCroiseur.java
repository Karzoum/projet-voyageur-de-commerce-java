package methode.genetique;

import java.util.ArrayList;
import java.util.Vector;
import villechemin.Ville;
 
public class EntreCroiseur {

    private Individu enfant1;
    private Individu enfant2;
    private ArrayList<Individu> Descendants = new ArrayList<Individu>();

    public ArrayList<Individu> crossOver(Individu parent1, Individu parent2){
        enfant1 = parent1;
        enfant2 = parent2;

        ArrayList<Ville> genotype1 = enfant1.getGenotype();
        ArrayList<Ville> genotype2 = enfant2.getGenotype();

        Vector<Integer> gene1 =enfant1.getGeneIndividu();
        Vector<Integer> gene2 = enfant2.getGeneIndividu();

        int max = parent1.getGenotype().size();
        int n = (int) (Math.random() * max);

        if (n != 0) {
            for (int i = n ; i < max; i++) {
                echangerVille(genotype1, genotype2, i);
                echangerNumVille(gene1, gene2, i);
            }
        }

        enfant1.setGenotype(genotype1);

        enfant2.setGenotype(genotype2);

        enfant1.setGeneIndividu(gene1);

        enfant2.setGeneIndividu(gene2);

        this.Descendants.add(enfant1);

        this.Descendants.add(enfant2);

        return this.Descendants;
    }

    private void echangerVille( ArrayList<Ville> genotype1, ArrayList<Ville> genotype2, int i){
        Ville gene1 = genotype1.get(i);
        genotype1.set(i, genotype2.get(i));
        genotype2.set(i, gene1);
    }

    private void echangerNumVille( Vector<Integer> gene1, Vector<Integer> gene2, int i){
        int genome1 = gene1.get(i);
        gene1.set(i, gene2.get(i));
        gene2.set(i, genome1);
    }

}
