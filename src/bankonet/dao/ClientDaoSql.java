package bankonet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import bankonet.dto.Civilite;
import bankonet.dto.Client;
import bankonet.dto.Compte;
import bankonet.dto.CompteCourant;
import bankonet.dto.CompteEpargne;

public class ClientDaoSql implements ClientDao{

	@Override
	public void saveClient(Client client) {

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
						int nbClient = statement.executeUpdate("INSERT INTO `client`(`Login`, `Motdepasse`, `Identifiant`, `Civilite`, `Nom`, `Prenom`) VALUES ('"+client.getLogin()+"','"+client.getMdp()+"','"+client.getIdentifiant()+"','"+client.getCivilite()+"','"+client.getNom()+"','"+client.getPrenom()+"')");

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

	public Map<String, Client> lireclientdansfichier() {
		
		Map<String,Client> clientsmap= new HashMap<>();
		Client client=null;
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

						
						ResultSet resultats = statement.executeQuery("SELECT * FROM Client");

								while(resultats.next()) {
										client=new Client(resultats.getString("Nom"),resultats.getString("Prenom"),resultats.getString("Identifiant"),Civilite.valueOf(resultats.getString("Civilite")),resultats.getString("Login"),resultats.getString("Motdepasse"));
									
										clientsmap.put(resultats.getString("Login"),client);
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
		return clientsmap;
	}

	
	
}
