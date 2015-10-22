package dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import dto.Client;

public class ClientDaoFile implements ClientDao {

	private static final String FICHIER_STOCKAGE_CLIENT = "fichierclient.txt";

	
	@Override
	public void saveClient(Client client) {
		
		
		Map<String,Client> clientsmap= new HashMap<>();
		clientsmap=lireclientdansfichier();
		clientsmap.put(client.getLogin(), client);

	    ObjectOutputStream oos=null;
	      try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(FICHIER_STOCKAGE_CLIENT))));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	        try {
	            oos.writeObject(clientsmap);
	
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	      
	      try {
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Map<String, Client> lireclientdansfichier() {
		
		Map<String,Client> clientsmap= new HashMap<>();
		 
		FileInputStream fis=null;
		try {
			fis = new FileInputStream (FICHIER_STOCKAGE_CLIENT);
		} catch (FileNotFoundException e1) {
		}
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream (fis);
			Object objetStocke = ois.readObject ();
			clientsmap=(Map<String,Client>) objetStocke;
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        return clientsmap;
	}


	@Override
	public Client findByLastnameJPA(String search) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Client findByFirstnameJPA(String search) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void modifiernomclientJPA(String nom, String login) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void supprimerunclientJPA(String login) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void supprimertouslesclientsJPA() {
		// TODO Auto-generated method stub
		
	}


		
}
