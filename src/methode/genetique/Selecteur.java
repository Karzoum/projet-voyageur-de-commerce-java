package methode.genetique;

import java.util.ArrayList;
public class Selecteur {

    private ArrayList<Double> lesScoreDeSelections;
    private ArrayList<Individu> lesIndividu;
    private int indexdeSelection = -1;
    private Individu individuSelectionner = new Individu();

    public Individu Selection(Generation generation) {

        this.lesIndividu = generation.obtenirLesIndividu();
        this.lesScoreDeSelections = generation.getScors();
        
        int index = 1;
        int l = this.lesScoreDeSelections.size();

        for (int i = 0; i < l; i++) {
            if (this.lesScoreDeSelections.get(i) == 0.0)
                index++;
        }
        if (index == l) {

            for (int i = 0; i < l; i++) {
                this.lesScoreDeSelections.set(i, 1.0);
            }
        }

        for(int i = 1; i < l;i++){
            this.lesScoreDeSelections.set(i, lesScoreDeSelections.get(i)+lesScoreDeSelections.get(i-1));
        }

        int n = (int) (Math.random() * lesScoreDeSelections.get(l-1) );
        
        for(int i = 1; i < l; i++ ){
                int m = i-1;
            if( this.lesScoreDeSelections.get(m) < n && n <= this.lesScoreDeSelections.get(i) ){
                indexdeSelection = i ;
            }
        }
       
        individuSelectionner = lesIndividu.get(indexdeSelection);

        return individuSelectionner;
    }

}
