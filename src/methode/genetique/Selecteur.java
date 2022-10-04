package methode.genetique;

import java.util.function.BiConsumer;

public class Selecteur {

    private BiConsumer<Individu , Integer> selecteurIndividu;

    private int seuil;
    
    public void selectionner(Individu individu) {
        this.selecteurIndividu.accept(individu, seuil);
    }
}
