package affichage;

import java.awt.event.*;
import javax.swing.text.*;
import javax.swing.*;

import java.awt.*;

public class Fenetre extends JFrame implements ActionListener, FocusListener, ItemListener
{
	public static JFrame frame;
	public static JButton lancer;
	public static JButton stoper, test;
	public static JTextArea infoArea;
	public JMenuBar barreMenu;
	public static JProgressBar progressBar;
	public Thread monThread;
	private JRadioButton saveVilles;
	private JRadioButton recupVilles;
	public static boolean running = false, pause = false;
	
	
	public Fenetre()
	{
		this.setTitle("Algorithmes Génétiques - Problème du Voyageur de Commerce");
		this.setSize(920,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(contentPane());
		this.getRootPane().setDefaultButton(lancer);
		this.repaint();
	}
	
	private Container contentPane() {
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		JPanel centrPanel = new JPanel(new BorderLayout());
		JPanel droitPanel = new JPanel(new GridBagLayout());
		JPanel fondPanel = new JPanel(new BorderLayout());
		
		progressBar = new JProgressBar();
			progressBar.setMinimum(0);
			progressBar.setStringPainted(true);

		infoArea = new JTextArea(10,10);
			infoArea.setLineWrap(true);
			
		JScrollPane scroll = new JScrollPane(infoArea);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroll.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
			scroll.setPreferredSize(new Dimension(this.getWidth(),90));
		
		saveVilles = new JRadioButton("Enregistrer les villes ?");
		recupVilles = new JRadioButton("Réutiliser des villes ?");
			recupVilles.addItemListener(this);
		ButtonGroup buttonGrp = new ButtonGroup();
			buttonGrp.add(saveVilles);
			buttonGrp.add(recupVilles);
		
		
		lancer = new JButton(new ImageIcon(getClass().getResource("/play.png")));
			lancer.addActionListener(this);
		stoper = new JButton(new ImageIcon(getClass().getResource("/stop.png")));
			stoper.addActionListener(this);
		test = new JButton("Tester un chemin");
			test.addActionListener(this);
		
		panel.add(centrPanel, BorderLayout.CENTER);
			centrPanel.add(new MonJPanel());
		panel.add(droitPanel, BorderLayout.EAST);
		
		panel.add(fondPanel, BorderLayout.SOUTH);
			fondPanel.add(scroll, BorderLayout.CENTER);
			fondPanel.add(progressBar, BorderLayout.SOUTH);
		
		return panel;
	}
	/*
private boolean conditions() {
		boolean condition = false;
		
		try {
			nbVilles = Integer.parseInt(villeField.getText());
			condition = true;
		} catch (NumberFormatException f) {
			condition = false;
		}
		try {
			nbChemins = Integer.parseInt(cheminField.getText());
			condition = true;
		} catch (NumberFormatException f) {
			condition = false;
		}
		try {
			nbGene = Integer.parseInt(generationField.getText());
			condition = true;
		} catch (NumberFormatException f) {
			condition = false;
		}
		try {
			nbMutations = Integer.parseInt(mutationField.getText());
			condition = true;
		} catch (NumberFormatException f) {
			condition = false;
		}
		return condition;
	}

	public void focusGained(FocusEvent e) {
		this.getRootPane().setDefaultButton(lancer);
		((JTextComponent) e.getSource()).selectAll();
	}

	public void focusLost(FocusEvent e) {
		((JTextComponent) e.getSource()).setCaretPosition(0);
	}
	

	 * public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		
		if(src == lancer) {
			if ((!running) && conditions()) {
				this.repaint();
				nbPourcent = (double) Math.random();
				infoArea.setText("Nouveau départ");
				setInfoArea("Pourcentage pour les mutations: "+String.valueOf(nbPourcent));
				progressBar.setString("");
				progressBar.setValue(0);
				threadTache = new MonRunnable();
				monThread = new Thread(threadTache);
				monThread.start();
				lancer.setEnabled(false);
				this.getRootPane().setDefaultButton(stoper);
				running = true;
			}else {
				infoArea.append("Veuillez entrer des nombres décimaux...\n");
			}
		}else if(src == stoper && running) {
			monThread.stop();
			nbVilles = 0;
			nbChemins = 0;
			nbGene = 0;
			nbMutations = 0;
			nbPourcent = 0;
			lancer.setEnabled(true);
			this.getRootPane().setDefaultButton(lancer);
			running = false;
		}else if(src == test) {
			new TestWay();
		}
	}
	
	/**
	 * @return
	 */
	
	/*
	 * @param infoArea the infoArea to set
	 
	public static void setInfoArea(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				infoArea.append("\n"+text);
				infoArea.setCaretPosition(infoArea.getText().length());
			}
		});
	}

	public void itemStateChanged(ItemEvent e) {
		Object src = e.getSource();
		if (src == recupVilles) {
			if (recupVilles.isSelected()) {
				villeField.setEnabled(false);
			}else {
				villeField.setEnabled(true);
			}
		}
		
	}

	public static void main(String[] args)
	{
		String lookAndFeelName = UIManager.getSystemLookAndFeelClassName();
		
		try {

			UIManager.setLookAndFeel(lookAndFeelName);
		} 
		catch (ClassNotFoundException e) {} 
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		
		frame = new Fenetre();
		frame.setVisible(true);
	}
	 */

}
