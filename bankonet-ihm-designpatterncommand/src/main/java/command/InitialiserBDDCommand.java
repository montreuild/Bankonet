package command;
import metier.InitService;
import metier.ServiceClient;
import metier.ServiceCompte;

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
