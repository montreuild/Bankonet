package bankonet.metier;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bankonet.dao.ClientDao;
import bankonet.dao.CompteDao;
import bankonet.dto.Client;
import bankonet.dto.Compte;
import bankonet.dto.CompteCourant;
import bankonet.dto.CompteEpargne;

public class ServiceComtpeImp implements ServiceCompte{
	
	private CompteDao comptedao;
	private ClientDao clientdao;


	public ServiceComtpeImp(ClientDao clientdao,CompteDao comptedao) {
		this.clientdao = clientdao;
		this.comptedao=comptedao;
	}


	@Override
	public Client CreerCompteCourant(Client client) {
		
		int nbrcompte = 0;
		
		nbrcompte=NombreCompteCourant(client);
		
		String strCC= "["+client.getNom().toUpperCase() +"]_["+client.getPrenom().toUpperCase()+"]_Courant_"+nbrcompte;
		
		CompteCourant comptecourant= new CompteCourant("CC"+nbrcompte,strCC, 0d, -100d);
		
		client.creerCompte(comptecourant);
		
		comptedao.saveCompte(client);
		
		return client;
	}
	
	
	

	@Override
	public Client CreerCompteEpargne(Client client) {
		
		int nbrcompte = 0;
		
		nbrcompte=NombreCompteEpargne(client);
		
		String strCE= "["+client.getNom().toUpperCase() +"]_["+client.getPrenom().toUpperCase()+"]_Epargne_"+nbrcompte;
		
		CompteEpargne compteepargne= new CompteEpargne("CE"+nbrcompte,strCE, 0d, 2d);
		
		client.creerCompte(compteepargne);
		
		comptedao.saveCompte(client);
		
		return client;
	}

	
	
	@Override
	public int NombreCompteCourant(Client client) {
		
		int nbrcompte=1;
		
		Map<String,Compte> compteliste= new HashMap<>();
		compteliste= listercomptesclient(client);
		
		
		for (String mapKey : compteliste.keySet()) {
			if(compteliste.get(mapKey)  instanceof CompteCourant )
				nbrcompte++;
		}
		
		return nbrcompte;
	}

	
	@Override
	public int NombreCompteEpargne(Client client) {
		
		int nbrcompte=1;
		
		Map<String,Compte> compteliste= new HashMap<>();
		compteliste= listercomptesclient(client);
		
		for (String mapKey : compteliste.keySet()) {
			if(compteliste.get(mapKey)  instanceof CompteEpargne )
				nbrcompte++;
		}
		
		return nbrcompte;
	}

	@Override
	public Map<String, Compte> listerlescomptes() {
		Map<String,Compte> comptesmap= new HashMap<>();
		comptesmap=comptedao.lirecomptedansfichier();
		return comptesmap;
	}


	@Override
	public Map<String, Compte> listercomptesclient(Client client) {
		
		Map<String,Compte> comptesmap= new HashMap<>();
		comptesmap=comptedao.lirecomptedansfichier();
		return comptesmap;

	}

	//JPA
	
	@Override
	public Client CreerCompteCourantJPA(Client client) {
		
		int nbrcompte = 0;
		nbrcompte=NombreCompteCourantJPA();
		
		String strCC= "["+client.getNom().toUpperCase() +"]_["+client.getPrenom().toUpperCase()+"]_Courant_"+nbrcompte;
		
		CompteCourant comptecourant= new CompteCourant("CC"+nbrcompte,strCC, 0d, -100d);
		
		comptedao.saveCompteJPA(client,comptecourant);
		
		return client;
	}


	@Override
	public Client CreerCompteEpargneJPA(Client client) {
		
		int nbrcompte = 0;
		nbrcompte=NombreCompteEpargneJPA();
		
		String strCE= "["+client.getNom().toUpperCase() +"]_["+client.getPrenom().toUpperCase()+"]_Epargne_"+nbrcompte;
		
		CompteEpargne compteepargne= new CompteEpargne("CE"+nbrcompte,strCE, 100d, 2d);
		
		comptedao.saveCompteJPA(client,compteepargne);
		
		return client;
	}


	public int NombreCompteCourantJPA() {
		
		int nbrcomptecourant;
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Bankonet");
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
			Query query = em.createQuery("select clt from Compte clt where TYPECOMPTE='CompteCourant'");
			nbrcomptecourant = query.getResultList().size();
			
		et.commit();
		em.close();
		
		return nbrcomptecourant+1;
	}


	public int NombreCompteEpargneJPA() {
		
		int nbrcompteepargne;
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Bankonet");
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
			Query query = em.createQuery("select clt from Compte clt where TYPECOMPTE='CompteEpargne'");
			nbrcompteepargne = query.getResultList().size();
			
		et.commit();
		em.close();
		
		return nbrcompteepargne+1;
	}


	@Override
	public Map<String, Compte> listerlescomptesJPA() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Compte> listercomptesclientJPA(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
