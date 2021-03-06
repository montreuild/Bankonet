package ihm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import dao.FactoryDao;
import dto.Client;
import dto.CompteCourant;
import dto.CreditException;
import dto.DebitException;


public class Bankonet_Client {

	
	//FactoryDao factory;
	//private CompteService compteService= new CompteServiceImp();
	//private ClientService clientservice=new ClientServiceImp(compteService,factory.getClientDao());
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String choix="99";
		String connexion="nok";
		Client sessionclient=new Client();
		String login;
		String mdp;
		
			do
			{
				System.out.println("Veuillez saisir votre login:");
				login = sc.nextLine();
				
				System.out.println("Veuillez saisir votre mot de passe:");
				mdp = sc.nextLine();
				
				
				
			}
			while(connexion!="ok");
				
			
			while (choix.equals("0")==false)
				{
					
					System.out.println("***** APPLICATION CLIENT ******");
					System.out.println("0. Arréter le programme");
					System.out.println("1. Consulter les soldes des comptes");
					System.out.println("2. Effectuer un dépot");
					System.out.println("3. Effectuer un retrait");
					System.out.println("4. Effectuer un virement entre vos comptes");
					System.out.println("5. Effectuer un virement externe");
					System.out.println("Veuillez choisir une action.");
					choix=sc.nextLine();
					
					System.out.println("L'action choisi est."+choix);
					
					
					switch(choix){
					
					case "0":
						//0. Arréter le programme
						System.out.println("Arrét de l'application");
						break;
						
					case "1":
						//"1. Consulter les soldes des comptes"
						
						Set<String> listKeys=sessionclient.getComptesMap().keySet();
						Iterator iterateur=listKeys.iterator();
			    		while(iterateur.hasNext())
			    		{
			    			Object key= iterateur.next();
			    			System.out.println (key+"=>"+sessionclient.getComptesMap().get(key));
			    		}

						break;
						
					case "2":
						//"2. Effectuer un dépot"
						
						//affichage des comptes courants:
						Set<String> listKeys1=sessionclient.getComptesMap().keySet();
						Iterator iterateur1=listKeys1.iterator();
			    		while(iterateur1.hasNext())
			    		{
			    			Object key= iterateur1.next();
			    			if(sessionclient.getComptesMap().get(key) instanceof CompteCourant )
			    				System.out.println (key+"=>"+sessionclient.getComptesMap().get(key));
			    		}
						
			    		System.out.println ("Taper le numero(string type CC1) du compte a crediter");
			    		String compteacrediter = sc.nextLine();
			    		System.out.println ("Taper le montant a crediter");
			    		double montantacrediter = sc.nextInt();
			    		sc.nextLine();
			    		
			    		try {
							sessionclient.getComptesMap().get(compteacrediter).crediter(montantacrediter);
						} catch (CreditException e) {

							System.out.println("Le compte selectionné ou le montant est non valide");
							e.printStackTrace();
						}
			    		
			    		   System.out.print("Votre nouveau solde est de "+ sessionclient.getComptesMap().get(compteacrediter).getSolde() +"\n\n");
			    		   
			    		   
			    		
//			    		//Enregistrement dans le fichier client et compte
//			    		Stockage<String, Client> stock=new Stockage<String, Client>();
//						stock.enregistrerclientdansfichier(sessionclient);
//						stock.enregistrercomptedansfichier(sessionclient.getComptesMap().get(compteacrediter));
//		
//						
//						//Récupération du client et du compte après, on rafraichie le client
//						Map<String,Client> clientsliste= new HashMap<>();
//						clientsliste=Stockage.lireclientdansfichier();
//						sessionclient=clientsliste.get(login);
			    		
						break;
						
					case "3":
						
						//"3. Effectuer un retrait"
						
						double montantadebiter = 0;
						double debitmax;
						String compteadebiter = null;
						
						//affichage des comptes courants:
						Set<String> listKeys11=sessionclient.getComptesMap().keySet();
						Iterator iterateur11=listKeys11.iterator();
			    		while(iterateur11.hasNext())
			    		{
			    			Object key= iterateur11.next();
			    			if(sessionclient.getComptesMap().get(key) instanceof CompteCourant )
			    				System.out.println (key+"=>"+sessionclient.getComptesMap().get(key));
			    		}
			    		
			    		
						try {
							
				    		System.out.println ("Taper le numero(string type CC1) du compte a debiter");
				    		compteadebiter = sc.nextLine();
				    	
				    		//Récupération du débit max
				    		debitmax=sessionclient.getComptesMap().get(compteadebiter).debitmax();
				    		
				    		//Boucle sur le montant si supérieur a debitmax
					    	do{
					    		System.out.println ("Taper le montant a debiter");
					    		montantadebiter = sc.nextInt();
					    		sc.nextLine();
					    		if(montantadebiter>debitmax){
					    			System.out.println("Le montant du retrait dépasse le plafont de "+debitmax+" autorisé\n Tapez 0 pour abandonner ou reessayez\n");
					    		}
					    		
					    		
					    		}
					    	while(montantadebiter>debitmax);
					    	
					    	sessionclient.getComptesMap().get(compteadebiter).debiter(montantadebiter);
				    		
						} catch (DebitException e) {

							System.out.println("Le compte selectionné ou le montant est non valide");
							e.printStackTrace();
						}
			    		
						if(montantadebiter!=0.0f){
							
						
			    		   System.out.print("Votre nouveau solde est de "+ sessionclient.getComptesMap().get(compteadebiter).getSolde() +"\n\n");
			    		
//				    		//Enregistrement dans le fichier client et compte
//				    		Stockage<String, Client> stock1=new Stockage<String, Client>();
//							stock1.enregistrerclientdansfichier(sessionclient);
//							stock1.enregistrercomptedansfichier(sessionclient.getComptesMap().get(compteadebiter));
//			
//							
//							//Récupération du client et du compte aprés, on rafraichie le client
//							Map<String,Client> clientsliste1= new HashMap<>();
//							clientsliste1=Stockage.lireclientdansfichier();
//							sessionclient=clientsliste1.get(login);
			    		}
						break;
						
					case "4":
						//"4. Effectuer un virement entre vos comptes"
						break;
						
					case "5":
						//"5. Effectuer un virement externe"
						break;
		
						
					default:
						
						break;
					}
				}
	}
}

