package bankonet.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import bankonet.dto.Client;


public interface ClientDao {
	
	public void saveClient (Client client);

	public Map<String,Client> lireclientdansfichier();
	
	public Client findByLastnameJPA(String search);

	public Client findByFirstnameJPA(String search);
	
	public void modifiernomclientJPA(String nom, String login);
	
	public void supprimerunclientJPA(String login);
	
	public void supprimertouslesclientsJPA();
}	