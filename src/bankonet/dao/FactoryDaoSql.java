package bankonet.dao;

public class FactoryDaoSql implements FactoryDao{

	@Override
	public CompteDao GetCompteDao() {
		return new CompteDaoSql();
	}

	@Override
	public ClientDao GetClientDao() {
		return new ClientDaoSql();
	}

}
