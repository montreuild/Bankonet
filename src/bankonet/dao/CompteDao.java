package bankonet.dao;

import java.util.Map;

import bankonet.dto.Client;
import bankonet.dto.Compte;



public interface CompteDao {


	void saveCompte(String clientlogin, Compte compte);
	void saveCompte(Client client);
	public Map<String,Compte> lirecomptedansfichier();

}
