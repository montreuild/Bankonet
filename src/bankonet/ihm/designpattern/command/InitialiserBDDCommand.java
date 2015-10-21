package bankonet.ihm.designpattern.command;

import bankonet.metier.InitService;
import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceCompte;

public class InitialiserBDDCommand extends IhmCommand{
	public Integer getId() {
		return 6;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return "JPA Initialiser la BDD";
	}
	
	public void excecute(ServiceCompte servicecompte,ServiceClient serviceclient){

		InitService initservice= new InitService();
		initservice.init();
	}

}
