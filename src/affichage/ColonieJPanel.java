package affichage;

import javax.swing.*;
import java.awt.*;

public class ColonieJPanel extends JPanel {
    
    private String TAUX = "Taux d'apprentissage ? :", TAUXEVP = "Taux d'évaporation ? :",
                    VALEUR = "Valeur initiale des phéromone ? :",
                    REGLAGE = "Paramètre Heuristique de Sélection ?",
                    REGLAGE2 = "Paramètre phéromone de Sélection ?",
                    ITERATION = "Iteration vers Hill-Climb ?",
                    PROBA = "Probabilité de sélection ?";
    public JTextField tauxField, tauxEvapField, valeurField, reglageField, reglage2Field, iterationField, probaField;

    private GridBagLayout gb = new GridBagLayout();

    public ColonieJPanel(){

        this.setLayout(gb);

        tauxField = new JTextField(15);
        tauxEvapField = new JTextField(15);
        valeurField = new JTextField(15);
        reglageField = new JTextField(15);
        reglage2Field = new JTextField(15);
        iterationField = new JTextField(15);
        probaField = new JTextField(15);

        JLabel tauxLabel = new JLabel(TAUX);
        JLabel tauxEvapLabel = new JLabel(TAUXEVP);
        JLabel valeurLabel = new JLabel(VALEUR);
        JLabel reglageLabel = new JLabel(REGLAGE);
        JLabel reglageLabel2 = new JLabel(REGLAGE2);
        JLabel iterationLabel = new JLabel(ITERATION);
        JLabel probaLabel = new JLabel(PROBA);

        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        c.weightx = 1;
        this.add(tauxLabel,c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(tauxField, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(tauxEvapLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 12;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(tauxEvapField, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 20;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(valeurLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 24;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(valeurField, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 28;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(reglageLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 32;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(reglageField,c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 36;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(reglageLabel2, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 42;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(reglage2Field, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 46;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(iterationLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 50;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(iterationField, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 54;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(probaLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 58 ;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 5, 0);
        this.add(probaField, c);
    }
}
