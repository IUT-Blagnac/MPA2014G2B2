package Tests;
import junit.framework.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import Controler.Controller;
import Model.Etudiants;
import Model.Groupes;
import Model.Intervenants;
import Model.Projets;
import Model.Sujets;
import View.OPTIlib;

public class OPTIlibTest extends TestCase {
	
	private static final String testFilesPath = "./";
	// Mettre 	"./bin/" 	pour que les tests fonctionne sous Eclipse
	// Mettre 	"./" 		pour que les tests lances par le make.bat fonctionne
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new TestSuite(OPTIlibTest.class));
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public void test_read_unknown_csv() {
		boolean exception = false ;
		try { OPTIlib.CSV_Read("ThisRandomFile"+randInt(100,999)+"NotExist.csv"); }
		catch (Exception e) { exception = true ; };
		assertTrue("OPTIlib.CSV_Read() doit lever une exception en cas de fichier inconnu", exception);
	}
	
	public void test_read_content_csv() {
		boolean fichierChargee;
		try {
			Vector<String[]> arrayListRecuperee = OPTIlib.CSV_Read(testFilesPath+"intervenants2014_2015.csv");
			fichierChargee = true;
			
			if(fichierChargee) {
				String[][] donneesAttendues = {
					{ "id", "prénom", "nom" },
					{ "0", "nomI", "prenomI" }
				};
				for(int i=0; i<arrayListRecuperee.size(); i++) {
					for(int j=0; j<arrayListRecuperee.get(i).length; j++) {
						assertEquals("Verification contenu retourné/attendu",donneesAttendues[i][j],arrayListRecuperee.get(i)[j]);
					}
				}
			}
		} catch(Exception e) {
			fichierChargee = false;
		}
		assertTrue("Chargement du fichier intervenants2014_2015.csv",fichierChargee);
	}
	
	public void test_read_csv_vide() {
		boolean fichierChargee = false;
		try {
			Vector<String[]> listeLecture = OPTIlib.CSV_Read(testFilesPath+"fichierVide.csv");
			fichierChargee = true;
			
			boolean listeVide = true;
			if(listeLecture.size() != 0) {
				listeVide = false;
			}
			assertTrue("fichierVide.csv non vide", listeVide);
		} catch(Exception e) {
			fichierChargee = false;
		}
		assertTrue("Chargement du fichier fichierVide.csv", fichierChargee);
	}
	
	public void test_read_csv_uneColonne() {
		boolean fichierChargee = false;
		try {
			Vector<String[]> arrayListRecuperee = OPTIlib.CSV_Read(testFilesPath+"fichierUneColonne.csv");
			fichierChargee = true;
			if(fichierChargee) {
				String[][] donneesAttendues = {
						{"Numero de Sprint"},
						{"Sprint -1"},
						{"Sprint 0"},
						{"Sprint 1"}
				};
				for(int i=0; i<arrayListRecuperee.size(); i++) {
					for(int j=0; j<arrayListRecuperee.get(i).length; j++) {
						assertEquals("Verification contenu retourné/attendu",donneesAttendues[i][j],arrayListRecuperee.get(i)[j]);
					}
				}
			}
		} catch (Exception e) {
			fichierChargee = false;
		}
		assertTrue("Chargement du fichier fichierUneColonne.csv",fichierChargee);
	}
	
	public void test_write_without_permissions() {
		boolean exception = false;
		Vector<Vector<String>> dataTab = new Vector<Vector<String>>(); 
		Vector<String> entete = new Vector<String>();
		try { OPTIlib.CSV_Write(dataTab, entete,"File"+randInt(100,999)+"ThatDoesntExist/fichier.csv" ); }
		catch (Exception e) { exception = true ; };
		assertTrue("Dossier inexistant ou de problème de droit d'écriture", exception);
	}
	
	public void test_write_data_conform() {
		Vector<Vector<String>> dataTab = new Vector<Vector<String>>(); 
		Vector<String> entete = new Vector<String>();		
		boolean contenu=false;
		String concat="";
		String[] tabStr= new String[2];
		String[][] tabSt = {	{ "prénom", "âge" },
								{ "Cécile", "18 ans"},
								{ "Gab", "20 ans"}
							};
		for (int i = 0; i < tabSt[0].length; i++) {
			entete.add(tabSt[0][i]);
		}
		for (int i = 1; i < tabSt.length; i++) {
			Vector<String> v1 = new Vector<String>();
			
			for (int j = 0; j < tabSt[0].length; j++) {
				v1.add(tabSt[i][j]);
			}
			dataTab.add(v1);
		}
		
		try { 
			OPTIlib.CSV_Write(dataTab, entete,"testContenu.csv" );
			BufferedReader csvFile = new BufferedReader(new FileReader("testContenu.csv"));
			try {
				String line;
				while ((line = csvFile.readLine()) != null) {
					int i=0;
					tabStr[i]=line;
					concat+=tabStr[i]+"\r\n";
					i++;
				}
			} 
			finally {
				csvFile.close();
			}
		} catch (Exception e) {
			System.out.println("Erreur --" + e);
		};
		String verif="prénom"+OPTIlib.separator+"âge\r\nCécile"+OPTIlib.separator+"18 ans\r\nGab"+OPTIlib.separator+"20 ans\r\n";
		if(verif.equals(concat)){
			contenu=true;
		}
		
		assertTrue("Vérification contenu écrit/fichier", contenu);
	}
	
	
	
	public void test_sauvegarder() {
		boolean contenu = false;
		String projetConcat = "";
		String etudiantConcat = "";
		String intervenantConcat = "";
		String sujetConcat = "";

		Vector<Projets> projets = new Vector<Projets>();
		Vector<Sujets> sujets = new Vector<Sujets>();
		Vector<Groupes> groupes = new Vector<Groupes>();
		Vector<Etudiants> etudiants = new Vector<Etudiants>();
		Vector<Intervenants> intervenants = new Vector<Intervenants>();

		sujets.add(new Sujets("id", "nom", "titre"));
		intervenants.add(new Intervenants(0, "nomI", "prenomI"));
		groupes.add(new Groupes());
		etudiants.add(new Etudiants(0, "nomE", "prenomE", groupes.get(0)));
		projets.add(new Projets(0, groupes.get(0), sujets.get(0), intervenants.get(0), intervenants.get(0), intervenants.get(0)));
		groupes.get(0).setIdGroupe("0");
		groupes.get(0).setEtudiants(etudiants);
		groupes.get(0).setProjet(projets.get(0));

		String projetVerif="groupe;sujet\r\nA"+OPTIlib.separator+"id\r\n";
		String sujetVerif="id;nom;titre\r\nid"+OPTIlib.separator+"nom"+OPTIlib.separator+"titre\r\n";
		String etudiantVerif="groupe;nom;prenom\r\nA"+OPTIlib.separator+"nomE"+OPTIlib.separator+"prenomE\r\n";
		String intervenantVerif="pr�nom;nom\r\nprenomI"+OPTIlib.separator+"nomI\r\n";

		//sauvegarder
		Controller controller = new Controller();
		controller.setProjets(projets);
		controller.setSujets(sujets);
		controller.setIntervenants(intervenants);
		controller.setGroupes(groupes);

		try {
		OPTIlib.CSV_Write(controller.castVecProjets(), controller.getEnteteProjets(), "projets2014_2015.csv");
		OPTIlib.CSV_Write(controller.castVecSujets(), controller.getEnteteSujets(), "sujets2014_2015.csv");
		OPTIlib.CSV_Write(controller.castVecGroupes(), controller.getEnteteGroupes(), "etudiants2014_2015.csv");
		OPTIlib.CSV_Write(controller.castVecIntervenants(), controller.getEnteteIntervenants(), "intervenants2014_2015.csv");
		////////////////

		BufferedReader csvFile = new BufferedReader(new FileReader("projets2014_2015.csv"));
		try {
		String line;
		ArrayList<String> listeProj=new ArrayList();
		while ((line = csvFile.readLine()) != null) {
		int i=0;
		listeProj.add(line);
		projetConcat+=listeProj.get(i)+"\r\n";
		i++;
		}
		csvFile.close();
		} catch (Exception e) {
		System.out.println("Erreur -proj- " + e);
		}

		csvFile = new BufferedReader(new FileReader("etudiants2014_2015.csv"));
		try {
		String line;
		ArrayList<String> listeEtu=new ArrayList();
		while ((line = csvFile.readLine()) != null) {
		int i=0;
		listeEtu.add(line);
		etudiantConcat+=listeEtu.get(i)+"\r\n";
		i++;
		}
		csvFile.close();
		} catch (Exception e) {
		System.out.println("Erreur -etu- " + e);
		}

		csvFile = new BufferedReader(new FileReader("sujets2014_2015.csv"));
		try {
		String line;
		ArrayList<String> listeSuj=new ArrayList();
		while ((line = csvFile.readLine()) != null) {
		int i=0;
		listeSuj.add(line);
		sujetConcat+=listeSuj.get(i)+"\r\n";
		i++;
		}
		csvFile.close();
		} catch (Exception e) {
		System.out.println("Erreur -suj- " + e);
		}

		csvFile = new BufferedReader(new FileReader("intervenants2014_2015.csv"));
		try {
		String line;
		ArrayList<String> listeInter=new ArrayList();
		while ((line = csvFile.readLine()) != null) {
		int i=0;
		listeInter.add(line);
		intervenantConcat+=listeInter.get(i)+"\r\n";
		i++;
		}
		csvFile.close();
		} catch (Exception e) {
		System.out.println("Erreur -inter- " + e);
		}

		} catch (Exception e1) {
		e1.printStackTrace();
		}

		if(projetVerif.equals(projetConcat) || sujetVerif.equals(sujetConcat) || etudiantVerif.equals(etudiantConcat) || intervenantVerif.equals(intervenantConcat)){
		contenu=true;
		}

		assertTrue("Vérification contenu écrit/fichier", contenu);
		} 
	

}