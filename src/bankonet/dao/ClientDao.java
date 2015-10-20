package bankonet.dao;

import java.util.Map;

import bankonet.dto.Client;


public interface ClientDao {
	
	public void saveClient (Client client);

	public Map<String,Client> lireclientdansfichier();

}	