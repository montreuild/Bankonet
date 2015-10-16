package bankonet.dto;

public class CompteCourant extends Compte {

	double montantDecouvertAutorise;


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
