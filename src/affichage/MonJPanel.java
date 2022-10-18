package affichage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

import methode.recuitsimule.Tour;
import villechemin.Ville;

@SuppressWarnings("serial")
public class MonJPanel extends JPanel {

    public ArrayList<Ville> lesVille = new ArrayList<Ville>();
    public Tour meilleur = new Tour();
    public Vector<Integer> trajet;

    public void paintComponent(Graphics g){
        int height = 775;
        int width = 640;
        String numVille;
        String trajetStr;
        int x = 0;
        int y = 0 ;

        g.setColor(Color.WHITE);
        g.fillRect(this.getX(), this.getY(), width, height);
        g.setColor(Color.BLACK);
        g.drawRect(this.getX(), this.getY(), width, height);

        if(Fenetre.running){
            int taille = 0 ;
            try{
                this.lesVille = (ArrayList<Ville>) GeneRunnable.obtenirVilles();
                this.meilleur = GeneRunnable.obtenirMeilleurTour();
                this.trajet = this.meilleur.getRandGenerate();
                taille = this.trajet.size();
            }catch(NullPointerException e){
                e.printStackTrace();
            }

            g.setColor(Color.RED);

            for(int i = 0; i < lesVille.size();i ++){
                x = lesVille.get(i).getX() * 6+20;
                y = lesVille.get(i).getY() * 5+20;
                numVille = String.valueOf(lesVille.get(i).getNumVille());
                g.fillRect(x, y, 5, 5);
                g.drawString(numVille, x-5, y-5);
            }
            g.setColor(Color.BLACK);

            for(int i = 1; i < taille; i ++){
                System.out.println(trajet.elementAt(i));
                int xDep = this.lesVille.get(trajet.elementAt(i-1)).getX()* 6+22;
                int yDep = this.lesVille.get(trajet.elementAt(i-1)).getY()* 5+22;
                int xFin = this.lesVille.get(trajet.elementAt(i)).getX()* 6+22;
                int yFin = this.lesVille.get(trajet.elementAt(i)).getY()* 5+22;
                g.drawLine(xDep, yDep, xFin,yFin);
                trajetStr = String.valueOf(meilleur.EnergyTour());
                g.drawString(trajetStr, this.getX()+20, this.getY()+30);
            }

            //int xDep = this.lesVille.get(trajet.elementAt(0)).getX()*6+22;
            //int yDep = this.lesVille.get(trajet.elementAt(0)).getY()* 5+22;
            //int xFin = this.lesVille.get(trajet.elementAt(taille-1)).getX()* 6+22;
            //int yFin = this.lesVille.get(trajet.elementAt(taille-1)).getY()* 5+22;
            //g.drawLine(xDep, yDep, xFin, yFin);
            //trajetStr = String.valueOf(meilleur.EnergyTour());
            //g.drawString(trajetStr, x, y);
        }
    }
}
