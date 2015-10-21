package bankonet.designpattern.command;

import java.util.Scanner;

import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

public class ModifierunclientCommmand extends IhmCommand {

	public Integer getId() {
		return 9;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Modifier un client";
	}
	
	public void excecute(ServiceCompte servicecompte,ServiceClient serviceclient){
		
		Scanner sc9 = new Scanner(System.in);
		
		System.out.println("Veuillez saisir le login du client a modifier:");
		String login=sc9.nextLine();
		
		System.out.println("Veuillez saisir le nouveau nom du client a modifier:");
		String nom=sc9.nextLine();
		
		serviceclient.modifierunclientJPA(nom, login);
		
	}

}
