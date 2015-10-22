package metier;

import java.util.Map;

import dto.Client;

public interface ServiceClient {

	public Client connexion(String login, String mdp);
	public Client creerclient(String nom, String prenom, String login);
	public Map<String,Client> listerlesclients();
	public Client retrounerclientlogin(String login);
	
	//JPA
	public Client retrouverclientparNomJPA(String mom);
	public Client retrouverclientparPrenomJPA(String premom);
	void modifierunclientJPA(String nom, String login);
	void supprimerunclientJPA(String login);
	void supprimertouslesclientJPA();
	public Client creerclientJPA(String nom, String prenom, String login);
	public Map<String,Client> listerlesclientsJPA();
	public Client retrounerclientloginJPA(String login);

}
