package command;
import java.util.Scanner;

import dto.Client;
import metier.ServiceClient;
import metier.ServiceCompte;


public class OuvrirCompteCourantJPACommand extends IhmCommand {

	public Integer getId() {
		return 13;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "JPA Ouvrir un compte courant";
	}
	
	public void excecute(ServiceCompte servicecompte, ServiceClient serviceclient){

		Scanner sc13 = new Scanner(System.in);
		System.out.println(serviceclient.listerlesclientsJPA());
		
		System.out.println("Veuillez saisir le login du client:");
		String loginclient = sc13.nextLine();
		
		Client clientseclectionner=serviceclient.retrounerclientloginJPA(loginclient);
		
		servicecompte.CreerCompteCourantJPA(clientseclectionner);
		
	}
	
}
