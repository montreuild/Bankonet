package bankonet.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import bankonet.dto.Client;

public class ClientDaoJpa implements ClientDao{

	EntityManagerFactory emf;
	
	public ClientDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void saveClient(Client client) {

		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.persist(client);

		et.commit();
		em.close();
		
	}

	@Override
	public Map<String, Client> lireclientdansfichier() {
		// TODO Auto-generated method stub
		return null;
	}

}
