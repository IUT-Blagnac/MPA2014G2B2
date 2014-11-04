package Model;
import java.util.Vector;

public class Sujets {
	private String id;
	private String nom;
	private String titre;
	
	/**
	 * Constructeur par defaut
	 * Permet de construire un objet Sujets
	 * Initialise id, nom et titre
	 */
	public Sujets(){
		new Sujets("-1", "", "");
	}
	
	/**
	 * Constructeur parametre
	 * Permet de construire un objet Sujets
	 * Initialise id, nom et prenom avec les valeurs passees en parametres
	 * 
	 * @param id
	 * @param nom
	 * @param titre
	 */
	public Sujets(String id, String nom, String titre){
		this.setId(id);
		this.setNom(nom);
		this.setTitre(titre);
	}

	/**
	 * Getter Titre
	 * Retourne le titre du sujet
	 * 
	 * @return String Titre du sujet
	 */
	public String getTitre() {
		return this.titre;
	}
	
	/**
	 * Setter Titre
	 * Definit le titre du sujet
	 * 
	 * @param titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Getter Nom
	 * Retourne le nom du sujet
	 * 
	 * @return String Nom du sujet
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Setter Nom
	 * Definit le nom du sujet
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter Id
	 * Retourne l'identifiant du sujet
	 * 
	 * @return String Id du sujet
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Setter Id
	 * Definit l'identifiant du sujet
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Getter Vectot
	 * Retourne le vecteur du Sujet
	 * 
	 * @return Vector<String> Vecteur du sujet
	 */
	public Vector<String> getVec(){
		Vector<String> v = new Vector<String>();
		v.add(this.getId());
		v.add(this.getNom());
		v.add(this.getTitre());
		return v;
	}
	
}
