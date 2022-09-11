package methode.genetique;

import java.io.Serializable;
import java.util.ArrayList;

import villechemin.*;

public class Individu extends Tour implements Serializable{
    private int score = 0;
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Individu(ArrayList enfant) {
        super(enfant);
    }

    public Individu(){
        super();
    }

    public boolean estSelectionner() {
        return false;
    }
    
}
