package affichage;

import javax.swing.*;
import java.awt.*;

public class TabouJPanel extends JPanel {
    private String NB = "Nombre d'itération du transformeur ? :", TAILLE = "Taille de la liste des tabou ?",
                    ITERATION = "Nombre d'itération ? :";
    public JTextField nbField, tailleField, iterationField;
    private GridBagLayout gb = new GridBagLayout();
    public TabouJPanel(){

        this.setLayout(gb);

        JLabel nbLabel = new JLabel(NB);
        JLabel tailleLabel = new JLabel(TAILLE);
        JLabel iterationLabel = new JLabel(ITERATION);

        nbField = new JTextField(15);
        tailleField = new JTextField(15);
        iterationField = new JTextField(15);

        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(0,0,5,0);
        c.weightx = 1;
        this.add(nbLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.insets = new Insets(0,0,5,0);
        this.add(nbField, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        c.insets = new Insets(0,0,5,0);
        this.add(tailleLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 12;
        c.gridwidth = 2;
        c.insets = new Insets(0,0,5,0);
        this.add(tailleField, c);
        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 16;
        c.gridwidth = 2;
        c.insets = new Insets(0,0,5,0);
        this.add(iterationLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 20;
        c.gridwidth = 2;
        c.insets = new Insets(0,0,5,0);
        this.add(iterationField, c);

    }

}
