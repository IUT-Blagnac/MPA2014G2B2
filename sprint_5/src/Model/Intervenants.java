package Model;

import java.util.Vector;

public class Intervenants {
	private int id;
	private String nom;
	private String prenom;
	
	/**
	 * Constructeur par defaut
	 * Permet de construire un objet Intervenants
	 * Intialise nom et prenom
	 */
	public Intervenants(){
		new Intervenants(-1,"","");
	}
	
	/**
	 * Constructeur parametre
	 * Permet de construire un objet Intervenants
	 * Initialise nom et prenom avec les valeurs passees en parametres
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Intervenants(int id, String nom, String prenom){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * Getter Nom
	 * Retourne le nom de l'Intervenant
	 * 
	 * @return String Nom de l'Intervenant
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Setter Nom
	 * Definit le nom de l'Intervenant
	 * 
	 * @param nom 
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getter Prenom
	 * Retourne le prenom de l'Intervenant
	 * 
	 * @return String Prenom de l'Intervenant
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Setter Prenom
	 * Definit le prenom de l'Intervenant
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Getter Vector
	 * Retourne le vecteur de l'Intervenant
	 * 
	 * @return Vector<String> Vecteur de l'Intervenant
	 */
	public Vector<String> getVec(){
		Vector<String> v = new Vector<String>();
		v.add(""+this.getId());
		v.add(this.getNom());
		v.add(this.getPrenom());
		return v;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
