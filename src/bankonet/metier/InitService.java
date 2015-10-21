package bankonet.metier;

import bankonet.dao.ClientDao;
import bankonet.dao.FactoryDao;
import bankonet.dao.FactoryDaoJpa;
import bankonet.dto.Civilite;
import bankonet.dto.Client;

public class InitService {
	
	private ClientDao clientdao;
	
	public InitService() {
		FactoryDao factory =new FactoryDaoJpa();
		this.clientdao = factory.getClientDao();
	}
	
	public void init(){
		
		Client c1=new Client("Montreuil","Damien","md",Civilite.MONSIEUR,"md","0000");
		Client c2=new Client("DePontfacy","Simon","ds",Civilite.MONSIEUR,"ds","0000");
		Client c3=new Client("Hayet","Marc","hm",Civilite.MONSIEUR,"hm","0000");
		Client c4=new Client("Landra","Vincent","lv",Civilite.MONSIEUR,"lv","0000");
		
		clientdao.saveClient(c1);
		clientdao.saveClient(c2);
		clientdao.saveClient(c3);
		clientdao.saveClient(c4);
		

		
	}

}
