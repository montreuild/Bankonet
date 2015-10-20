package bankonet.dao;

public interface FactoryDao {
	
	 CompteDao getCompteDao();
	 ClientDao getClientDao();

}
