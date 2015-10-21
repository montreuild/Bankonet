package bankonet.dto;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;


@Entity
@DiscriminatorValue("CompteCourant")
public class CompteCourant extends Compte {

	@Column(name="MONTANTDECOUVERT")
	private double montantDecouvertAutorise;

	
	public CompteCourant() {
	}

	public CompteCourant(String numero, String intitule, double solde, double montantDecouvertAutorise) {
		super(numero,intitule,solde);
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}

	
	public String toString() {
		return "CompteCourant [ numero= " + getNumero() + " , intitule= " + getIntitule() + " , solde= " + getSolde()
				+ " , montantDecouvertAutorise= " + getMontantDecouvertAutorise() + " ]";
	}
	
	public double debitmax(){
		return getSolde()-getMontantDecouvertAutorise();
	};
	
	
	
//Getter Setter
	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}

	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}

	
	
	
}
