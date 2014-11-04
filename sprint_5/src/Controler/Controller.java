package Controler;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Model.Etudiants;
import Model.Groupes;
import Model.Intervenants;
import Model.Projets;
import Model.Sujets;
import Model.Voeux;

public class Controller {
	private JMenuBar menuBar;
	private JFrame myFrame;
	private JFrame myFrameCSV;
	private JPanel jF;

	private Vector<Projets> projets;
	private Vector<Sujets> sujets;
	private Vector<Groupes> groupes;
	private Vector<Intervenants> intervenants;
	private Vector<Etudiants> etudiants;
	private Vector<Voeux> voeux;
	
	private Vector<JButton> boutons;
	private JTabbedPane tabPan;
	private Rectangle rec;
	
	private static Vector<String> enteteSujets;
	private static Vector<String> enteteGroupes;
	private static Vector<String> enteteProjets;
	private static Vector<String> enteteIntervenants;
	private static Vector<String> enteteVoeux;
	
	private Vector<Vector<String>> vecSujets;
	private Vector<Vector<String>> vecGroupes;
	private Vector<Vector<String>> vecProjets;
	private Vector<Vector<String>> vecIntervenants;
	private Vector<Vector<String>> vecVoeux;
	
	
	private Groupes groupeVide;
	private Intervenants intervenantVide;
	
	
	
	public Controller (){
		enteteSujets = new Vector<String>();
		enteteSujets.add("id");
		enteteSujets.add("nom");
		enteteSujets.add("titre");
		
		enteteGroupes = new Vector<String>();
		enteteGroupes.add("id");
		enteteGroupes.add("groupe");
		enteteGroupes.add("nom");
		enteteGroupes.add("prénom");
		
		enteteProjets = new Vector<String>();
		enteteProjets.add("id");
		enteteProjets.add("groupe");
		enteteProjets.add("sujet");
		enteteProjets.add("client");
		enteteProjets.add("superviseur");
		enteteProjets.add("support_technique");
		
		enteteIntervenants = new Vector<String>();
		enteteIntervenants.add("id");
		enteteIntervenants.add("prénom");
		enteteIntervenants.add("nom");


		setGroupeVide(new Groupes("GroupeVide", new Vector<Etudiants>(), null));
		setIntervenantVide(new Intervenants(0,"",""));
		
		enteteVoeux = new Vector<String>();
		enteteVoeux.add("groupe");
		enteteVoeux.add("sujet");
		enteteVoeux.add("numero");
		

	}
	
	/**
	 * Permet de creer un Vector<Vector<String>> a partir d'un Vector<Sujets>
	 * @return Vector<Vector<String>>
	 */
	public Vector<Vector<String>> castVecSujets(){
		vecSujets = new Vector<Vector<String>>();
		for(int i = 0; i<sujets.size(); i++)
			vecSujets.add(sujets.get(i).getVec());
		return vecSujets;
	}
	
	public Vector<Vector<String>> getVecSujets(){
		return vecSujets;
	}
	
	public Vector<String> getEnteteSujets(){
		return enteteSujets;
	}
	
	/**
	 * Permet de creer un Vector<Vector<String>> a partir d'un Vector<Groupes>
	 * @return Vector<Vector<String>>
	 */
	public Vector<Vector<String>> castVecGroupes(){
		vecGroupes = new Vector<Vector<String>>();
		for(int i = 0; i<groupes.size(); i++){
			for(int u = 0; u<groupes.get(i).getVec().size(); u++)
				vecGroupes.add(groupes.get(i).getVec().get(u));
		}
		return vecGroupes;
	}
	
	public Vector<Vector<String>> getVecGroupes(){
		return vecGroupes;
	}
	
	public Vector<String> getEnteteGroupes(){
		return enteteGroupes;
	}
	
	/**
	 * Permet de creer un Vector<Vector<String>> a partir d'un Vector<Projets>
	 * @return Vector<Vector<String>>
	 */
	public Vector<Vector<String>> castVecProjets(){
		vecProjets = new Vector<Vector<String>>();
		for(int i = 0; i<projets.size(); i++){
			vecProjets.add(projets.get(i).getVec());
		}
		return vecProjets;
	}
	
	public Vector<Vector<String>> getVecProjets(){
		return vecProjets;
	}
	
	public Vector<String> getEnteteProjets(){
		return enteteProjets;
	}
	
	/**
	 * Permet de creer un Vector<Vector<String>> a partir d'un Vector<Intervenants>
	 * @return Vector<Vector<String>>
	 */
	public Vector<Vector<String>> castVecIntervenants(){
		vecIntervenants = new Vector<Vector<String>>();
		for(int i = 0; i<intervenants.size(); i++){
			vecIntervenants.add(intervenants.get(i).getVec());
		}
		return vecIntervenants;
	}
	
	public Vector<Vector<String>> getVecIntervenants(){
		return vecIntervenants;
	}
	
	public Vector<String> getEnteteIntervenants(){
		return enteteIntervenants;
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	public JFrame getMyFrame() {
		return myFrame;
	}
	public void setMyFrame(JFrame myFrame) {
		this.myFrame = myFrame;
	}
	public JFrame getMyFrameCSV() {
		return myFrameCSV;
	}
	public void setMyFrameCSV(JFrame myFrameCSV) {
		this.myFrameCSV = myFrameCSV;
	}
	public JPanel getjF() {
		return jF;
	}
	public void setjF(JPanel jF) {
		this.jF = jF;
	}
	
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	
	/**
	 * Renvoie une ArrayList de Projet
	 * @return ArrayList<Projet>
	 */
	public Vector<Projets> getProjets() {
		return projets;
	}
	
	/**
	 * Fonction potentiellement inutile
	 * @param projets
	 */
	public void setProjets(Vector<Projets> projets) {
		this.projets = projets;
	}
	
	/**
	 * Retourne une ArrayList de Sujet
	 * @return ArrayList<Sujet>
	 */
	public Vector<Sujets> getSujets() {
		return sujets;
	}
	
	/**
	 * Fonction potentiellement inutile
	 * @param projets
	 */
	public void setSujets(Vector<Sujets> sujets) {
		this.sujets = sujets;
	}


	public Vector<Intervenants> getIntervenants() {
		return intervenants;
	}
	public void setIntervenants(Vector<Intervenants> intervenants) {
		this.intervenants = intervenants;
	}
	public JTabbedPane getTabPan() {
		return tabPan;
	}
	public void setTabPan(JTabbedPane tabPan) {
		this.tabPan = tabPan;
	}
	public Rectangle getRec() {
		return rec;
	}
	public void setRec(Rectangle rec) {
		this.rec = rec;
	}
	public Vector<Groupes> getGroupes() {
		return groupes;
	}
	public void setGroupes(Vector<Groupes> groupes) {
		this.groupes = groupes;
	}

	public Groupes getGroupeVide() {
		return groupeVide;
	}

	public void setGroupeVide(Groupes groupeVide) {
		this.groupeVide = groupeVide;
	}

	public Vector<Etudiants> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Vector<Etudiants> etudiants) {
		this.etudiants = etudiants;
	}

	public Intervenants getIntervenantVide() {
		return intervenantVide;
	}

	public void setIntervenantVide(Intervenants intervenantVide) {
		this.intervenantVide = intervenantVide;
	}
	
}
