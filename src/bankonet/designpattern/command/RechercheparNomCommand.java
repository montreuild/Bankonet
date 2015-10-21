package bankonet.designpattern.command;

import java.util.Scanner;

import bankonet.dto.Client;
import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

public class RechercheparNomCommand extends IhmCommand{
	public Integer getId() {
		return 7;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Recherche un client par son nom";
	}
	
	public void excecute(ServiceCompte servicecompte,ServiceClient serviceclient){
		
		Scanner sc7 = new Scanner(System.in);
		
		System.out.println("Veuillez saisir le nom du client a chercher:");
		String nom=sc7.nextLine();

		Client client=serviceclient.retrouverclientparNomJPA(nom);
		System.out.println(client);
		
	}

}
