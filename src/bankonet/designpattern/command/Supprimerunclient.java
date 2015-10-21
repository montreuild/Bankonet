package bankonet.designpattern.command;

import java.util.Scanner;

import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

public class Supprimerunclient extends IhmCommand {
	public Integer getId() {
		return 10;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Supprimer un client";
	}
	
	public void excecute(ServiceCompte servicecompte,ServiceClient serviceclient){
		
		Scanner sc10 = new Scanner(System.in);
		
		System.out.println("Veuillez saisir le login du client a supprimer:");
		String login=sc10.nextLine();
		
		System.out.println("Voulez vous vraiment supprimer le client? y/n");
		String verif=sc10.nextLine();
		
		if(verif.equals("y"))
		{
			serviceclient.supprimerunclientJPA(login);
		}
	}
}
