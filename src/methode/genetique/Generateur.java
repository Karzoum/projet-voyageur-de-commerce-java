package methode.genetique;

import java.util.function.Supplier;

public class Generateur {

    private Supplier<Individu> fabriqueIndividu;

    public Generation generation(int nbIndividu){
        Generation generationInitiale = new Generation(0);
        for(int i =0; i< nbIndividu; i++){
            generationInitiale.ajouterUnIndividu(fabriqueIndividu.get());
        }
        return generationInitiale;
    }
}
