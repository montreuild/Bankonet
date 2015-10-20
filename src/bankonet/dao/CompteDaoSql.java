package bankonet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;



import bankonet.dto.Client;
import bankonet.dto.Compte;
import bankonet.dto.CompteCourant;
import bankonet.dto.CompteEpargne;

public class CompteDaoSql implements CompteDao{

	public void saveCompte(String loginclient,Compte compte) {

		//Connection
		String url = "jdbc:mysql://localhost:3306/bddbankonet";
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","");
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//ReQUETE
		Statement statement;
		try {
			statement = connection.createStatement();
	
		if (compte instanceof CompteCourant)
			{
			int nbCompte = statement.executeUpdate("INSERT INTO `compte`(`Loginclient`, `Numero`, `Intitule`, `Solde`, `montantDecouvertAutorise`, `type`) VALUES ('"+loginclient+"','"+compte.getNumero()+"','"+ compte.getIntitule()+"','"+compte.getSolde()+"','"+((CompteCourant) compte).getMontantDecouvertAutorise()+"','CompteCourant')");
			}
		if (compte instanceof CompteEpargne)
			{
			int nbCompte = statement.executeUpdate("INSERT INTO `compte`(`Loginclient`, `Numero`, `Intitule`, `Solde`, `montantDecouvertAutorise`, `taux interet`, `type`) VALUES ('"+loginclient+"','"+compte.getNumero()+"','"+ compte.getIntitule()+"','"+compte.getSolde()+"','"+((CompteEpargne) compte).getTauxInteret()+"','CompteEpargne')");			
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Fermeture de la connection
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveCompte(Client client) {
		
		//Connection
		String url = "jdbc:mysql://localhost:3306/bddbankonet";
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","");
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String loginclient = client.getLogin();

		Map<String,Compte> compteliste= new HashMap<>();
		compteliste=client.getComptesMap();

		for (String mapKey : compteliste.keySet()) {


			Compte compte=compteliste.get(mapKey);
			//ReQUETE
			Statement statement;
			try {
				statement = connection.createStatement();

				if (compte instanceof CompteCourant)
				{
					int nbCompte = statement.executeUpdate("INSERT INTO `compte`(`Loginclient`, `Numero`, `Intitule`, `Solde`, `montantDecouvertAutorise`, `type`,`taux interet`) VALUES ('"+loginclient+"','"+compte.getNumero()+"','"+ compte.getIntitule()+"','"+compte.getSolde()+"','"+((CompteCourant) compte).getMontantDecouvertAutorise()+"','CompteCourant','0')");
				}
				if (compte instanceof CompteEpargne)
				{
					int nbCompte = statement.executeUpdate("INSERT INTO `compte`(`Loginclient`, `Numero`, `Intitule`, `Solde`, `taux interet`, `type`,`montantDecouvertAutorise`) VALUES ('"+loginclient+"','"+compte.getNumero()+"','"+ compte.getIntitule()+"','"+compte.getSolde()+"','"+((CompteEpargne) compte).getTauxInteret()+"','CompteEpargne','0')");			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//Fermeture de la connection
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Compte> lirecomptedansfichier() {
		
		
		Map<String,Compte> comptesmap= new HashMap<>();
		Compte compte=null;
		//Connection
				String url = "jdbc:mysql://localhost:3306/bddbankonet";
				Connection connection=null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(url,"root","");
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

					Statement statement;
					try {
						statement = connection.createStatement();

						
						ResultSet resultats = statement.executeQuery("SELECT * FROM Compte");

								while(resultats.next()) {
									
									if (resultats.getString("type").equals("CompteCourant")){
										compte=new CompteCourant(resultats.getString("Numero"), resultats.getString("Intitule"),resultats.getDouble("Solde"),resultats.getDouble("montantDecouvertAutorise"));
									}
									if (resultats.getString("type").equals("CompteEpargne")){
										compte=new CompteEpargne(resultats.getString("Numero"), resultats.getString("Intitule"),resultats.getDouble("Solde"),resultats.getDouble("taux interet"));
									}
									
									comptesmap.put(resultats.getString("Numero"),compte);
								}

						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				

				//Fermeture de la connection
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return comptesmap;
	}

}
