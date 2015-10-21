package bankonet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import bankonet.dto.Client;
import bankonet.dto.Compte;
import bankonet.dto.CompteCourant;
import bankonet.dto.CompteEpargne;

public class CompteDaoJpa implements CompteDao{

	EntityManagerFactory emf;
	
	public CompteDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	public void saveCompte(String loginclient,Compte compte) {

	}

	@Override
	public void saveCompte(Client client) {

	}

	@Override
	public Map<String, Compte> lirecomptedansfichier() {
		
		Map<String,Compte> comptesmap= new HashMap<>();
		comptesmap=null;
		
		return comptesmap;
	}

	
	public void saveCompteJPA(Client client,Compte compte) {

		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		compte.setClientlogin(client);
		em.persist(compte);

		et.commit();
		em.close();

	}
	
	public void saveCompteJPA(Client client) {

		Map<String,Compte> compteliste= new HashMap<>();
		compteliste=client.getComptesMap();

		for (String mapKey : compteliste.keySet()) {
			Compte compte=compteliste.get(mapKey);

			EntityManager em=emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			compte.setClientlogin(client);
			
			em.persist(compte);

			et.commit();
			em.close();
			
			}
	
	}
	
	@Override
	public Map<String, Compte> lirecomptedansfichierJPA() {
		
		
		Map<String,Compte> comptesmap= new HashMap<>();
		Compte compte=null;
		
		EntityManager em=emf.createEntityManager();
		Query query = em.createQuery("select compte from Compte compte");
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		for(int i=0;i<(query.getResultList()).size();i++)
			{
				compte = (Compte) query.getResultList().get(i);	
				comptesmap.put(compte.getNumero(),compte);
			}

		
		
				
		et.commit();
		em.close();
		
		return comptesmap;
	}

	
}
