package bankonet_conseiller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import bankonet_stockage.Civilite;
import bankonet_stockage.Client;
import bankonet_stockage.Compte;
import bankonet_stockage.CompteCourant;
import bankonet_stockage.CompteEpargne;
import bankonet_stockage.Stockage;

public class Bankonet_Conseiller {

	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
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
				Client clientaenregistrer=new Client();
				System.out.println("Veuillez saisir un nom:");
				clientaenregistrer.setNom(sc.nextLine());
				
				System.out.println("Veuillez saisir un prenom:");
				clientaenregistrer.setPrenom(sc.nextLine());
				
				System.out.println("Veuillez saisir un login:");
				clientaenregistrer.setLogin(sc.nextLine());
				clientaenregistrer.setIdentifiant(clientaenregistrer.getLogin());
				clientaenregistrer.setCivilite(Civilite.MONSIEUR);
				clientaenregistrer.setMdp("0000");
				
				
				String strCC1= "["+clientaenregistrer.getNom().toUpperCase() +"]_["+clientaenregistrer.getPrenom().toUpperCase()+"]_Courant_1";
				String strCE1= "["+clientaenregistrer.getNom().toUpperCase() +"]_["+clientaenregistrer.getPrenom().toUpperCase()+"]_Epargne_1";
				
				CompteCourant CompteCourant2= new CompteCourant("CC1",strCC1, 0d, -100d);
				CompteEpargne CompteEpargne1= new CompteEpargne("CE1",strCE1, 1000d, -100d);
				clientaenregistrer.creerCompte(CompteCourant2);
				clientaenregistrer.creerCompte(CompteEpargne1);
				Stockage<String, Client> stock=new Stockage<String, Client>();
				stock.enregistrerclientdansfichier(clientaenregistrer);
				stock.enregistrercomptedansfichier(CompteCourant2);
				stock.enregistrercomptedansfichier(CompteEpargne1);
				
				System.out.println("Le client et les comptes ont été ajouté aux fichiers");
				
				break;
				
			case "2":
				//"2. Lister tous les clients
				Map<String,Client> clientsliste= new HashMap<>();
				clientsliste=Stockage.lireclientdansfichier();
				System.out.println(clientsliste);
				
				//Lister les comptes
				Map<String, Compte> comptesliste= new HashMap<>();
				comptesliste=Stockage.lirecomptedansfichier();
				System.out.println(comptesliste);
	
				
				break;
				
			case "3":
				//"3. Ajouter un compte courant
				
				//Lister tous les clients
				Map<String,Client> clientsliste1= new HashMap<>();
				clientsliste1=Stockage.lireclientdansfichier();
				System.out.println(clientsliste1);
				
				System.out.println("Veuillez saisir le login du client:");
				String selectionclient = sc.nextLine();
				
				Client clientparcouru=clientsliste1.get(selectionclient);
				
				
				
					//Récupération du nombre de compte pour le client
				
				int nbrcompte=1; //A ajuster en fonction du nombre déja existant
				Map<String,Compte> compteliste= new HashMap<>();
				compteliste=clientparcouru.getComptesMap();
				
				for (String mapKey : compteliste.keySet()) {
					if(compteliste.get(mapKey)  instanceof CompteCourant )
						nbrcompte++;
				}
				
				//Cration et initialisation du compte à creer
				String strCC11= "["+clientparcouru.getNom().toUpperCase() +"]_["+clientparcouru.getPrenom().toUpperCase()+"]_Courant_"+nbrcompte;
				CompteCourant nouveaucc= new CompteCourant("CC"+nbrcompte,strCC11, 0d, -100d);
				clientparcouru.creerCompte(nouveaucc);
				
				//Enregitrement dans les fichiers
				Stockage<String, Client> stock1=new Stockage<String, Client>();
				stock1.enregistrerclientdansfichier(clientparcouru);
				stock1.enregistrercomptedansfichier(nouveaucc);
				
				break;
				
				
			case "4":
				//"4. Ajouter un compte épargne
				
				//Lister tous les clients
				Map<String,Client> clientsliste11= new HashMap<>();
				clientsliste11=Stockage.lireclientdansfichier();
				System.out.println(clientsliste11);
				
				System.out.println("Veuillez saisir le login du client:");
				String selectionclient1 = sc.nextLine();
				
				Client clientparcouru1=clientsliste11.get(selectionclient1);
				
				
				
					//Récupération du nombre de compte pour le client
				
				int nbrcompte1=1; //A ajuster en fonction du nombre déja existant
				Map<String,Compte> compteliste1= new HashMap<>();
				compteliste1=clientparcouru1.getComptesMap();
				
				for (String mapKey : compteliste1.keySet()) {
					if(compteliste1.get(mapKey)  instanceof CompteEpargne )
						nbrcompte1++;
				}
				
				//Cration et initialisation du compte à creer
				String strCC111= "["+clientparcouru1.getNom().toUpperCase() +"]_["+clientparcouru1.getPrenom().toUpperCase()+"]_Epargne_"+nbrcompte1;
				CompteEpargne nouveauce1= new CompteEpargne("CE"+nbrcompte1,strCC111, 0d, 2.5);
				clientparcouru1.creerCompte(nouveauce1);
				
				//Enregitrement dans les fichiers
				Stockage<String, Client> stock11=new Stockage<String, Client>();
				stock11.enregistrerclientdansfichier(clientparcouru1);
				stock11.enregistrercomptedansfichier(nouveauce1);
				
				break;
				
			case "5":
				//"5. Autoriser un découvert"
				
				//Lister tous les clients
				Map<String,Client> clientsliste111= new HashMap<>();
				clientsliste111=Stockage.lireclientdansfichier();
				System.out.println(clientsliste111);
				
				System.out.println("Veuillez saisir le login du client:");
				String selectionclient11 = sc.nextLine();
				
				
				//"Affichage des comptes du client"
				Client sessionclient=clientsliste111.get(selectionclient11);
				
				Set<String> listKeys=sessionclient.getComptesMap().keySet();
				Iterator iterateur=listKeys.iterator();
	    		while(iterateur.hasNext())
	    		{
	    			Object key= iterateur.next();
	    			System.out.println (key+"=>"+sessionclient.getComptesMap().get(key));
	    		}
				
	    		System.out.println ("Taper le numero(string type CC1) du compte a crediter");
	    		String compteaplafonner = sc.nextLine();
	    		
	    		
				
				//en cours
				
				
				break;

				
			default:
				
				break;
			}
		}
	}
	
}
