package Model;
import java.util.Vector;


public class Groupes {
	private String idGroupe;
	private Vector<Etudiants> etudiants;
	private Projets projet;
	
	/**
	 * Constructeur par defaut
	 * Permet de construire un objet Groupes
	 * Initialise idGroupe et le Vector d'Etudiants
	 */
	public Groupes(){
		new Groupes("", null, null);
	}
	
	/**
	 * Constructeur parametre
	 * Permet de construire un objet Groupes
	 * Initialise idGroupe et etudiants avec les valeurs passees en parametres
	 * 
	 * @param idGroupe
	 * @param vector
	 */
	public Groupes(String idGroupe, Vector<Etudiants> vector, Projets projet){
		this.idGroupe = idGroupe;
		this.etudiants = vector;
		this.projet = projet;
	}
	
	/**
	 * Getter Id
	 * Retourne l'identifiant du groupe
	 * 
	 * @return String Id du groupe
	 */
	public String getIdGroupe() {
		return this.idGroupe;
	}
	
	/**
	 * Setter Id
	 * Definit l'identifiant du groupe
	 * 
	 * @param idGroupe
	 */
	public void setIdGroupe(String idGroupe) {
		this.idGroupe = idGroupe;
	}
	
	/**
	 * Getter Etudiants
	 * Retourne le Vector d'Etudiants presents dans le groupe
	 * 
	 * @return Vector<Etudiants> Vector d'Etudiants
	 */
	public Vector<Etudiants> getEtudiants() {
		return this.etudiants;
	}
	
	/**
	 * Setter Etudiants
	 * Definit le Vector d'Etudiants presents dans le groupe
	 * 
	 * @param etudiants
	 */
	public void setEtudiants(Vector<Etudiants> etudiants) {
		this.etudiants = etudiants;
	}
	
	/**
	 * Getter Vector
	 * Retourne le vecteur du Groupe
	 * 
	 * @return Vector<Vector<String>> Vecteur du groupe
	 */
	public Vector<Vector<String>> getVec() {
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		for(int i = 0; i<etudiants.size(); i++){
			Vector<String> ve = this.getEtudiants().get(i).getVec();
			ve.set(1,idGroupe);
			v.add(ve);
		}
		return v;
	}

	public Projets getProjet() {
		return projet;
	}

	public void setProjet(Projets projet) {
		this.projet = projet;
	}
}
