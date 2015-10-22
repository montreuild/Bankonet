package command;
import java.util.Scanner;

import dto.Client;
import metier.ServiceClient;
import metier.ServiceCompte;



public class OuvrirUnCompteCommand extends IhmCommand{
	
	public Integer getId() {
		return 1;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Ouvrir un compte client";
	}
	
	public void excecute(ServiceCompte servicecompte, ServiceClient serviceclient){
		String nom;
		String prenom;
		String login;
		
		Scanner sc1 = new Scanner(System.in);
		
			System.out.println("Veuillez saisir un nom:");
			nom=sc1.nextLine();
			
			System.out.println("Veuillez saisir un prenom:");
			prenom=sc1.nextLine();
			
			System.out.println("Veuillez saisir un login:");
			login=sc1.nextLine();
			
		Client client=serviceclient.creerclient(nom, prenom, login);
	}

}
