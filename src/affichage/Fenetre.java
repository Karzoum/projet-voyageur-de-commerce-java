package affichage;

import java.awt.event.*;
import java.util.ArrayList;

//import javax.swing.text.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import villechemin.*;

import java.awt.*;

public class Fenetre extends JFrame implements ActionListener, FocusListener, ItemListener {

	public static JFrame frame;
	public static JButton lancer;
	public static JButton stoper, test;
	public static JTextArea infoArea;
	public static JComboBox<String> algoComboBox;
	public static JProgressBar progressBar;
	private JPanel droitPanel = new JPanel(new BorderLayout());
	public Thread monThread;
	private JRadioButton saveVilles;
	private JRadioButton recupVilles;
	private String algorithme[] = { "Génétique", "Recuit_Simulé", "Séparation_Evaluation", "Colonis_Des_Fourmis",
			"Recherche_Tabou" };

	private int indexAlgo = 0;

	public static boolean running = false, pause = false;

	public static int nbVilles, nbGeneration, nbMutation, nbIndividu;
	public static double nbPourcent;

	public static int initTemp, critTemp, tauxRef;

	public static int tailleTL, nbIteration, nbTransf;

	public static ArrayList<Ville> lesVilles;

	public BrancheAndBoundJPanel banbJPanel = new BrancheAndBoundJPanel();
	public RecuitJPanel recuitJPanel = new RecuitJPanel();
	public GeneJPanel geneJPanel = new GeneJPanel();
	public ColonieJPanel colonieJPanel = new ColonieJPanel();
	public TabouJPanel tabouJPanel = new TabouJPanel();
	private Runnable threadTache;

	public Fenetre() {
		this.setTitle("Problème du Voyageur de Commerce");
		this.setSize(920, 700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setContentPane(contentPane());
		this.getRootPane().setDefaultButton(lancer);
		this.repaint();
		this.setVisible(true);
	}

	private Container contentPane() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel centrPanel = new JPanel(new BorderLayout());
		JPanel droitPanel2 = new JPanel(new GridBagLayout());
		JPanel droitPanel4 = new JPanel(new GridBagLayout());
		JPanel fondPanel = new JPanel(new BorderLayout());

		GridBagConstraints c = new GridBagConstraints();

		algoComboBox = new JComboBox<String>(algorithme);
		algoComboBox.addItemListener(this);

		progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		progressBar.setStringPainted(true);

		infoArea = new JTextArea(10, 10);
		infoArea.setLineWrap(true);

		JScrollPane scroll = new JScrollPane(infoArea);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
		scroll.setPreferredSize(new Dimension(this.getWidth(), 90));

		saveVilles = new JRadioButton("Enregistrer les villes ?");
		recupVilles = new JRadioButton("Réutiliser des villes ?");
		recupVilles.addItemListener(this);
		ButtonGroup buttonGrp = new ButtonGroup();
		buttonGrp.add(saveVilles);
		buttonGrp.add(recupVilles);

		lancer = new JButton("lancer");
		lancer.setBackground(Color.GREEN);
		lancer.addActionListener(this);
		stoper = new JButton("stoper");
		stoper.setBackground(Color.RED);
		stoper.addActionListener(this);
		test = new JButton("Tester un chemin");
		test.setBackground(Color.LIGHT_GRAY);
		test.addActionListener(this);

		panel.add(centrPanel, BorderLayout.CENTER);
		centrPanel.add(new MonJPanel());
		panel.add(droitPanel, BorderLayout.EAST);

		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;

		c.insets = new Insets(3, 3, 3, 3);
		droitPanel2.add(algoComboBox, c);
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.insets = new Insets(3, 3, 3, 3);
		droitPanel2.add(saveVilles, c);
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 2;
		c.insets = new Insets(3, 3, 3, 3);
		droitPanel2.add(recupVilles, c);
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 12;
		c.gridwidth = 2;
		c.insets = new Insets(3, 3, 3, 3);
		droitPanel2.add(saveVilles, c);
		droitPanel.add(droitPanel2, BorderLayout.NORTH);
		geneJPanel = new GeneJPanel();
		droitPanel.add(geneJPanel, BorderLayout.CENTER);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		c.weightx = 2;
		droitPanel4.add(lancer, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		droitPanel4.add(stoper, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 14;
		c.gridwidth = 2;
		c.insets = new Insets(25, 0, 0, 0);
		droitPanel4.add(test, c);
		droitPanel.setBackground(Color.BLACK);
		droitPanel.add(droitPanel4, BorderLayout.SOUTH);

		panel.add(fondPanel, BorderLayout.SOUTH);
		fondPanel.add(scroll, BorderLayout.CENTER);
		fondPanel.add(progressBar, BorderLayout.SOUTH);

		return panel;
	}

	private boolean conditions() {
		boolean condition = false;

		try {
			nbVilles = Integer.parseInt(GeneJPanel.villeField.getText());
			condition = true;
		} catch (NumberFormatException f) {
			condition = false;
		}
		try {
			nbIndividu = Integer.parseInt(GeneJPanel.individuField.getText());
			condition = true;
		} catch (NumberFormatException f) {
			condition = false;
		}
		try {
			nbGeneration = Integer.parseInt(GeneJPanel.generationField.getText());
			condition = true;
		} catch (NumberFormatException f) {
			condition = false;
		}
		try {
			nbMutation = Integer.parseInt(GeneJPanel.mutationField.getText());
			condition = true;
		} catch (NumberFormatException f) {
			condition = false;
		}
		return condition;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object src = e.getSource();

		if (src == recupVilles) {
			if (recupVilles.isSelected()) {
				GeneJPanel.villeField.setEnabled(false);
			} else {
				GeneJPanel.villeField.setEnabled(true);
			}
		}
		if (e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Object item = e.getItem();
				if (item == "Génétique") {
					this.droitPanel.remove(1);
					this.droitPanel.add(geneJPanel, BorderLayout.CENTER, 1);
					this.droitPanel.revalidate();
					this.indexAlgo = 0;
				}
				if (item == "Recuit_Simulé") {

					this.droitPanel.remove(1);
					this.droitPanel.add(recuitJPanel, BorderLayout.CENTER, 1);
					this.droitPanel.revalidate();
					this.indexAlgo = 1;

				}

				if (item == "Séparation_Evaluation") {
					this.droitPanel.remove(1);
					this.droitPanel.add(banbJPanel, BorderLayout.CENTER, 1);
					this.droitPanel.revalidate();
					this.indexAlgo = 2;

				}
				if (item == "Colonis_Des_Fourmis") {
					this.droitPanel.remove(1);
					this.droitPanel.add(colonieJPanel, BorderLayout.CENTER, 1);
					this.droitPanel.revalidate();
					this.indexAlgo = 3;

				}
				if (item == "Recherche_Tabou") {
					this.droitPanel.remove(1);
					this.droitPanel.add(tabouJPanel, BorderLayout.CENTER, 1);
					this.droitPanel.revalidate();
					this.indexAlgo = 4;

				}
			}
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		this.getRootPane().setDefaultButton(lancer);
		((JTextComponent) e.getSource()).selectAll();
	}

	@Override
	public void focusLost(FocusEvent e) {
		((JTextComponent) e.getSource()).selectAll();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();
		if (src == lancer) {
			if (!running && conditions()) {
				if (indexAlgo == 0) {
					TourManager tour =new TourManager();
					tour.ajouterVilleDeDestintion(nbVilles);
					lesVilles = tour.ObtenirVilles();
					this.repaint();
					nbPourcent = (double) Math.random();
					infoArea.setText("Nouveau départ de l'algorithme Génétique");
					setInfoArea("Pourcentage pour la mutation : " + String.valueOf(nbPourcent));
					progressBar.setString("");
					progressBar.setValue(0);
					threadTache = new GeneRunnable();
					monThread = new Thread(threadTache);
					monThread.start();
					lancer.setEnabled(false);
					this.getRootPane().setDefaultButton(stoper);
					running = true;
				}
				if (indexAlgo == 1) {
					TourManager tour =new TourManager();
					tour.ajouterVilleDeDestintion(nbVilles);
					lesVilles = tour.ObtenirVilles();
					this.repaint();
					infoArea.setText("Nouveau départ de l'algorithme Recuit Simulé");
					progressBar.setString("");
					progressBar.setValue(0);
					threadTache = new RecuitRunnable();
					monThread = new Thread(threadTache);
					monThread.start();
					lancer.setEnabled(false);
					this.getRootPane().setDefaultButton(stoper);
					running = true;
				}
				if (indexAlgo == 2) {
					TourManager tour =new TourManager();
					tour.ajouterVilleDeDestintion(nbVilles);
					lesVilles = tour.ObtenirVilles();
					this.repaint();
					infoArea.setText("Nouveau Départ de l'algorithme Séparation et évaluation");
					progressBar.setString("");
					progressBar.setValue(0);
					threadTache = new BandBRunnable();
					monThread = new Thread(threadTache);
					monThread.start();
					lancer.setEnabled(false);
					this.getRootPane().setDefaultButton(stoper);
					running = true;
				}
				if (indexAlgo == 3) {
					TourManager tour =new TourManager();
					tour.ajouterVilleDeDestintion(nbVilles);
					lesVilles = tour.ObtenirVilles();
					this.repaint();
					infoArea.setText("Nouveau Départ de l'algorithme Système de colonis des fourmis");
					progressBar.setString("");
					progressBar.setValue(0);
					threadTache = new ColonieRunnable();
					monThread = new Thread(threadTache);
					monThread.start();
					lancer.setEnabled(false);
					this.getRootPane().setDefaultButton(stoper);
					running = true;
				}
				if (indexAlgo == 4) {
					TourManager tour =new TourManager();
					tour.ajouterVilleDeDestintion(nbVilles);
					lesVilles = tour.ObtenirVilles();
					this.repaint();
					infoArea.setText("Nouveau Départ de l'algorithme de Récherche tabou");
					progressBar.setString("");
					progressBar.setValue(0);
					threadTache = new TabouRunnable();
					monThread = new Thread(threadTache);
					monThread.start();
					lancer.setEnabled(false);
					this.getRootPane().setDefaultButton(stoper);
					running = true;
				}

			} else {
				infoArea.append("Veuillez entrer des valeur....\n");
			}

		} else if (src == stoper && running) {
			monThread.interrupt();
			nbVilles = 0;
			nbGeneration = 0;
			nbMutation = 0;
			nbIndividu = 0;
			nbPourcent = 0;
			initTemp = 0;
			critTemp = 0;
			tauxRef = 0;
			tailleTL = 0;
			nbIteration = 0;
			nbTransf = 0;
			lancer.setEnabled(true);
			this.getRootPane().setDefaultButton(lancer);
			running = false;
		}

	}

	private void setInfoArea(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				infoArea.append("\n" + text);
				infoArea.setCaretPosition(infoArea.getText().length());
			}
		});
	}

	public static void main(String[] args) {
		String lookAndFeelName = UIManager.getSystemLookAndFeelClassName();

		try {

			UIManager.setLookAndFeel(lookAndFeelName);
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}

		frame = new Fenetre();
		frame.setVisible(true);
	}

}
