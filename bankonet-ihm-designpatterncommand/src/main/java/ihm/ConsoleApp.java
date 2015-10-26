package ihm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import command.ExitCommand;
import command.IhmCommand;
import command.InitialiserBDDCommand;
import command.ListerTousLesCLientsCommand;
import command.ModifierunclientCommmand;
import command.OuvrirCompteCourantCommand;
import command.OuvrirCompteCourantJPACommand;
import command.OuvrirCompteEpargneCommand;
import command.OuvrirCompteEpargneJPACommand;
import command.OuvrirUnCompteCommand;
import command.OuvrirUnCompteJPACommand;
import command.RechercheparNomCommand;
import command.RechercheparPrenomCommand;
import command.SupprimertouslesclientCommand;
import command.SupprimerunclientCommand;
import dao.FactoryDao;
import dao.FactoryDaoJpa;
import metier.ServiceClient;
import metier.ServiceClientImp;
import metier.ServiceCompte;
import metier.ServiceComtpeImp;

public class ConsoleApp {

	
	
	private List<IhmCommand> commands=Arrays.asList(
			new ExitCommand(),
			new OuvrirUnCompteCommand(),
			//new ListerTousLesCLientsCommand(),
			new OuvrirCompteCourantCommand(),
			new OuvrirCompteEpargneCommand(),
			new ListerTousLesCLientsCommand(),
			new InitialiserBDDCommand(),
			new RechercheparNomCommand(),
			new RechercheparPrenomCommand(),
			new ModifierunclientCommmand(),
			new SupprimerunclientCommand(),
			new SupprimertouslesclientCommand(),
			new OuvrirCompteCourantJPACommand(),
			new OuvrirCompteEpargneJPACommand(),
			new OuvrirUnCompteJPACommand()
			);

	
	public static void main(String[] args){
		
		int choix=99;
		FactoryDao factory =new FactoryDaoJpa();
		ServiceCompte servicecompte= new ServiceComtpeImp( factory.getClientDao(), factory.getCompteDao());
		ServiceClient serviceclient= new ServiceClientImp(servicecompte,factory.getClientDao(), factory.getCompteDao());
		
		
		
		
		ConsoleApp app=new ConsoleApp();
		
		while (choix!=0)
		{
			choix=app.afficherMenu();
			app.executecommande(choix,servicecompte,serviceclient);
		}
		
		if(choix==0){
			System.exit(0);
		}
	}
	

	public int afficherMenu(){
		
		System.out.println("*****************Application Conseiller Bancaire ************");

		Collections.sort(commands,new Comparator<IhmCommand>(){
			@Override
			public int compare(IhmCommand o1, IhmCommand o2) {
				return o1.getId().compareTo(o2.getId());
			}
		}
		);
		for(IhmCommand command: commands){
			System.out.println(command.getId()+ ". " + command.getLibelleMenu());
		}
		Scanner sc = new Scanner(System.in);
		//récupérer la saisie
		System.out.println("Veuillez choisir une action.");
		int choix = sc.nextInt();
		sc.nextLine();

		return choix;
		
	}
		
		
		
	
		
	public void executecommande(int choix, ServiceCompte servicecompte, ServiceClient serviceclient)
	{
		
		//trouver la commande
		for(IhmCommand command: commands){

			if(command.getId()==choix)
			{
				command.excecute(servicecompte,serviceclient);
				break;
			}
		}
	
	}
}

