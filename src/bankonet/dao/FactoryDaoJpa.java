package bankonet.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryDaoJpa implements FactoryDao{

	@Override
	public CompteDao getCompteDao() {
		return null;
		//return new CompteDaoJpa();
	}

	@Override
	public ClientDao getClientDao() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Bankonet");
		return new ClientDaoJpa(emf);
	}

}
