package View;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class AfficherCsv extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */

	public AfficherCsv(ArrayList<String[]> tab) {

		super(new GridLayout(tab.size(), tab.get(0).length));
		for (int i = 0; i < tab.size(); i++) {
			for (int u = 0; u < tab.get(i).length; u++) {
				this.add(new JTextField(tab.get(i)[u]));
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
