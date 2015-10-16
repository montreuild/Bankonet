package bankonet.dto;

public interface CompteStat{
	
	public double getSolde();
	public void debiter(double montant) throws DebitException;
	public void effectuervirement(Compte client,double montant)throws DebitException,CreditException;

}
