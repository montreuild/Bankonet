package bankonet.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryDaoJpa implements FactoryDao{

	@Override
	public CompteDao getCompteDao() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Bankonet");
		return new CompteDaoJpa(emf);
	}

	@Override
	public ClientDao getClientDao() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Bankonet");
		return new ClientDaoJpa(emf);
	}

}
