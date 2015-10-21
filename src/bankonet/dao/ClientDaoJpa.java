package bankonet.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import bankonet.dto.Client;

public class ClientDaoJpa implements ClientDao{

	EntityManagerFactory emf;
	
	public ClientDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void saveClient(Client client) {

		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.persist(client);

		et.commit();
		em.close();
		
	}

	@Override
	public Map<String, Client> lireclientdansfichier() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Client findByLastnameJPA(String search) {
		EntityManager em=emf.createEntityManager();
		Client client=new Client();
		try{
		client=em.createNamedQuery("client.findByLastname",Client.class).setParameter("searchnom", search).getSingleResult();
		return client;
		}
		catch(NoResultException e)
		{
			System.out.println("Pas de client trouvé");
			return null;
		}

	}
	
	public Client findByFirstnameJPA(String search) {
		EntityManager em=emf.createEntityManager();
		Client client=new Client();
		try{
		client=em.createNamedQuery("client.findByFirstname",Client.class).setParameter("searchprenom", search).getSingleResult();
		return client;
		}
		catch(NoResultException e)
		{
			System.out.println("Pas de client trouvé");
			return null;
		}
		
	}
	
	public void modifiernomclientJPA(String nom, String login){
		EntityManager em=emf.createEntityManager();
	
		EntityTransaction et = em.getTransaction();
		et.begin();
			Client clientaupdate = em.find(Client.class, login);
			if(clientaupdate != null){
					clientaupdate.setNom(nom);
					em.merge(clientaupdate);
					System.out.println(clientaupdate);
			}else{
				System.out.println("Client pas trouvé");
			}
		et.commit();
		em.close();
	}
	
	public void supprimerunclientJPA(String login){
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
			Client clientasup = em.find(Client.class, login);
			if(clientasup != null){
					em.remove(clientasup);
					System.out.println("Client supprimé");
			}else{
				System.out.println("Client pas trouvé");
			}
		et.commit();
		em.close();
		
	}
	
	public void supprimertouslesclientsJPA(){
		
		EntityManager em=emf.createEntityManager();
		Query query = em.createQuery("Delete from Client");
		EntityTransaction et = em.getTransaction();
		et.begin();
		int nbrclientsup=query.executeUpdate();
		et.commit();
		em.close();
		System.out.println(nbrclientsup+" client sont morts! Il n'en reste aucun!");
		
	}
		
}
