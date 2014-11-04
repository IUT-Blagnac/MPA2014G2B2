package View;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.Etudiants;
import Model.Sujets;
import Controler.Controller;


public class HTMLlib {
	
	
	private static String htmlGeneratePage_accueil(Controller ctrl) {
		String codeHTML = "";
		codeHTML += "<div data-role=\"page\" id=\"accueil\" data-title=\"OPTIweb - V0.1\">\n";
		codeHTML += "<div data-role=\"header\" data-add-back-btn=\"true\">\n";
		codeHTML += "<h1>P<span class=\"landscape\">rojets </span>tut<span class=\"landscape\">orés</span> 2014-2015<br/>Département INFO<span class=\"landscape\">RMATIQUE</span><br/>IUT de Blagnac</h1>\n";
		codeHTML += "<a href=\"#credits\" data-theme=\"b\" class=\"ui-btn-right\">Crédits</a>\n";
		codeHTML += "</div>\n";
		codeHTML += "<div data-role=\"content\">\n";
		codeHTML += "<ul data-role=\"listview\" data-inset=\"true\" id=\"listeSources\">\n";
		codeHTML += "  <li><a href=\"#projets\"><i class=\"fa fa-tasks\"></i> Projets</a></li>\n";
		codeHTML += "  <li><a href=\"#sujets\"><i class=\"fa fa-copy\"></i> Sujets</a></li>\n";
		codeHTML += "  <li><a href=\"#etudiants\"><i class=\"fa fa-group\"></i> Etudiants</a></li>\n";
		codeHTML += "  <li><a href=\"#intervenants\"><i class=\"fa fa-group\"></i> Intervenants</a></li>\n";
		codeHTML += "</ul>\n";
		codeHTML += "</div>\n";
		codeHTML += "<div data-role=\"footer\"> \n";
		codeHTML += " <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa- fa-2x\"></i></h4> \n";
		codeHTML += "</div>\n";
		codeHTML += "</div>\n";
		return codeHTML;
	}
	
	private static String htmlGeneratePage_credits(Controller ctrl) {
		String codeHTML = "";
		codeHTML +="<div data-role=\"page\" id=\"credits\" data-title=\"OPTIweb - V0.1 - Crédits\">\n";
		codeHTML +="<div data-role=\"header\" data-add-back-btn=\"true\">\n";
		codeHTML +="<h1>Crédits</h1>\n";
		codeHTML +="</div>\n";
		codeHTML +="<div data-role=\"content\">\n";
		codeHTML +="    <p>Cette application a été réalisée dans le cadre du module M3301/MPA du DUT Informatique à l'IUT de Blagnac.</p>\n";
		codeHTML +="<ul data-role=\"listview\" data-inset=\"true\" id=\"contacts\" data-theme=\"a\" data-divider-theme=\"b\">\n";
		codeHTML +="    <li data-role=\"list-divider\">Product Owner</li>\n";
		codeHTML +="    <li>André PÉNINOU</li>\n";
		codeHTML +="    <li>Université Toulouse 2 - IUT de Blagnac\n";
		codeHTML +="    <br/>Département INFORMATIQUE</li>\n";
		codeHTML +="</ul>\n";
		codeHTML +="<ul data-role=\"listview\" data-inset=\"true\" id=\"listecredits\" data-theme=\"a\" data-divider-theme=\"b\">\n";
		codeHTML +="    <li data-role=\"list-divider\">Membres de l'équipe enseignante</li>\n";
		codeHTML +="<li>Jean-Michel BRUEL</li><li>Jean-Michel INGLEBERT</li><li>André PÉNINOU</li><li>Olivier ROQUES</li>\n";
		codeHTML +="</ul>\n";
		codeHTML +="<ul data-role=\"listview\" data-inset=\"true\" id=\"listepowered\" data-theme=\"a\" data-divider-theme=\"b\">\n";
		codeHTML +="    <li data-role=\"list-divider\">Propulsé par</li>\n";
		codeHTML +="   <li><a href=\"http://jquerymobile.com/\" target=\"autrePage\">http://jquerymobile.com/</a></li>\n";
		codeHTML +="    <li><a href=\"http://fortawesome.github.io/Font-Awesome/\" target=\"autrePage\">http://fortawesome.github.io/Font-Awesome/</a></li>\n";
		codeHTML +="</ul>\n";
		codeHTML +="</div>\n";
		codeHTML +="<div data-role=\"footer\"> \n";
		codeHTML +=" <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa- fa-2x\"></i></h4> \n";
		codeHTML +="</div>\n";
		codeHTML +="</div>\n";
		return codeHTML;
	}
	
	private static String htmlGeneratePage_sujets(Controller  ctrl) {
		String codeHTML="";
		codeHTML += "<div data-role=\"page\" id=\"sujets\" data-title=\"OPTIweb - V0.1\">\n";
		codeHTML += "	<div data-role=\"header\" data-add-back-btn=\"true\">\n";
		codeHTML += "		<h1>Sujets 2014-2015</h1>\n";
		codeHTML += "	</div>\n";
		codeHTML += "	<div data-role=\"content\">\n";
		codeHTML += "		<form class=\"ui-filterable\">\n";
		codeHTML += "			<input id=\"autocomplete-input-sujet\" name=\"sujet\" data-type=\"search\" placeholder=\"Vous cherchez ?\">\n";
		codeHTML += "		</form>\n";
		codeHTML += "		<ol id=\"listesujets\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-sujet\" data-divider-theme=\"b\" data-count-theme=\"a\">\n";
		codeHTML += "			<li data-role=\"list-divider\">\n";
		codeHTML += "				Sujet\n";
		codeHTML += "				<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">Groupe</span>\n";
		codeHTML += "			</li>\n";
		for(int i=0; i<ctrl.getSujets().size(); i++) {
			codeHTML += "<li data-find=\"["+ctrl.getSujets().get(i).getNom()+"]\">\n";
			codeHTML += "	<a href=\"#projets\">["+ctrl.getSujets().get(i).getNom()+"] <br/>\n";
			codeHTML += "		<div style=\"white-space:normal;\">\n";
			codeHTML += "			<span>\n";
			codeHTML += "				<b>"+ctrl.getSujets().get(i).getTitre()+"</b>\n";
			codeHTML += "			</span>\n";
			codeHTML += "			<span class=\"ui-li-count\">";
			int nbrGr = 0;
			for(int j=0; j<ctrl.getProjets().size(); j++) {
				if(ctrl.getProjets().get(j).getSujet() == ctrl.getSujets().get(i)) {
					if(nbrGr>0) { codeHTML += " "; }
					codeHTML += ctrl.getProjets().get(j).getGroupe().getIdGroupe();
					nbrGr++;
				}
			}
			codeHTML += "			</span>\n";
			codeHTML += "		</div>\n";
			codeHTML += "	</a>\n";
			codeHTML += "</li>\n";
		}
		codeHTML += "		</ol>\n";
		codeHTML += "	</div>\n";
		codeHTML += "	<div data-role=\"footer\">\n";
		codeHTML += "		<h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-copy fa-2x\"></i></h4>\n";
		codeHTML += "	</div>\n";
		codeHTML += "</div>\n";
		return codeHTML;
	}
	
	private static String htmlGeneratePage_projets(Controller ctrl) {
		String projets="";
		projets += "<div data-role=\"page\" id=\"projets\" data-title=\"OPTIweb - V0.1\"><div data-role=\"header\" data-add-back-btn=\"true\"><h1>Projets 2014-2015</h1></div><div data-role=\"content\"><form class=\"ui-filterable\"><input id=\"autocomplete-input-projet\" name=\"projet\" data-type=\"search\" placeholder=\"Vous cherchez ?...\"></form><ol id=\"listeprojets\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-projet\"> \n";
		for(int i=0;i < ctrl.getProjets().size();i++)
		{
			projets += "<li><p><b>[" + ctrl.getProjets().get(i).getSujet().getNom() +"]</b> " + ctrl.getProjets().get(i).getSujet().getTitre() +" </p><p><b>Client : </b> " + ctrl.getProjets().get(i).getClient().getPrenom() + " " + ctrl.getProjets().get(i).getClient().getNom() + "</p><p><b>Superviseur : </b> " + ctrl.getProjets().get(i).getIntervenant().getPrenom() + " " + ctrl.getProjets().get(i).getIntervenant().getNom() +"</p><p><b>Groupe " + ctrl.getProjets().get(i).getGroupe().getIdGroupe() + " : </b>";
			for(int j =0 ;j< ctrl.getProjets().get(i).getGroupe().getEtudiants().size();j++)
			{
				projets += ctrl.getProjets().get(i).getGroupe().getEtudiants().get(j).getPrenom() + " " + ctrl.getProjets().get(i).getGroupe().getEtudiants().get(j).getNom() +" - ";
			}
			
			projets +=  "</p></li> \n";
		}
		
		projets += "</div><div data-role=\"footer\">  <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-tasks fa-2x\"></i></h4> </div></div>";
		
		return projets;
	}
	private static String htmlGeneratePage_etudiants(Controller ctrl) {
		ArrayList<Etudiants> list = new ArrayList<Etudiants>();
		for(int i = 0; i<ctrl.getEtudiants().size(); i++){
			list.add(ctrl.getEtudiants().get(i));
		}
		//Sorting
		Collections.sort(list, new Comparator<Etudiants>() {
				@Override
				public int compare(Etudiants arg0, Etudiants arg1) {
					// TODO Auto-generated method stub
					return  arg0.getNom().compareTo(arg1.getNom());
				}
		    });
		String codeHTML = "";
		codeHTML += "<div data-role=\"page\" id=\"etudiants\" data-title=\"OPTIweb - V0.1\">\n";
		codeHTML += "	<div data-role=\"header\" data-add-back-btn=\"true\">\n";
		codeHTML +=  "		<h1>Etudiants 2014-2015</h1>\n";
		codeHTML += "	</div>\n";
		codeHTML += "	<div data-role=\"content\">\n";
		codeHTML += " 		<form class=\"ui-filterable\">\n";
		codeHTML += "			<input id=\"autocomplete-input-etudiant\" name=\"etudiant\" data-type=\"search\" placeholder=\"Etudiant ou Groupe X\">\n";
		codeHTML += "		</form>\n";
		codeHTML += "		<ol id=\"listeetudiants\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-etudiant\" data-divider-theme=\"b\">\n";
		codeHTML += "			<li data-role=\"list-divider\">\n";
		codeHTML += "				Etudiant\n";
		codeHTML += "				<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">\n";
		codeHTML += "					Groupe\n";
		codeHTML += "				</span>\n";
		codeHTML += "			</li>\n";

		for (int i = 0; i < list.size(); i++){
			codeHTML +="			<li data-find=\""+list.get(i).getPrenom()+" "+list.get(i).getNom()+"\"><a href=\"#projets\">"+list.get(i).getNom()+" "+list.get(i).getPrenom()+"<span class=\"ui-li-count\" title=\"Groupe\">Groupe "+list.get(i).getGroupe().getIdGroupe()+"</span></a></li>\n";
		}
		
		codeHTML += "		</ol>\n";
		codeHTML += "	</div>\n";
		codeHTML += "	<div data-role=\"footer\"> \n";
		codeHTML += "		<h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-group fa-2x\"></i></h4>\n";
		codeHTML += "	</div>\n";
		codeHTML += "</div>\n";
		
		return codeHTML;
	}
	
	
	private static String htmlGeneratePage_intervenants(Controller ctrl) {
		int nbClient = 0;
		int nbSuperviseur = 0;
		
		String codeHTML = "";
		codeHTML += "\n<div data-role=\"page\" id=\"intervenants\" data-title=\"OPTIweb - V0.1\">\n";
		codeHTML += "<div data-role=\"header\" data-add-back-btn=\"true\">\n";
		codeHTML += "<h1>Intervenants 2014-2015</h1>\n";
		codeHTML += "</div>\n";
		codeHTML += "<div data-role=\"content\">\n";
		codeHTML += "<form class=\"ui-filterable\">\n";
		codeHTML += "<input id=\"autocomplete-input-intervenant\" name=\"intervenant\" data-type=\"search\" placeholder=\"Intervenant\">\n";
		codeHTML += "</form>\n";
		codeHTML += "<ul id=\"listeintervenants\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-intervenant\" data-divider-theme=\"b\">\n";
		codeHTML += "<li data-role=\"list-divider\">\n";
		codeHTML += "Intervenant\n";
		codeHTML += "<span class=\"ui-li-count\" style=\"right: 110px !important;\" title=\"Client\">Client</span>\n";
		codeHTML += "<span class=\"ui-li-count\" title=\"Superviseur\">Superviseur</span>\n";
		codeHTML += "</li>\n";
		
		for (int indice = 0; indice < ctrl.getIntervenants().size(); indice++)
		{
			nbClient = 0;
			nbSuperviseur = 0;
			
			for (int cmpt = 0; cmpt < ctrl.getProjets().size(); cmpt++)
			{
				if (ctrl.getProjets().get(cmpt).getClient().getId() == ctrl.getIntervenants().get(indice).getId())
				{
					nbClient ++;
				}
				
				if (ctrl.getProjets().get(cmpt).getIntervenant().getId() == ctrl.getIntervenants().get(indice).getId())
				{
					nbSuperviseur ++;
				}
			}
			
			codeHTML += "<li data-find=\"" + ctrl.getIntervenants().get(indice).getPrenom() + " " + ctrl.getIntervenants().get(indice).getNom() + "\">\n";
			codeHTML += "<a href=\"#projets\">\n";
			codeHTML += ctrl.getIntervenants().get(indice).getPrenom() + " " + ctrl.getIntervenants().get(indice).getNom() + "\n";
			codeHTML += "<span class=\"ui-li-count\" style=\"right: 120px !important;\" title=\"Client\">" + nbClient + "</span>\n";
			codeHTML += "<span class=\"ui-li-count\" title=\"Superviseur\">" + nbSuperviseur + "</span>\n";
			codeHTML += "</a>\n";
			codeHTML += "</li>\n";
		}
		
		codeHTML += "</ul>\n";
		codeHTML += "</div>\n";
		codeHTML += "<div data-role=\"footer\">\n";
		codeHTML += "<h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-group fa-2x\"></i></h4>\n";
		codeHTML += "</div>\n";
		codeHTML += "</div>\n";
		
		return codeHTML;
	}
	
	
	public static void htmlGeneratePage(Controller ctrl) {
		String page = "";
		page += "<!DOCTYPE html>";
		page += "<html>";
		page += "	<head>";
		page += "		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />";
		page += "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">";
		page += "		<meta name=\"generator\" content=\"OPTIweb VOPTIweb\" />";
		page += "		<title>0.1 - V0.1</title>";
		page += "		<link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css\" />";
		page += "		<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css\" />";
		page += "		<script src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>";
		page += "		<script src=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js\"></script>";
		page += "		<style type='text/css'>";
		page += "			@media all and (orientation:portrait) { .landscape {display: none;} }";
		page += "			@media all and (orientation:landscape) { .landscape {display: inline;} }";
		page += "		</style>";
		page += "	</head>";
		page += "	<body>";
		page += "		<!-- DEBUT page accueil -->"+htmlGeneratePage_accueil(ctrl)+"<!-- FIN page accueil -->\n";
		page += "		<!-- DEBUT page credits -->"+htmlGeneratePage_credits(ctrl)+"<!-- FIN page credits -->\n";
		page += "		<!-- DEBUT page projets -->"+htmlGeneratePage_projets(ctrl)+"<!-- FIN page projets -->\n";
		page += "		<!-- DEBUT page sujets -->"+htmlGeneratePage_sujets(ctrl)+"<!-- FIN page sujets -->\n";
		page += "		<!-- DEBUT page etudiants -->"+htmlGeneratePage_etudiants(ctrl)+"<!-- FIN page etudiants -->\n";
		page += "		<!-- DEBUT page intervenants -->"+htmlGeneratePage_intervenants(ctrl)+"<!-- FIN page intervenants -->\n";
		page += "		<script>";
		page += "			$( 'li[data-find]' ).on( 'click',function(event){";
		page += "				$(\"#autocomplete-input-projet\").val($(this).attr('data-find')).trigger('change');";
		page += "			});";
		page += "		</script>";
		page +=	"	</body>";
		page += "</html>";
		
		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(
				    new FileOutputStream("OPTIweb/test/OPTIweb.html"), "UTF-8"));
			writer.write(page);
			 
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
