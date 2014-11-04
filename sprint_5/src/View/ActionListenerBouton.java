package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionListenerBouton implements ActionListener {
	
	/*private int integer;
	private ArrayList<Projets> projets;
	
	public ActionListenerBouton(int i, ArrayList<Projets> projets){
		integer = i;
		this.projets = projets;
	}*/
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		/*JFrame jFP = new JFrame(projets.get(integer).getSujet()
				.get(1).getNom()+" : "+projets.get(integer).getSujet()
				.get(1).getTitre());
		
		// Création des onglets
		JTabbedPane tabPane = new JTabbedPane();
		JPanel JP1 = new JPanel(new GridLayout(projets.get(integer).getEtudiants().size(), 4));
		
		
		for (int i = 0; i < projets.get(integer).getEtudiants().size(); i++) {
			
			JP1.add(new JTextField(projets.get(integer).getEtudiants().get(i).getGroupe()));
			JP1.add(new JTextField(projets.get(integer).getEtudiants().get(i).getPrenom()));
			JP1.add(new JTextField(projets.get(integer).getEtudiants().get(i).getNom()));
			
			
		}
		
		
		JPanel JP2 = new JPanel(new GridLayout(projets.get(integer).getSujet().size(), 4));
		
		

			
			JP2.add(new JTextField(projets.get(integer).getSujet().getId()));
			JP2.add(new JTextField(projets.get(integer).getSujet().getNom()));
			JP2.add(new JTextField(projets.get(integer).getSujet().getTitre()));
			
		
		JPanel JP3 = new JPanel(new GridLayout(projets.get(integer).getIntervenant().size(), 3));
		
		
		for (int i = 0; i < projets.get(integer).getIntervenant().size(); i++) {
			
			JP3.add(new JTextField(projets.get(integer).getIntervenant().get(i).getNom()));
			JP3.add(new JTextField(projets.get(integer).getIntervenant().get(i).getPrenom()));

			
		}
		
		tabPane.addTab("Sujet",
				new JScrollPane(JP2));
		tabPane.addTab("Etudiant",
				new JScrollPane(JP1));
		tabPane.addTab("Intervenant",
				new JScrollPane(JP3));
		
		jFP.add(tabPane);
		jFP.setVisible(true);
		jFP.pack();*/
		
	}

}
