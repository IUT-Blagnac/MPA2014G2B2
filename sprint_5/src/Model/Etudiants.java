package Model;
import java.util.Vector;

public class Etudiants {
	private int id;
	private String nom;
	private String prenom;
	private Groupes groupe;
	
	/**
	 * Constructeur par defaut
	 * Permet de construire un objet Etudiants
	 * Initialise nom et prenom
	 */
	public Etudiants(){
		new Etudiants(-1,"","",null);
	}
	
	/**
	 * Constructeur parametre
	 * Permet de construire un objet Etudiants
	 * Initialise nom et prenom avec les valeurs passees en parametres
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Etudiants(int id, String nom, String prenom, Groupes groupe){
		this.nom = nom;
		this.prenom = prenom;
		this.setGroupe(groupe);
		this.id = id;
	}
	
	/**
	 * Getter Nom
	 * Retourne le nom de l'Etudiant
	 * 
	 * @return String Nom de l'Etudiant
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Setter Nom
	 * Definit le nom de l'Etudiant
	 * 
	 * @param nom 
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getter Prenom
	 * Retourne le prenom de l'Etudiant
	 * 
	 * @return String Prenom de l'Etudiant
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Setter Prenom
	 * Definit le prenom de l'Etudiant
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Getter Vector
	 * Retourne le vecteur de l'Etudiant
	 * 
	 * @return Vector<String> Vecteur de l'Etudiant
	 */
	public Vector<String> getVec(){
		Vector<String> v = new Vector<String>();
		v.add(""+this.id);
		v.add(""); // Groupe de l'etudiant
		v.add(this.getNom());
		v.add(this.getPrenom());
		return v;
	}

	public Groupes getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupes groupe) {
		this.groupe = groupe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
