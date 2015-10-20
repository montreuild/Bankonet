package bankonet.designpattern.command;

import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

public class ExitCommand extends IhmCommand{

	public int getId() {
		return 0;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Quitter l'application";
	}
	
	public void excecuteexcecute(ServiceCompte servicecompte, ServiceClient serviceclient){
		System.out.println("Bye Bye! Fermeture de l'application");
	}
}
