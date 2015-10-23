package command;
import java.util.Scanner;

import dto.Client;
import metier.ServiceClient;
import metier.ServiceCompte;

public class RechercheparPrenomCommand extends IhmCommand{
	public Integer getId() {
		return 8;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "JPA Recherche un client par son prenom";
	}
	
	public void excecute(ServiceCompte servicecompte,ServiceClient serviceclient){
		
		Scanner sc8 = new Scanner(System.in);
		
		System.out.println("Veuillez saisir le prenom du client a chercher:");
		String prenom=sc8.nextLine();

		Client client=serviceclient.retrouverclientparPrenomJPA(prenom);
		System.out.println(client);
		
	}

}
