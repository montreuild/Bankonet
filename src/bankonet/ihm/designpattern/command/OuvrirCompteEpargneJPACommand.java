package bankonet.ihm.designpattern.command;

import java.util.Scanner;

import bankonet.dto.Client;
import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

public class OuvrirCompteEpargneJPACommand extends IhmCommand {

	public Integer getId() {
		return 14;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "JPA Ouvrir un compte epargne";
	}
	
	public void excecute(ServiceCompte servicecompte, ServiceClient serviceclient){

		Scanner sc14 = new Scanner(System.in);
		System.out.println(serviceclient.listerlesclientsJPA());
		
		System.out.println("Veuillez saisir le login du client:");
		String loginclient = sc14.nextLine();
		
		Client clientseclectionner=serviceclient.retrounerclientloginJPA(loginclient);
		
		servicecompte.CreerCompteEpargneJPA(clientseclectionner);
		
	}
	
}
