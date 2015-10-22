package dao;

public class FactoryDaoFile implements FactoryDao {

	@Override
	public CompteDao getCompteDao() {
		return new CompteDaoFile();
	}

	@Override
	public ClientDao getClientDao() {
		return new ClientDaoFile();
	}

}
