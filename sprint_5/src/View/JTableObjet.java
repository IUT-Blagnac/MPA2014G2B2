package View;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Controler.Controller;
import Model.Groupes;

/**
 * Permet d'afficher des Table en fonction du flag en entré
 * 
 */

@SuppressWarnings("serial")
public class JTableObjet extends JPanel {
	private JPanel mySelf;
	private JTable tableau;
	public static final int FLAG_PRO = 1;
	public static final int FLAG_NEU = 2;
	public static final int FLAG_INTER = 3;
	public static final int FLAG_SUJ = 4;
	public static final int FLAG_PROS = 5;
	public static final int FLAG_ETU = 6;
	private Vector<Vector<String>> vec;
	private Vector<String> entete;
	private int flagSelected;
	private Controller controller;
	private String csvPath;
	private JTextField valeurFiltreDef = new JTextField("");
	private JComboBox comboFiltre = null;
	private Vector<String> v3 = new Vector<String>();
	private JPanel central = new JPanel(new BorderLayout());
	private JPanel listeEntete = new JPanel();

	public JTableObjet(int flag, Controller controller, boolean activeMenu, boolean c, Vector<Vector<String>> vecNeu, Vector<String> enteteNeu) {
		super(new BorderLayout());
		mySelf = this;
		flagSelected = flag;
		this.controller = controller;
		JPanel boutons = new JPanel();
		Vector<String> v3 = new Vector<String>();	
		JLabel titreEntete = new JLabel("Filtrer par :");
		valeurFiltreDef.setPreferredSize(new Dimension(150, 30));

		
		
		//ajout des boutons "ajouter" "supprimer" a l'interface 
				boutons.add(new JButton(new AddAction()));
				boutons.add(new JButton(new RemoveAction()));
				boutons.add(new JButton(new SauvegardeAction()));
				boutons.add(new JButton(new EnreSousAction()));

			
		switch(flagSelected){
		case FLAG_PRO:
			tableau = new JTable(controller.castVecProjets(), controller.getEnteteProjets());				//initialisation des tableaux qui contenant les informations des fichiers CSV			
			vec = controller.getVecProjets();					//saisie des Projets
			entete = controller.getEnteteProjets();				//saisie de l'entete du fichier CSV "Projets" entete est un Vector<String>

		
			//add(boutons, BorderLayout.SOUTH);
			csvPath = "data/projets2014_2015.csv";
			Vector<String> v1 = new Vector<String>();
			Vector<String> v2 = new Vector<String>();
			Vector<String> v4 = new Vector<String>();
			
			for(int i = 0; i<controller.getGroupes().size(); i++)
				v1.add(controller.getGroupes().get(i).getIdGroupe());
			
			for(int i = 0; i<controller.getSujets().size(); i++)
				v2.add(controller.getSujets().get(i).getId());
			
			v4.add(""+controller.getIntervenantVide().getId());
			for(int i = 0; i<controller.getIntervenants().size(); i++)
				v4.add(""+controller.getIntervenants().get(i).getId());

			boutons.add(new JButton(new DuplicateAction()));
			JComboBox myCombo = new JComboBox(v1);
			tableau.getColumn(controller.getEnteteProjets().get(1)).setCellEditor(new DefaultCellEditor(myCombo));
			
			JComboBox myCombo2 = new JComboBox(v2);
			tableau.getColumn(controller.getEnteteProjets().get(2)).setCellEditor(new DefaultCellEditor(myCombo2));
			
			JComboBox myCombo4 = new JComboBox(v4);
			tableau.getColumn(controller.getEnteteProjets().get(3)).setCellEditor(new DefaultCellEditor(myCombo4));
			tableau.getColumn(controller.getEnteteProjets().get(4)).setCellEditor(new DefaultCellEditor(myCombo4));
			tableau.getColumn(controller.getEnteteProjets().get(5)).setCellEditor(new DefaultCellEditor(myCombo4));

			
			for(int i = 0; i<controller.getEnteteProjets().size(); i++)
				v3.add(controller.getEnteteProjets().get(i));

			
			
			comboFiltre = new JComboBox(v3);

			

			central.add(listeEntete, BorderLayout.NORTH);
			tableau.setEditingRow(0);
			tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			break;
		case FLAG_NEU:
			   tableau = new JTable(vecNeu, enteteNeu);    //initialisation des tableaux qui contenant les informations des fichiers CSV   
			   vec = vecNeu;     //saisie des Projets
			   entete = enteteNeu;    //saisie de l'entete du fichier CSV "Projets" entete est un Vector<String>
			   
			   break;
		case FLAG_INTER:
			tableau = new JTable(controller.castVecIntervenants(), controller.getEnteteIntervenants());			
			vec = controller.getVecIntervenants();		
			entete = controller.getEnteteIntervenants();
			csvPath = "data/intervenants2014_2015.csv";
			for(int i = 0; i<controller.getEnteteIntervenants().size(); i++)
				v3.add(controller.getEnteteIntervenants().get(i));
			
			comboFiltre = new JComboBox(v3);

			
			break;
		case FLAG_SUJ:
			tableau = new JTable(controller.castVecSujets(), controller.getEnteteSujets());
			vec = controller.getVecSujets();
			entete = controller.getEnteteSujets();
			//On enregistre le chemin du CSV pour pourvoir sauvegarder
			csvPath = "data/sujets2014_2015.csv";
			for(int i = 0; i<controller.getEnteteSujets().size(); i++)
				v3.add(controller.getEnteteSujets().get(i));
			
			comboFiltre = new JComboBox(v3);	
			break;
		case FLAG_ETU:
			tableau = new JTable(controller.castVecGroupes(), controller.getEnteteGroupes());			
			vec = controller.getVecGroupes();		
			entete = controller.getEnteteGroupes();
			csvPath = "data/etudiants2014_2015.csv";
			for(int i = 0; i<controller.getEnteteGroupes().size(); i++)
				v3.add(controller.getEnteteGroupes().get(i));
			
			comboFiltre = new JComboBox(v3);
			break;
		}
		if(activeMenu){
		listeEntete.add(titreEntete);
		listeEntete.add(comboFiltre);
		listeEntete.add(valeurFiltreDef);
		listeEntete.add(new JButton(new AddFiltrer()));
		listeEntete.add(new JButton(new CancelFiltrer()));
		central.add(listeEntete, BorderLayout.NORTH);
		central.add(new JSeparator(JSeparator.HORIZONTAL),
		          BorderLayout.LINE_START);
		add(boutons, BorderLayout.SOUTH);

		}
	
		central.add(new JScrollPane(tableau), BorderLayout.CENTER);
		add(central, BorderLayout.CENTER);

	}


	/**
	 * Permet d'ajouter un élément dans le fichier CSV
	 * 
	 */

	private class AddAction extends AbstractAction {
		private AddAction() {
			super("Ajouter");
		}

		public void actionPerformed(ActionEvent e) {
			Vector<String> vectVide = new Vector<String>();
			for(int i=0 ; i<entete.size();i++ )
			{
				vectVide.add("");		//remplissage de chaque case du Vector avec des chaines vides pour obtenir la ligne vide
			}	
			vec.add(vectVide); 			//ajout de la ligne vide a linterface
			tableau.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		//Réajustement de la taille du tableau
			tableau.repaint(); 			//rechargement visuel de l'interface

		}
	}

	/**
	 * Permet de supprimer un ou plusieurs élément d'un fichier CSV
	 * 
	 */

	private class RemoveAction extends AbstractAction {
		private RemoveAction() {
			super("Supprimer");
		}

		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows(); 	//on releve les lignes selectionnées par la souris

			for (int i = selection.length-1; i >= 0; i--){
					//Suppression des elements selectionnés
				vec.remove(selection[i]);
				//BLEMME A CORIGER SUR PROJET LORSQUE L4ON SUPPRIME LE DERNIER CELUI FAIT FAIT NAWAK
				
			}
			vec.trimToSize();
			tableau.clearSelection();	//reinitialise la selection
			tableau.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);	//Réajustement de la taille du tableau
			tableau.repaint();	//rechargement visuel de l'interface
		}
	}

	private class EnreSousAction extends AbstractAction {
		private EnreSousAction() {
			super("Enregistrer sous..");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    		"CSV files (*csv)", "csv");
		    fc.setFileFilter(filter);
		    
			int returnVal = fc.showSaveDialog(mySelf);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
            	
                File file = fc.getSelectedFile();
                String fileName = file.getName() + ".1";
                String[] fileNameE = fileName.split("\\.");
                try {
					OPTIlib.CSV_Write(vec, entete, file.getAbsolutePath().replace(file.getName(), "")+fileNameE[0]+".csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } 
		}
	}
	
	
	private class SauvegardeAction extends AbstractAction {
		private SauvegardeAction() {
			super("Enregistrer");
		}

		public void actionPerformed(ActionEvent e) {
			try {
				OPTIlib.CSV_Write(vec, entete, csvPath);
				OPTIlib.rechargeIt(controller);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	private class DuplicateAction extends AbstractAction {
		private DuplicateAction() {
			super("Dupliquer");
		}

	
	/**
	 * Permet de sauvegarder en CSV
	 * 
	 */

		public void actionPerformed(ActionEvent e) {
			
			int[] selection = tableau.getSelectedRows(); 	//on releve les lignes selectionnées par la souris

			Vector<String> vv = new Vector<String>();
			
			vv.add(""+(new Integer(vec.size()+1)));
			vv.add(controller.getGroupeVide().getIdGroupe());
			vv.add(vec.get(selection[0]).get(2));
			vv.add(vec.get(selection[0]).get(3));
			vv.add(vec.get(selection[0]).get(4));
			vv.add(vec.get(selection[0]).get(5));
			vec.add(vv);
			vec.get(vec.size()-1).set(1, controller.getGroupeVide().getIdGroupe());
				
			vec.trimToSize();
			tableau.clearSelection();	//reinitialise la selection
			tableau.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);	//Réajustement de la taille du tableau
			tableau.repaint();	//rechargement visuel de l'interface

		}
	}
	
	
	
	/*bouton "filtrer" permet de filtrer le contenu des CSV 
	 * 
	 */
	private class AddFiltrer extends AbstractAction {
		private AddFiltrer() {
			super("Filtrer");
		}

		public void actionPerformed(ActionEvent e) {
		Vector<Vector<String>> vecTemp = new Vector<Vector<String>>();
		
		for(int i = 0; i<vec.size();i++)
		{
			if(vec.get(i).get(comboFiltre.getSelectedIndex()).contains(valeurFiltreDef.getText()))
			{
				vecTemp.add(vec.get(i));	//ajout des lignes contenant le mot clé utlisisé dans le filtrage au vecteur temporaire
			}
		}
		
		vec.trimToSize();
		central.removeAll();	//suppression du tableau visible (car celui ci ne correspond pas a la recherche)
		central.revalidate();	//met a jour le tableau (equivalent a repaint)
		tableau = new JTable(vecTemp, entete);	//initialisation du nouveau tableau contenant les elements recherchés
		central.add(listeEntete, BorderLayout.NORTH);	//réajout de tous les éléments de l'interface car "removeall" a fait son job
		central.add(new JSeparator(JSeparator.HORIZONTAL),BorderLayout.LINE_START);
		central.add(new JScrollPane(tableau), BorderLayout.CENTER);
		mySelf.add(central , BorderLayout.CENTER);
		if(flagSelected == FLAG_PRO){
			Vector<String> v1 = new Vector<String>();
			Vector<String> v2 = new Vector<String>();
			
			for(int i = 0; i<controller.getGroupes().size(); i++)
				v1.add(controller.getGroupes().get(i).getIdGroupe());
			
			for(int i = 0; i<controller.getSujets().size(); i++)
				v2.add(controller.getSujets().get(i).getId());
			
			JComboBox myCombo = new JComboBox(v1);
			tableau.getColumn(controller.getEnteteProjets().get(0)).setCellEditor(new DefaultCellEditor(myCombo));
			
			JComboBox myCombo2 = new JComboBox(v2);
			tableau.getColumn(controller.getEnteteProjets().get(1)).setCellEditor(new DefaultCellEditor(myCombo2));
		}
		central.repaint();
		System.out.println(vecTemp);	//affichage du contenu du vector temporaire (pas indispensable
		System.out.println(entete);
		}
	}
	
	/*bouton reinitialiser filtrage
	 * 
	 */
	private class CancelFiltrer extends AbstractAction {
		private Container boutons;

		private CancelFiltrer() {
			super("Réinitialiser");
		}

		public void actionPerformed(ActionEvent e) {
			vec.trimToSize();
			central.removeAll();	
			central.revalidate();
			tableau = new JTable(vec, entete);
			central.add(listeEntete, BorderLayout.NORTH);
			central.add(new JSeparator(JSeparator.HORIZONTAL),BorderLayout.LINE_START);
			central.add(new JScrollPane(tableau), BorderLayout.CENTER);
			mySelf.add(central , BorderLayout.CENTER);
			if(flagSelected == FLAG_PRO){
				Vector<String> v1 = new Vector<String>();
				Vector<String> v2 = new Vector<String>();
				Vector<String> v4 = new Vector<String>();
				
				for(int i = 0; i<controller.getGroupes().size(); i++)
					v1.add(controller.getGroupes().get(i).getIdGroupe());
				
				for(int i = 0; i<controller.getSujets().size(); i++)
					v2.add(controller.getSujets().get(i).getId());
				
				v4.add(""+controller.getIntervenantVide().getId());
				for(int i = 0; i<controller.getIntervenants().size(); i++)
					v4.add(""+controller.getIntervenants().get(i).getId());
				
				JComboBox myCombo = new JComboBox(v1);
				tableau.getColumn(controller.getEnteteProjets().get(1)).setCellEditor(new DefaultCellEditor(myCombo));
				
				JComboBox myCombo2 = new JComboBox(v2);
				tableau.getColumn(controller.getEnteteProjets().get(2)).setCellEditor(new DefaultCellEditor(myCombo2));
				
				JComboBox myCombo4 = new JComboBox(v4);
				tableau.getColumn(controller.getEnteteProjets().get(3)).setCellEditor(new DefaultCellEditor(myCombo4));
				tableau.getColumn(controller.getEnteteProjets().get(4)).setCellEditor(new DefaultCellEditor(myCombo4));
				tableau.getColumn(controller.getEnteteProjets().get(5)).setCellEditor(new DefaultCellEditor(myCombo4));
			}
			central.repaint();
			System.out.println(vec);
			System.out.println(entete);
			
		}
	}
}