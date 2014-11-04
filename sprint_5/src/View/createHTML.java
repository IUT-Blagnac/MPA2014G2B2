package View;

import Controler.Controller;

public class createHTML {

	public createHTML(){
	// Initialisation de la fenetre du programme
		Controller controller = new Controller();
		OPTIlib.findFiles("data", controller);
		HTMLlib.htmlGeneratePage(controller);
	}
	public static void main(String[] args) {

		@SuppressWarnings("unused")
		createHTML inter = new createHTML();

	}
}