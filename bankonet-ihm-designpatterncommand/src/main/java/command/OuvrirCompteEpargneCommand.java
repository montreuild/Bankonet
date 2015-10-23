package command;
import java.util.Scanner;

import dto.Client;
import metier.ServiceClient;
import metier.ServiceCompte;


public class OuvrirCompteEpargneCommand extends IhmCommand {

	public Integer getId() {
		return 4;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Ouvrir un compte epargne";
	}
	
	public void excecute(ServiceCompte servicecompte, ServiceClient serviceclient){

		Scanner sc3 = new Scanner(System.in);
		System.out.println(serviceclient.listerlesclients());
		
		System.out.println("Veuillez saisir le login du client:");
		String loginclient = sc3.nextLine();
		
		Client clientseclectionner=serviceclient.retrounerclientlogin(loginclient);
		
		servicecompte.CreerCompteEpargne(clientseclectionner);
		
	}
	
}
