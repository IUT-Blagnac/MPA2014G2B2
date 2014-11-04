package Model;
import java.util.Vector;

public class Projets {
	
	private int id;
	private Groupes groupe;
	private Intervenants intervenant;
	private Intervenants client;
	private Intervenants support;
	private Sujets sujet;
	
	/**
	 * Constructeur par defaut
	 * Permet de construire un objet Projets
	 * Initialise groupe, intervenants et sujet
	 */
	public Projets(){
		new Projets(-1,null,null,null,null,null);
	}
	
	/**
	 * Constructeur parametre
	 * Permet de construire un objet Projets
	 * Initialise groupe, intervenants et sujet avec les valeurs passees en parametres
	 * 
	 * @param sujet
	 * @param groupe
	 * @param vector
	 */
	public Projets(int id, Groupes groupe, Sujets sujet, Intervenants client, Intervenants inter, Intervenants support){
		this.setSujet(sujet);
		this.setGroupe(groupe);
		this.setIntervenant(inter);
		this.setClient(client);
		this.setSupport(support);
		this.setId(id);
	}

	/**
	 * Getter Intervenant
	 * Retourne le nom de l'Intervenant responsable du Projet
	 * @return Vector<Intervenants> Intervenant
	 */
	public Intervenants getIntervenant() {
		return this.intervenant;
	}
	
	/**
	 * Setter Intervenant
	 * Definit le nom de l'Intervenant responsable du Projet
	 * 
	 * @param vector
	 */
	public void setIntervenant(Intervenants inter) {
		this.intervenant = inter;
	}

	/**
	 * Getter Sujet
	 * Retourne le sujet du Projet
	 * 
	 * @return Sujets
	 */
	public Sujets getSujet() {
		return this.sujet;
	}

	/**
	 * Setter Sujet
	 * Definit le sujet du Projet
	 * 
	 * @param sujet2
	 */
	public void setSujet(Sujets sujet2) {
		this.sujet = sujet2;
	}

	/**
	 * Getter Groupe
	 * Retourne le Groupe du Projet
	 * 
	 * @return Groupes
	 */
	public Groupes getGroupe() {
		return groupe;
	}

	/**
	 * Setter Groupe
	 * Definit le Groupe du Projet
	 * 
	 * @param groupe
	 */
	public void setGroupe(Groupes groupe) {
		this.groupe = groupe;
	}
	
	/**
	 * Getter Vector
	 * Retourne le vecteur du Projet
	 * 
	 * @return Vector<String> Vecteur du Projet
	 */
	public Vector<String> getVec(){
		Vector<String> v = new Vector<String>();
		v.add(""+this.id);
		v.add(this.getGroupe().getIdGroupe());
		v.add(this.getSujet().getId());
		v.add(""+this.getClient().getId());
		v.add(""+this.getIntervenant().getId());
		v.add(""+this.getSupport().getId());
		return v;
	}

	public Intervenants getClient() {
		return client;
	}

	public void setClient(Intervenants client) {
		this.client = client;
	}

	public Intervenants getSupport() {
		return support;
	}

	public void setSupport(Intervenants support) {
		this.support = support;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
