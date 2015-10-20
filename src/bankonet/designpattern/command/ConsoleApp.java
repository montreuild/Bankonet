package bankonet.designpattern.command;

import java.util.List;
import java.util.Scanner;

import bankonet.dao.FactoryDao;
import bankonet.dao.FactoryDaoSql;
import bankonet.metier.ServiceClient;
import bankonet.metier.ServiceClientImp;
import bankonet.metier.ServiceCompte;
import bankonet.metier.ServiceComtpeImp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class ConsoleApp {

	
	
	private List<IhmCommand> commands=Arrays.asList(
			new ExitCommand(),
			new OuvrirUnCompteCommand(),
			//new ListerTousLesCLientsCommand(),
			new OuvrirCompteCourantCommand(),
			new OuvrirCompteEpargneCommand(),
			new ListerTousLesCLientsCommand(),
			new InitialiserBDDCommand()
			);

	
	public static void main(String[] args){
		
		int choix=99;
		FactoryDao factory =new FactoryDaoSql();
		ServiceCompte servicecompte= new ServiceComtpeImp(factory.getCompteDao());
		ServiceClient serviceclient= new ServiceClientImp(servicecompte,factory.getClientDao(), factory.getCompteDao());
		
		
		
		
		ConsoleApp app=new ConsoleApp();
		
		while (choix!=0)
		{
			choix=app.afficherMenu();
			app.executecommande(choix,servicecompte,serviceclient);
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

