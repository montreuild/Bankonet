package bankonet.metier;

import java.util.Map;

import bankonet.dto.Client;

public interface ServiceClient {

	public Client connexion(String login, String mdp);
	public Client creerclient(String nom, String prenom, String login);
	public Map<String,Client> listerlesclients();
	public Client retrounerclientlogin(String login);

}
