package bankonet.ihm.designpattern.command;

import java.util.Scanner;

import bankonet.dto.Client;
import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

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
