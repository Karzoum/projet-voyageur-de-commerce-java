package affichage;

import javax.swing.*;
import java.awt.*;

public class BrancheAndBoundJPanel extends JPanel {
    public static int nbVilles;
   
    private final String VILLE = "Nombre de villes ?";
    private GridBagLayout bagLayout = new GridBagLayout();
    public JTextField villeField;
    public BrancheAndBoundJPanel() {

        this.setLayout(bagLayout);

        JLabel villeLabel = new JLabel(VILLE);

        villeField = new JTextField(15);
        
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        c.weightx = 1;
        this.add(villeLabel,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(villeField,c);
    }

}
