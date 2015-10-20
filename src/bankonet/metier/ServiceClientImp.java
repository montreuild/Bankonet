package bankonet.metier;

import java.util.HashMap;
import java.util.Map;

import bankonet.dao.ClientDao;
import bankonet.dao.CompteDao;
import bankonet.dto.Civilite;
import bankonet.dto.Client;
import bankonet.dto.CompteCourant;

public class ServiceClientImp implements ServiceClient{

		private ClientDao clientdao;
		private ServiceCompte servicecompte;
		private CompteDao comptedao;
		
		public ServiceClientImp(ServiceCompte servicecompte, ClientDao clientdao,CompteDao comptedao) {
			this.clientdao = clientdao;
			this.servicecompte=servicecompte;
			this.comptedao=comptedao;
		}


		public Client connexion(String login, String mdp) {

			Map<String,Client> clientsmap= new HashMap<>();
			clientsmap=clientdao.lireclientdansfichier();
			Client sessionclient=clientsmap.get(login);
			
			if(sessionclient!= null)
					if(sessionclient.getMdp().equals(mdp)){
						return sessionclient;
				}else{
					System.out.println("Erreur, try again!! \n");
				}
			else{	
				System.out.println("login erroné");
				return null;
				}
			
			
			return null;
			
		}


		@SuppressWarnings("null")
		public Client creerclient(String nom, String prenom, String login) {
				
			Client client = new Client();
			
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setLogin(login);
			client.setIdentifiant(login);
			client.setCivilite(Civilite.MONSIEUR);
			client.setMdp("0000");
			
			
			clientdao.saveClient(client);
			client=servicecompte.CreerCompteCourant(client);
			
			return client;
			
			

			
		}

		@Override
		public Map<String, Client> listerlesclients() {
			Map<String,Client> clientsmap= new HashMap<>();
			clientsmap=clientdao.lireclientdansfichier();
			return clientsmap;
	
		}


		public Client retrounerclientlogin(String login){
			Client client=new Client();
			
			Map<String,Client> clientsmap= new HashMap<>();
			clientsmap= new HashMap<>();
			clientsmap=clientdao.lireclientdansfichier();
			
			for (String mapKey : clientsmap.keySet()) {
				if(clientsmap.get(mapKey).getLogin().equals(login))
					return clientsmap.get(mapKey);
			}
			return null;
			
		}

}
