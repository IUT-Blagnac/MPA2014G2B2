package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Controler.Controller;

@SuppressWarnings("serial")
public class OPTI extends JFrame {
	public static final String numSprint = "Sprint 4";
	
	private Controller controller;

	public OPTI() {
		// Initialisation de la fenetre du programme
		controller = new Controller();
		
		controller.setMyFrame(this); // pour les listenner
		controller.setMyFrameCSV(new JFrame("CSV"));
		controller.setRec(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		setTitle("Projet: OPTI");
		this.setPreferredSize(new Dimension(controller.getRec().width/2, controller.getRec().height));
		controller.getMyFrameCSV().setPreferredSize(new Dimension(controller.getRec().width/2, controller.getRec().height));
		controller.getMyFrameCSV().setLocation(controller.getRec().width/2, 0);
		// Creation des onglets
		controller.setTabPan(new JTabbedPane());
		

		// Creation et ajout du Jcontroller.getMenuBar();
		controller.setMenuBar(new JMenuBar());

		// Creation des boutons du Jcontroller.getMenuBar();
		JMenu menu = new JMenu("Menu");
		//JMenuItem charge = new JMenuItem("Recharger les csv..");
		JMenuItem ouvrir = new JMenuItem("Ouvrir les csv");
		JMenuItem exporter = new JMenuItem("Exporter en HTML");
		JMenuItem aPropos = new JMenuItem("A propos");
		JMenuItem quitter = new JMenuItem("Quitter");

		//menu.add(charge);
		menu.add(ouvrir);
		menu.add(exporter);
		menu.add(aPropos);
		menu.add(quitter);
		
		ouvrir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				OPTIlib.startCSV(controller);
				
			}
		
		});
		
		exporter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HTMLlib.htmlGeneratePage(controller);
			}
		});
		
		// Ajout du JMenu
		controller.getMenuBar().add(menu);

		// Message de bienvenue
		controller.setjF(new JPanel());

		// Ajout des JPanel
		add(controller.getMenuBar(), BorderLayout.NORTH);
		controller.getMyFrameCSV().add(controller.getTabPan(), BorderLayout.CENTER);
		controller.getMyFrameCSV().setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		controller.getMyFrameCSV().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				dialog_quit2();
			}
		});
		add(controller.getjF(), BorderLayout.CENTER);

		// Listenner du bouton aPropos
		aPropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog_about();
			}
		});

		// Listenner du bouton quitter
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog_quit();
			}
		});

		// Fermeture de l'application
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				dialog_quit();
			}
		});

		// Lancement de l'affichage d'un CSV puis creation de l'onglet
		// newOnglet(controller.getTabPan());
		
		OPTIlib.rechargeIt(controller);
		
				
		// On pack et on rend visible
		pack();
		setVisible(true);
	}

	private void dialog_quit() {
		int confirmation;
		confirmation = JOptionPane.showConfirmDialog(this,
				"Voulez-vous réellement quitter cette application ?",
				"Quitter ?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (confirmation == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	private void dialog_quit2() {
		int confirmation;
		confirmation = JOptionPane.showConfirmDialog(this,
				"Voulez-vous réellement quitter cette page ?",
				"Quitter ?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (confirmation == JOptionPane.YES_OPTION) {
			controller.setTabPan(new JTabbedPane());
			controller.getMyFrameCSV().setVisible(false);
			try {
				OPTIlib.CSV_Write(controller.getVecSujets(), controller.getEnteteSujets(), "./sujets.csv");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void dialog_about() {
		JOptionPane.showConfirmDialog(this, "Université Toulouse 2 \n"
				+ "IUT de Blagnac \n" + "DUT INFO S3/Module MPA \n"
				+ "Projet OPTI \n" + numSprint + " \n" + " \n"
				+ "Membre du groupe:\n" + "- BADETS Julie \n"
				+ "- DUROZIER Alexane \n" + "- GAUTHIER Nicolas \n"
				+ "- GIRARD Theophane \n" + "- GODARD Gabriel \n"
				+ "- PRÉVIDENTE Simon \n", "A propos",
				JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		OPTI inter = new OPTI();

	}

	public Controller getContoller(){
		return controller;
	}
	
	
	
}


