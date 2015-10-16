package bankonet.dao;

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

import bankonet.dto.Compte;
import bankonet.metier.*;

public class CompteDaoFile implements CompteDao {

	private static final String FICHIER_STOCKAGE_COMPTE = "fichiercompte.txt";
	
	@Override
	public void saveClient(Compte compte) {
		Map<String,Compte> comptesmap= new HashMap<>();
		comptesmap=lirecomptedansfichier();
		comptesmap.put(compte.getIntitule(), compte);

		
	    ObjectOutputStream oos=null;
	      try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(FICHIER_STOCKAGE_COMPTE))));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     

	        try {
	            oos.writeObject(comptesmap);

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
	
	public static Map<String,Compte>  lirecomptedansfichier(){
		
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
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        return comptesmap;
}

}
