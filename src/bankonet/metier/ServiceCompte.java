package bankonet.metier;

import java.util.Map;

import bankonet.dto.Client;
import bankonet.dto.Compte;

public interface ServiceCompte {

	Client CreerCompteCourant(Client client);
	Client CreerCompteEpargne(Client client);
	int NombreCompteCourant(Client client);
	int NombreCompteEpargne(Client client);
	Map<String, Compte> listerlescomptes();
	Map<String, Compte> listercomptesclient(Client client);
	
	//JPA
	Client CreerCompteCourantJPA(Client client);
	Client CreerCompteEpargneJPA(Client client);
	int NombreCompteCourantJPA();
	int NombreCompteEpargneJPA();
	Map<String, Compte> listerlescomptesJPA();
	Map<String, Compte> listercomptesclientJPA(Client client);
}
