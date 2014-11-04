package Model;

import java.util.Vector;

public class Voeux {
	private Groupes groupe;
	private Sujets sujet;
	private int numero;
	
	/**
	 * Constructeur par defaut
	 * Permet de construire un objet Voeux
	 * Initialise groupe, sujet et numero
	 */
	public Voeux() {
		this(null, null, 0);
	}
	
	/**
	 * Constructeur parametre
	 * Permet de construire un objet Voeux
	 * Initialise Etudiants, Sujets et numero avec les valeurs passees en parametres
	 * 
	 * @param etu
	 * @param suj
	 * @param numero
	 */
	public Voeux(Groupes groupe, Sujets sujet, int numero) {
		this.groupe = groupe;
		this.sujet = sujet;
		this.numero = numero;
	}
	
	/**
	 * Getter Groupe
	 * Retourne le groupe du voeu
	 * @return Groupes Groupe concerne
	 */
	public Groupes getGroupe() {
		return this.groupe;
	}
	
	/**
	 * Setter Groupe
	 * Definit le groupe du voeu 
	 * @param groupe
	 */
	public void setGroupe(Groupes groupe) {
		this.groupe = groupe;
	}
	
	/**
	 * Getter Sujet
	 * Retourne le sujet du voeu
	 * @return Sujets Sujet concerne
	 */
	public Sujets getSujet() {
		return this.sujet;
	}
	
	/**
	 * Setter Sujet
	 * Definit le sujet du voeu
	 * @param sujet
	 */
	public void setSujet(Sujets sujet) {
		this.sujet = sujet;
	}
	
	/**
	 * Getter Numero
	 * Retourne le numero du voeu
	 * @return
	 */
	public int getNumero() {
		return this.numero;
	}
	
	/**
	 * Setter Numero
	 * Definit le numero du voeu
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * Getter Vector
	 * Retourne le vecteur du Voeu
	 * 
	 * @return Vector<String> Vecteur du Voeu
	 */
	public Vector<String> getVec(){
		Vector<String> v = new Vector<String>();
		v.add(this.getGroupe().getIdGroupe());
		v.add(this.getSujet().getId());
		v.add(""+this.getNumero());
		return v;
	}
	
}
