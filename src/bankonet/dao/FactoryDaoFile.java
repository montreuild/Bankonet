package bankonet.dao;

public class FactoryDaoFile implements FactoryDao {

	@Override
	public CompteDao GetCompteDao() {
		return new CompteDaoFile();
	}

	@Override
	public ClientDao GetClientDao() {
		return new ClientDaoFile();
	}

}
