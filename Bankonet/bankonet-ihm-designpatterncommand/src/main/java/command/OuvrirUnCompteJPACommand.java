package command;
import java.util.Scanner;

import dto.Client;
import metier.ServiceClient;
import metier.ServiceCompte;



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
