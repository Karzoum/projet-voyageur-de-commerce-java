package affichage;

//import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;

public class GeneJPanel extends JPanel {

    private GridBagLayout bagLayout = new GridBagLayout();

    public static JTextField villeField, individuField,generationField, mutationField;
    private final String VILLE = "Nombre de ville ?",
            CHEMIN = "Nombre d'individu ?",
            GENE = "Nombre de génération ?",
            MUTATION = "Nombre de mutation ?";

    public GeneJPanel() {

        this.setLayout(bagLayout);

        villeField = new JTextField(15);
        individuField = new JTextField(15);
        generationField = new JTextField(15);
        mutationField = new JTextField(15);
 
        JLabel villeLabel = new JLabel(VILLE);
        JLabel cheminLabel = new JLabel(CHEMIN);
        JLabel generationLabel = new JLabel(GENE);
        JLabel mutationLabel = new JLabel(MUTATION);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        c.weightx = 1;
        this.add(villeLabel,c);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(villeField,c);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(cheminLabel,c);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 12;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(individuField,c);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 16;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(generationLabel,c);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 20;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(generationField,c);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 24;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);   
        this.add(mutationLabel,c);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 28;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(mutationField,c);
        
    }
}
