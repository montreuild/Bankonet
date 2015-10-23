package command;
import java.util.Scanner;

import dto.Client;
import metier.ServiceClient;
import metier.ServiceCompte;


public class OuvrirCompteCourantCommand extends IhmCommand {

	public Integer getId() {
		return 3;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Ouvrir un compte courant";
	}
	
	public void excecute(ServiceCompte servicecompte, ServiceClient serviceclient){

		Scanner sc2 = new Scanner(System.in);
		System.out.println(serviceclient.listerlesclients());
		
		System.out.println("Veuillez saisir le login du client:");
		String loginclient = sc2.nextLine();
		
		Client clientseclectionner=serviceclient.retrounerclientlogin(loginclient);
		
		servicecompte.CreerCompteCourant(clientseclectionner);
		
	}
	
}
