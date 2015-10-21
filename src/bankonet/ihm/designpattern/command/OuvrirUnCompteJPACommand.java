package bankonet.ihm.designpattern.command;

import java.util.Scanner;

import bankonet.dto.Client;
import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

public class OuvrirUnCompteJPACommand extends IhmCommand{
	
	public Integer getId() {
		return 12;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "JPA Ouvrir un compte client";
	}
	
	public void excecute(ServiceCompte servicecompte, ServiceClient serviceclient){
		String nom;
		String prenom;
		String login;
		
		Scanner sc12 = new Scanner(System.in);
		
			System.out.println("Veuillez saisir un nom:");
			nom=sc12.nextLine();
			
			System.out.println("Veuillez saisir un prenom:");
			prenom=sc12.nextLine();
			
			System.out.println("Veuillez saisir un login:");
			login=sc12.nextLine();
			
		Client client=serviceclient.creerclientJPA(nom, prenom, login);
	}

}
