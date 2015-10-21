package bankonet.dao;

import java.util.Map;

import javax.persistence.EntityManagerFactory;

import bankonet.dto.Client;
import bankonet.dto.Compte;

public class CompteDaoJpa implements CompteDao{

	EntityManagerFactory emf;
	
	public CompteDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	@Override
	public void saveCompte(String clientlogin, Compte compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveCompte(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Compte> lirecomptedansfichier() {
		// TODO Auto-generated method stub
		return null;
	}

}
