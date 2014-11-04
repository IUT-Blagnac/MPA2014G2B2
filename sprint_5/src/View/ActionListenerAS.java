package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Controler.Controller;
import Model.Groupes;


public class ActionListenerAS implements ActionListener {

	private Controller controller;
	private JPanel jpData;
	public static final int FLAG_GRO = 1;
	public static final int FLAG_ETU = 2;
	public static final int FLAG_INTER = 3;
	private int flagSelected;
	private int integer;
	
	public ActionListenerAS(Controller controller, JPanel jpData, int flag, int integer ){
		this.controller = controller;
		this.jpData = jpData;
		flagSelected = flag;
		this.integer = integer;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		jpData.removeAll();
		JTabbedPane jtp = new JTabbedPane();
		jpData.add(jtp);
		
		switch(flagSelected){
		case FLAG_GRO:
			Vector<Vector<String>> v1 = new Vector<Vector<String>>();
			Vector<Vector<String>> v2 = new Vector<Vector<String>>();
			Vector<Vector<String>> v3 = new Vector<Vector<String>>();
			Vector<Vector<String>> v4 = new Vector<Vector<String>>();
			Vector<Vector<String>> v5 = new Vector<Vector<String>>();
			v1.add(controller.getGroupes().get(integer).getProjet().getVec());
			v2.add(controller.getGroupes().get(integer).getProjet().getSujet().getVec());
			v3.add(controller.getGroupes().get(integer).getProjet().getIntervenant().getVec());
			v4.add(controller.getGroupes().get(integer).getProjet().getClient().getVec());
			v5.add(controller.getGroupes().get(integer).getProjet().getSupport().getVec());
			
			jtp.addTab("Projet", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v1, controller.getEnteteProjets())));
			jtp.addTab("Sujet", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v2, controller.getEnteteSujets())));
			jtp.addTab("Etudiants", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, controller.getGroupes().get(integer).getVec(), controller.getEnteteGroupes())));
			jtp.addTab("Superviseur", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v3, controller.getEnteteIntervenants())));
			jtp.addTab("Client", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v4, controller.getEnteteIntervenants())));
			jtp.addTab("Support Technique", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v5, controller.getEnteteIntervenants())));
			break;
		case FLAG_ETU:
			Vector<Vector<String>> v6 = new Vector<Vector<String>>();
			Vector<Vector<String>> v7 = new Vector<Vector<String>>();
			Vector<Vector<String>> v8 = new Vector<Vector<String>>();
			Vector<Vector<String>> v9 = new Vector<Vector<String>>();
			Vector<Vector<String>> v10 = new Vector<Vector<String>>();
			v6.add(controller.getEtudiants().get(integer).getGroupe().getProjet().getVec());
			v7.add(controller.getEtudiants().get(integer).getGroupe().getProjet().getSujet().getVec());
			v8.add(controller.getEtudiants().get(integer).getGroupe().getProjet().getIntervenant().getVec());
			v9.add(controller.getEtudiants().get(integer).getGroupe().getProjet().getClient().getVec());
			v10.add(controller.getEtudiants().get(integer).getGroupe().getProjet().getSupport().getVec());
			
			jtp.addTab("Projet", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v6, controller.getEnteteProjets())));
			jtp.addTab("Sujet", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v7, controller.getEnteteSujets())));
			jtp.addTab("Superviseur", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v8, controller.getEnteteIntervenants())));
			jtp.addTab("Client", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v9, controller.getEnteteIntervenants())));
			jtp.addTab("Support Technique", new JScrollPane(new JTableObjet(JTableObjet.FLAG_NEU, controller, false, false, v10, controller.getEnteteIntervenants())));
			break;
		case FLAG_INTER:

			break;
		}
	}
	
}
