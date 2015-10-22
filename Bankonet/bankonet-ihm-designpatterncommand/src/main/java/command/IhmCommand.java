package command;
import metier.ServiceClient;
import metier.ServiceCompte;

public abstract class IhmCommand {

	public Integer getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getLibelleMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void excecute(ServiceCompte servicecompte, ServiceClient serviceclient){
		// TODO Auto-generated method stub
	}
}
