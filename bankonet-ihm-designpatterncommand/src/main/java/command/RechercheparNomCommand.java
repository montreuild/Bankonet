package command;
import java.util.Scanner;

import dto.Client;
import metier.ServiceClient;
import metier.ServiceCompte;

public class RechercheparNomCommand extends IhmCommand{
	public Integer getId() {
		return 7;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "JPA Recherche un client par son nom";
	}
	
	public void excecute(ServiceCompte servicecompte,ServiceClient serviceclient){
		
		Scanner sc7 = new Scanner(System.in);
		
		System.out.println("Veuillez saisir le nom du client a chercher:");
		String nom=sc7.nextLine();

		Client client=serviceclient.retrouverclientparNomJPA(nom);
		System.out.println(client);
		
	}

}
