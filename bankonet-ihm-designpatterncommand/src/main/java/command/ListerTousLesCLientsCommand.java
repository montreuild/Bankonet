package command;
import metier.ServiceClient;
import metier.ServiceCompte;

public class ListerTousLesCLientsCommand extends IhmCommand{

	public Integer getId() {
		return 2;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Lister tous les clients";
	}
	
	public void excecute(ServiceCompte servicecompte, ServiceClient serviceclient){

		//Lister les clients
		System.out.println(serviceclient.listerlesclients());
		
		//Lister les comptes
		System.out.println(servicecompte.listerlescomptes());
		
	}
}
