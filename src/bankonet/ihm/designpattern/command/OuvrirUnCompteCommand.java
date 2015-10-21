package bankonet.ihm.designpattern.command;

import java.util.Scanner;

import bankonet.dto.Client;
import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

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
