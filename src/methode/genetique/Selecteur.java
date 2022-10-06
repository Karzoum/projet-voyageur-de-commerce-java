package methode.genetique;

import java.util.Comparator;
//import java.util.function.BiConsumer;

public class Selecteur {

    private Generation generation;

    // private BiConsumer<Individu , Integer> selecteurIndividu;

    // private int seuil;

    public Selecteur(Generation generation) {
        this.generation = generation;
        
		for (Individu individu : this.generation.obtenirLesIndividu())
		{
			selectionArray[i] = (int) (Math.sqrt ((i + 1.0) / (allFits.size())) * (100));
			//Plus de chances pour les premiers chemins
			//System.out.println(selectionArray[i]);
		}

		rand = (int) (Math.random()*100);
		
		while (rand > selectionArray[a])	//Genere un nombre aléatoire pour la selection
		{
			a++;
		}
		//System.out.println(rand);


/*
        generation.obtenirLesIndividu().sort(new Comparator<Individu>() {

            @Override
            public int compare(Individu o1, Individu o2) {
                // TODO Auto-generated method stub
                return (int) (o2.getScoreSelection() - o1.getScoreSelection());
            }

        });
        for (int i = generation.nombreDIndividusGeneration() / 2; i < generation.nombreDIndividusGeneration(); i++) {
            Individu individuLocal = generation.obtenirLesIndividu().get(1);
            generation.en
             leverIndividu(individuLocal);
        }
 */      
        
    }
}
