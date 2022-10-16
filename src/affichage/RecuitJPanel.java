package affichage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;

public class RecuitJPanel extends JPanel {
     
     private final String TEMPERATURE = "Temperature initiale ? :", 
                          TAUX = "Taux de refroidissement ? :",
                          VILLE = "Nombre de ville ? :",
                          TEMPERATURE2 = "Temperature critique ? :";
    private  GridBagConstraints c = new GridBagConstraints();

    public JTextField tempField, villeField, tauxField, tempField2;
    private JRadioButton savVilles;
    private JRadioButton recupVilles;
    public static int nbVilles, tempInitial,tempCr;
    public static double tauxRef;
    public static JTextArea infosArea;

    public RecuitJPanel(){

        savVilles = new JRadioButton("Enregistrer les villes ?");
        recupVilles = new JRadioButton("Réutiliser les villes ?");

        JLabel villeLabel = new JLabel(VILLE);
        JLabel tauxLabel = new JLabel(TAUX);
        JLabel tempJLabel = new JLabel(TEMPERATURE);
        JLabel tempJLabel2 = new JLabel(TEMPERATURE2);

        villeField = new JTextField(15);
        tempField = new JTextField(15);
        tauxField = new JTextField(15);
        tempField2 = new JTextField(15);

            c.anchor = GridBagConstraints.NORTH;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2;
            c.insets = new Insets(0,0,5,0);
            c.weightx = 1;
        this.add(savVilles,c);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 2;
            c.insets = new Insets(0,0,5,0);
            c.weightx = 1;
        this.add(recupVilles, c);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 2;
            c.gridwidth = 2;
            c.insets = new Insets(0,0,5,0);
            c.weightx = 1;
        this.add(villeLabel, c);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 3;
            c.gridwidth = 2;
            c.insets = new Insets(0,0,5,0);
            c.weightx = 1;
        this.add(villeField, c);  
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 4;
            c.gridwidth = 2;
            c.insets = new Insets(0,0,5,0);
            c.weightx = 1;
        this.add(tauxLabel, c);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 5;
            c.gridwidth = 2;
            c.insets = new Insets(0,0,5,0);
            c.weightx = 1;
        this.add(tauxField, c);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 6;
            c.gridwidth = 2;
            c.insets = new Insets(0,0,5,0);
            c.weightx = 1;
        this.add(tempJLabel, c);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 7;
            c.gridwidth = 2;
            c.insets = new Insets(0,0,5,0);
            c.weightx = 1;
        this.add(tempField, c);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 8;
            c.gridwidth = 2;
            c.insets = new Insets(0,0,5,0);
            c.weightx = 1;
        this.add(tempJLabel2, c);
        }
}
