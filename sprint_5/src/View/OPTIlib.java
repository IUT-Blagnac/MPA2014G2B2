package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Controler.Controller;
import Model.Etudiants;
import Model.Groupes;
import Model.Intervenants;
import Model.Projets;
import Model.Sujets;


public class OPTIlib {
	
	public static final String separator = ";";
	
	/**
	 * Genere un fichier CSV a partir d une ArrayList<String[]>
	 * 
	 * @param dataTab
	 * @param csvPath
	 * @throws Exception 
	 */
	public static void CSV_Write(Vector<Vector<String>> dataTab, Vector<String> entete, String csvPath) throws Exception {
		Writer csvFile = new BufferedWriter(new OutputStreamWriter(
			    new FileOutputStream(csvPath), "UTF-8"));
		String dataStr="";
		for(int i = 0; i<entete.size(); i++){
			dataStr += entete.get(i) + separator;
		}
		csvFile.write( dataStr.substring(0, dataStr.length() - 1)+ "\r\n");
		
		for (int i = 0; i < dataTab.size(); i++) {
			dataStr = "";
			for (int u = 0; u < dataTab.get(i).size(); u++) {
				dataStr += dataTab.get(i).get(u) + separator;
			}
			csvFile.write( dataStr.substring(0, dataStr.length() - 1)+ "\r\n");
		}
		csvFile.close();
	}

	/**
	 * Lit et convertit un fichier CSV en ArrayList<String[]>
	 * 
	 * @param csvPath
	 * @return dataTab
	 * @throws Exception 
	 */
	public static Vector<String[]> CSV_Read(String csvPath) throws Exception {
		Vector<String[]> dataTab = new Vector<String[]>();
		BufferedReader csvFile = new BufferedReader(new FileReader(csvPath));
		String line;
		while ((line = csvFile.readLine()) != null) {
			if(line.substring(0, 0) != "#")
				dataTab.add(new String(line.getBytes(), Charset.forName("UTF-8")).split(separator));
		}
		csvFile.close();
		return dataTab;
	}
		
	
	public static boolean findFiles(String directoryPath, Controller controller) {
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			System.out.println("Le fichier/répertoire '" + directoryPath
					+ "' n'existe pas");
			return false;
		} else if (!directory.isDirectory()) {
			System.out.println("Le chemin '" + directoryPath
					+ "' correspond � un fichier et non � un r�pertoire");
			return false;
		} else {
			File[] subfiles = directory.listFiles();
			Vector<String[]> tmp = null;

			String message = "Le r�pertoire '" + directoryPath + "' contient "
					+ subfiles.length + " fichier"
					+ (subfiles.length > 1 ? "s" : "");
			System.out.println(message);

			// On charge les sujets

			int i = 0;
			while (!subfiles[i].getName().contains("sujets"))
				i++;
			try {
				tmp = OPTIlib.CSV_Read(subfiles[i].getAbsolutePath());
				controller.setSujets(new Vector<Sujets>(tmp.size()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int u = 1; u < tmp.size(); u++) {
				controller.getSujets().add(new Sujets(tmp.get(u)[0], tmp.get(u)[1],
						tmp.get(u)[2]));
			}

			i = 0;
			while (!subfiles[i].getName().contains("etudiants"))
				i++;
			try {
				tmp = OPTIlib.CSV_Read(subfiles[i].getAbsolutePath());

				controller.setGroupes(new Vector<Groupes>(tmp.size()));
				controller.getGroupes().add(controller.getGroupeVide());
				controller.setEtudiants(new Vector<Etudiants>(tmp.size()));

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			for (int u = 1; u < tmp.size(); u++) {
				boolean exist = false;
				int p = 0;
				for(int k = 0; k<controller.getGroupes().size() && !exist; k++){
					if(tmp.get(u)[0].equals(controller.getGroupes().get(k).getIdGroupe())){
						exist = true;
						p = k;
					}
				}
				
				Etudiants tmpEtu = new Etudiants(new Integer(tmp.get(u)[1]),tmp.get(u)[2], tmp.get(u)[3], null); 
				controller.getEtudiants().add(tmpEtu);
				if(exist){
					
					controller.getGroupes().get(p).getEtudiants().add(tmpEtu);
					tmpEtu.setGroupe(controller.getGroupes().get(p));
					
				}else{
					
					controller.getGroupes().add(new Groupes(tmp.get(u)[0], new Vector<Etudiants>(), null));
					controller.getGroupes().get(controller.getGroupes().size()-1).getEtudiants().add(tmpEtu);
					tmpEtu.setGroupe(controller.getGroupes().get(controller.getGroupes().size()-1));
				}
				
				
			}

			i = 0;
			while (!subfiles[i].getName().contains("intervenants"))
				i++;
			try {
				tmp = OPTIlib.CSV_Read(subfiles[i].getAbsolutePath());
				controller.setIntervenants(new Vector<Intervenants>(tmp.size()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (int u = 1; u < tmp.size(); u++) {
				controller.getIntervenants().add(new Intervenants(new Integer(tmp.get(u)[0]), tmp.get(u)[1], tmp.get(u)[2]));
			}

			i = 0;
			while (!subfiles[i].getName().contains("projets"))
				i++;
			try {
				tmp = OPTIlib.CSV_Read(subfiles[i].getAbsolutePath());
				controller.setProjets(new Vector<Projets>(tmp.size()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			Sujets tmpSujet = null;
			Groupes tmpGroupe = null;
			Intervenants tmpClient = null;
			Intervenants tmpInter = null;
			Intervenants tmpSupport = null;

			for (int u = 1; u < tmp.size(); u++) {

				for (int o = 0; o < controller.getGroupes().size(); o++) {
					if (controller.getGroupes().get(o).getIdGroupe().equals(tmp.get(u)[1]))
						tmpGroupe = controller.getGroupes().get(o);
				}
				
				for (int o = 0; o < controller.getSujets().size(); o++) {
					if (controller.getSujets().get(o).getId().equals(tmp.get(u)[2]))
						tmpSujet = controller.getSujets().get(o);
				}
				
				if(new Integer(tmp.get(u)[3]) != 0){
					for (int o = 0; o < controller.getIntervenants().size(); o++) {
						if (controller.getIntervenants().get(o).getId() == new Integer(tmp.get(u)[3]))
							tmpClient = controller.getIntervenants().get(o);
					}
				}else{
					tmpClient = controller.getIntervenantVide();
				}
				
				if(new Integer(tmp.get(u)[4]) != 0){
					for (int o = 0; o < controller.getIntervenants().size(); o++) {
						if (controller.getIntervenants().get(o).getId() == new Integer(tmp.get(u)[4]))
							tmpInter = controller.getIntervenants().get(o);
					}
				}else{
					tmpInter = controller.getIntervenantVide();
				}
				
				if(new Integer(tmp.get(u)[5]) != 0){
					for (int o = 0; o < controller.getIntervenants().size(); o++) {
						if (controller.getIntervenants().get(o).getId() == new Integer(tmp.get(u)[5]))
							tmpSupport = controller.getIntervenants().get(o);
					}
				}else{
					tmpSupport = controller.getIntervenantVide();
				}

				controller.getProjets().add(new Projets(new Integer(tmp.get(u)[0]), tmpGroupe, tmpSujet, tmpClient, tmpInter, tmpSupport));
				if(tmpGroupe != controller.getGroupeVide())
					tmpGroupe.setProjet(controller.getProjets().get(controller.getProjets().size()-1));
				
				tmpSujet = null;
				tmpGroupe = null;
				tmpClient = null;
				tmpInter = null;
				tmpSupport = null;

			}

			return true;
		}
	}

	
	public static void rechargeIt(Controller controller) {
		boolean beugDansData = findFiles("data", controller);
		if (!beugDansData) {
			JFrame jFr = new JFrame();
			jFr.setPreferredSize(new Dimension(400, 400));
			JLabel jL = new JLabel(
					"Veuillez mettre tout les csv dans le dossier \"data\".");
			jL.setHorizontalAlignment(JLabel.CENTER);
			jFr.add(jL, BorderLayout.CENTER);
			jFr.pack();
			jFr.setVisible(true);
		} else { 
			controller.getjF().removeAll();
			controller.getjF().setLayout(new BorderLayout());
			JTabbedPane jtP = new JTabbedPane();
			controller.getjF().add(jtP, BorderLayout.NORTH);
			
			JPanel jP = new JPanel(new GridLayout(1,2));
			JPanel jpp = new JPanel(new GridLayout(controller.getGroupes().size(),1));
			JPanel jPIN = new JPanel(new BorderLayout());
			jPIN.setPreferredSize(new Dimension(0, controller.getRec().height-100));
			JScrollPane jspa2 = new JScrollPane(jpp);
			jPIN.add(jspa2, BorderLayout.CENTER);
			jP.add(jPIN);
			jspa2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jtP.addTab("Groupes", new JScrollPane(jP));
			JPanel jpData = new JPanel(new BorderLayout());
			jP.add(jpData);
			
			Vector<JButton> vectorGroupes = new Vector<JButton>();
			for (int i = 1; i < controller.getGroupes().size(); i++) {
				vectorGroupes.add(new JButton(controller.getGroupes().get(i).getIdGroupe()));
				jpp.add(vectorGroupes.get(i-1));
				vectorGroupes.get(i-1).addActionListener(new ActionListenerAS(controller, jpData, ActionListenerAS.FLAG_GRO, i));
				
			}
			
			JPanel jP2 = new JPanel(new GridLayout(1,2));
			JPanel jP2IN = new JPanel(new BorderLayout());
			jP2IN.setPreferredSize(new Dimension(0, controller.getRec().height-100));
			JPanel jpp2 = new JPanel(new GridLayout(controller.getEtudiants().size(),1));
			JScrollPane jspa = new JScrollPane(jpp2);
			jspa.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jP2IN.add( jspa, BorderLayout.CENTER);
			jP2.add(jP2IN);
			jtP.addTab("Etudiants", jP2);
			JPanel jpData2 = new JPanel(new BorderLayout());
			jP2.add(jpData2);
			Vector<JButton> vectorEtudiants = new Vector<JButton>();
			for (int i = 0; i < controller.getEtudiants().size(); i++) {
				
				System.out.println(controller.getEtudiants().get(i).getNom());
				vectorEtudiants.add(new JButton(controller.getEtudiants().get(i).getNom()+" "+controller.getEtudiants().get(i).getPrenom()+" du groupe: "+controller.getEtudiants().get(i).getGroupe().getIdGroupe()));
				jpp2.add(vectorEtudiants.get(i));
				vectorEtudiants.get(i).addActionListener(new ActionListenerAS(controller, jpData2, ActionListenerAS.FLAG_ETU, i));
				
			}
			controller.getMyFrame().pack();
			// controller.getjF().add();
		}

		// REFAIRE DES FILE CHOOSER JUSQU'A CE QUE TOUT CE CHARGE !!!
		
	}

	public static void supprimer(Etudiants etu) {
		// TODO Auto-generated method stub
		
	}

	public static void startCSV(Controller controller) {
		controller.getTabPan().removeAll();

		controller.getTabPan().addTab("Sujet", new JScrollPane(new JTableObjet(JTableObjet.FLAG_SUJ, controller, true, true, null, null))); //Cr�er l'onglet Sujets
		controller.getTabPan().addTab("Etudiants", new JScrollPane(new JTableObjet(JTableObjet.FLAG_ETU, controller, true, true, null, null))); //Cr�er l'onglet Etudiants
		controller.getTabPan().addTab("Intervenants", new JScrollPane(new JTableObjet(JTableObjet.FLAG_INTER, controller, true, true, null, null))); //Cr�er l'onglet Intervenants
		controller.getTabPan().addTab("Projets", new JScrollPane(new JTableObjet(JTableObjet.FLAG_PRO, controller, true, true, null, null))); //Cr�er l'onglet Projets
		
		controller.getMyFrameCSV().setVisible(true);
		controller.getMyFrameCSV().pack();
		
	}
	
	

}
