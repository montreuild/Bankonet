package command;
import metier.ServiceClient;
import metier.ServiceCompte;

public class ExitCommand extends IhmCommand{

	public Integer getId() {
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
