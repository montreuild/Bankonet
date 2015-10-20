package bankonet.ihm.conseiller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import bankonet.dao.FactoryDao;
import bankonet.dao.FactoryDaoFile;
import bankonet.dao.FactoryDaoSql;
import bankonet.dto.*;
import bankonet.metier.*;


public class BankonetConseiller {

	
	// FactoryDao factory =new FactoryDaoFile();
	 FactoryDao factory =new FactoryDaoSql();
	 ServiceCompte servicecompte= new ServiceComtpeImp(factory.getCompteDao());
	 ServiceClient serviceclient= new ServiceClientImp(servicecompte,factory.getClientDao(), factory.getCompteDao());
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		BankonetConseiller app = new BankonetConseiller();
		app.start();
	}


	private void start() throws IOException, FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String choix="99";
		
		while (choix.equals("0")==false)
		{

			
			System.out.println("***** APPLICATION CONSEILLER BANCAIRE ******");
			System.out.println("0. Arrêter le programme");
			System.out.println("1. Ouvrir un compte");
			System.out.println("2. Lister tous les clients");
			System.out.println("3. Ajouter un compte courant");
			System.out.println("4. Ajouter un compte épargne");
			System.out.println("5. Autoriser un découvert");
			System.out.println("Veuillez choisir une action.");
			choix=sc.nextLine();
		
			System.out.println("L'action choisi est."+choix);
			
			
			switch(choix){
			
			case "0":
				//0. Arrêter le programme
				System.out.println("Arrêt de l’application");
				break;
				
			case "1":
				//"1. Ouvrir un compte
				
				String nom;
				String prenom;
				String login;
				
				System.out.println("Veuillez saisir un nom:");
				nom=sc.nextLine();
				
				System.out.println("Veuillez saisir un prenom:");
				prenom=sc.nextLine();
				
				System.out.println("Veuillez saisir un login:");
				login=sc.nextLine();
				
				
				Client client=new Client();
				client=serviceclient.creerclient(nom, prenom, login);

				
				break;
				
			case "2":
				//"2. Lister tous les clients
				
				//Lister les clients
				System.out.println(serviceclient.listerlesclients());
				
				//Lister les comptes
				System.out.println(servicecompte.listerlescomptes());
				
				break;
				
			case "3":
				//"3. Ajouter un compte courant
				
				System.out.println(serviceclient.listerlesclients());
				
				System.out.println("Veuillez saisir le login du client:");
				String loginclient = sc.nextLine();
				
				Client clientseclectionner=serviceclient.retrounerclientlogin(loginclient);
				
				servicecompte.CreerCompteCourant(clientseclectionner);

				break;
				
				
			case "4":
				
				//"4. Ajouter un compte épargne
				
				System.out.println(serviceclient.listerlesclients());
				
				System.out.println("Veuillez saisir le login du client:");
				String loginclient1 = sc.nextLine();
				
				Client clientseclectionner1=serviceclient.retrounerclientlogin(loginclient1);
				
				servicecompte.CreerCompteEpargne(clientseclectionner1);

				break;
				
				
			case "5":
			
				//"5. Autoriser un découvert"
				
				System.out.println(serviceclient.listerlesclients());
				
				System.out.println("Veuillez saisir le login du client:");
				String loginclient11 = sc.nextLine();
				
				
				Client clientseclectionner11=serviceclient.retrounerclientlogin(loginclient11);
				
				System.out.println(servicecompte.listercomptesclient(clientseclectionner11));
				
	    		System.out.println ("Taper le numero(string type CC1) du compte à modifier");
	    		String compteamodifier = sc.nextLine();
	    		System.out.println ("Taper le montant du nouveau découvert autorisé");
	    		String montantdécouvert = sc.nextLine();
	    		
	    		
	    		//Implementer pour la modification du découvert.
				
				break;

				
			default:
				
				break;
			}
		}
	}
	
}
