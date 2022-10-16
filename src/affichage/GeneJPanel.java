package affichage;

//import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;

public class GeneJPanel extends JPanel {
    public static int nbVilles, nbChemins, nbGene, nbMutations;
    public static double nbPourcent;

    public JTextField villeField, cheminField, generationField, mutationField;
    private final String VILLE = "Nombre de villes ?",
            CHEMIN = "Nombre de chemin ?",
            GENE = "Nombre de générations ?",
            MUTATION = "Nombre de mutations ?";
    public static JRadioButton saveVilles, recupVilles;

    public GeneJPanel() {

        villeField = new JTextField(15);
        cheminField = new JTextField(15);
        generationField = new JTextField(15);
        mutationField = new JTextField(15);

        GridBagConstraints c = new GridBagConstraints();
        JLabel villeLabel = new JLabel(VILLE);
        JLabel cheminLabel = new JLabel(CHEMIN);
        JLabel generationLabel = new JLabel(GENE);
        JLabel mutationLabel = new JLabel(MUTATION);

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        c.weightx = 1;
        this.add(saveVilles, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(recupVilles, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(villeLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(villeField, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(cheminLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(cheminField, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(generationLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(generationField, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(mutationLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 9;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(mutationField, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        c.weightx = 2;
    }
}
