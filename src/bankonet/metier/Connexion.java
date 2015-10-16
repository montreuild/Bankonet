package bankonet.metier;

import java.util.HashMap;
import java.util.Map;

import bankonet.dao.ClientDao;
import bankonet.dto.Client;
import bankonet.stockage.Stockage;

public class Connexion {

	public boolean connexion(string login,string mdp){
		
		//TODO ClientDao a initialiser
		
		
		
		Map<String,Client> clientsliste= new HashMap<>();
		clientsliste=ClientDao.lireclientdansfichier();
		Client sessionclient=clientsliste.get(login);
		
		if(sessionclient!= null)
				if(sessionclient.getMdp().equals(mdp)){
					return true;
			}else{
				System.out.println("Erreur, try again!! \n");
			}
		else{	
			System.out.println("login erroné");
			return false;
			}
		
		
		return false;
		
	}
}
