package bankonet.designpattern.command;

import java.util.Scanner;

import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

public class Supprimertouslesclient extends IhmCommand{
	public Integer getId() {
		return 11;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "Supprimer tous client";
	}
	
	public void excecute(ServiceCompte servicecompte,ServiceClient serviceclient){
		
		Scanner sc11 = new Scanner(System.in);
		
		System.out.println("Voulez vous vraiment supprimer tous les clients? y/n");
		String verif=sc11.nextLine();
		
		if(verif.equals("y"))
		{
			serviceclient.supprimertouslesclientJPA();
		}else
		{
			System.out.println("Suppression annulée.");
		}
		
		
	}
}
