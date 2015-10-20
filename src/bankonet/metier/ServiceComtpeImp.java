package bankonet.metier;

import java.util.HashMap;
import java.util.Map;

import bankonet.dao.CompteDao;
import bankonet.dto.Client;
import bankonet.dto.Compte;
import bankonet.dto.CompteCourant;
import bankonet.dto.CompteEpargne;

public class ServiceComtpeImp implements ServiceCompte{
	
	CompteDao comptedao=null;

	public ServiceComtpeImp(CompteDao compteDao) {
		this.comptedao=compteDao;
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

}
