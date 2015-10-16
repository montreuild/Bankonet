package bankonet.dao;

public interface FactoryDao {
	
	public CompteDao GetCompteDao();
	public ClientDao GetClientDao();

}
