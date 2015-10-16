package bankonet_stockage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Stockage <T,E>{

	private static final String FICHIER_STOCKAGE = "fichierclient.txt";
	private static final String FICHIER_STOCKAGE_COMPTE = "fichiercompte.txt";
	Map<T,E> maplist;
	
	public E retournerElement(T cle){
		return maplist.get(cle);
	}
	public void ajouter(T cle, E element){
		maplist.put(cle, element);
	}
	
	
	public void supprimer(T cle){
		maplist.remove(cle);
	}
	
	public Stockage(){

	}
	
	
	@Override
	public String toString() {
		return "Stockage [maplist=" + maplist + "]";
	}
	
	
	public void enregistrerclientdansfichier(Client client) throws FileNotFoundException, IOException{
		
		Map<String,Client> clientsmap= new HashMap<>();
		clientsmap=lireclientdansfichier();
		clientsmap.put(client.login, client);

		
	    ObjectOutputStream oos=null;
	      oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(FICHIER_STOCKAGE))));


	        try {
	            oos.writeObject(clientsmap);
	
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	      
	      oos.close();

	      
	}
	

	
	public static Map<String,Client>  lireclientdansfichier() throws IOException{
		
				Map<String,Client> clientsmap= new HashMap<>();
				 
				FileInputStream fis=null;
				try {
					fis = new FileInputStream (FICHIER_STOCKAGE);
				} catch (FileNotFoundException e1) {
				}
				ObjectInputStream ois=null;
				try {
					ois = new ObjectInputStream (fis);
					Object objetStocke = ois.readObject ();
					clientsmap=((Map<String,Client>) objetStocke);
					
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
					
				} finally {
					if(ois != null) {
						ois.close();
					}
				}
		        return clientsmap;
	}
	
	
public void enregistrercomptedansfichier(Compte compte) throws FileNotFoundException, IOException{
		
		Map<String,Compte> comptesmap= new HashMap<>();
		comptesmap=lirecomptedansfichier();
		comptesmap.put(compte.getIntitule(), compte);

		
	    ObjectOutputStream oos=null;
	      oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(FICHIER_STOCKAGE_COMPTE))));
	     

	        try {
	            oos.writeObject(comptesmap);

	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	      
	      oos.close();

	      
	}
	

	
	public static Map<String,Compte>  lirecomptedansfichier() throws IOException{
		
				Map<String,Compte> comptesmap= new HashMap<>();
				 
				FileInputStream fis=null;
				try {
					fis = new FileInputStream (FICHIER_STOCKAGE_COMPTE);
				} catch (FileNotFoundException e1) {
				}
				ObjectInputStream ois=null;
				try {
					ois = new ObjectInputStream (fis);
					Object objetStocke = ois.readObject ();
					
					comptesmap=((Map<String,Compte>) objetStocke);
					
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
					
				} finally {
					if(ois != null) {
						ois.close();
					}
				}
		        return comptesmap;
	}
	
}
