package dto;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

	@Test
	public void testretournerCompte() {
			Client client=new Client();
			client.creerCompte(new CompteCourant("CC01","Borise", 0.0d, 0.0d));
			try{
				client.retournerCompte("CC01");
				
			}
			catch(CompteNonTrouveException e){
				Assert.fail("CompteNonTrouveException attendu");
			}		
			
	}
	
	@Test
	public void testretournerCompteavecnumeroinconnu() {
			Client client=new Client();
			client.creerCompte(new CompteCourant("CC01","Borise", 0.0d, 0.0d));
			try{
				client.retournerCompte("CC02");
				Assert.fail("CompteNonTrouveException attendu");
			}
			catch(CompteNonTrouveException e){
				//ok
			}		
			
	}
}
