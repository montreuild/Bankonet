package bankonet.dao;

public class FactoryDaoSql implements FactoryDao{

	@Override
	public CompteDao getCompteDao() {
		return new CompteDaoSql();
	}

	@Override
	public ClientDao getClientDao() {
		return new ClientDaoSql();
	}

}
