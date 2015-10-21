package bankonet.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CompteEpargne")
public class CompteEpargne extends Compte{

	@Column(name="TAUXINTERET")
	private double tauxInteret;


	public CompteEpargne(){
	}

	public CompteEpargne(String numero, String intitule, double solde, double tauxInteret) {
		super(numero,intitule,solde);
		this.tauxInteret = tauxInteret;
	}

	public double debitmax(){
		return getSolde();
	};

	public void crediter(double montant) throws CreditException{
		if(this.getSolde()+montant>1600)
		{
			throw new CreditException("Montant supérieur à la limite autorisé");
		}
		setSolde(getSolde()+montant);
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public String toString() {
		return "CompteEpargne [ numero= " + getNumero() + " , intitule= " + getIntitule() + " , solde= " + getSolde()
		+ " , tauxInteret= " + getTauxInteret() + " ]";
	}




}