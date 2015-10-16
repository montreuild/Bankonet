package bankonet_stockage;

import java.io.Serializable;

public abstract class  Compte implements CompteStat, Serializable{
	
	private String numero;
	private String intitule;
	private double solde;
	
	
	public Compte(){
	}
	
	public Compte(String numero, String intitule, double solde) {
		this();
		this.numero = numero;
		this.intitule = intitule;
		if(solde < 0)
			{
				System.out.println("Attention solde négatif, corigé à 0");
				this.solde = 0;
			}else
			{
				this.solde = solde;
			}
	}


	public void crediter(double montant) throws CreditException{
		this.solde+=montant;
	}

	public void debiter(double montant) throws DebitException {
		if(montant>debitmax())
		{
			throw new DebitException("Montant supérieur à la limite non autorisé");
		}
		setSolde(getSolde()-montant);
	}

	public String toString() {
		return "CompteCourant [ numero= " + numero + " , intitule= " + intitule + " , solde= " + solde+ " ]";
	}

	public abstract double debitmax();
	
	
	public void effectuervirement(Compte comptebis,double montant) throws DebitException,CreditException{
		this.debiter(montant);
		comptebis.crediter(montant);
	}
	
	
//Getter Setter
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	

	
}

