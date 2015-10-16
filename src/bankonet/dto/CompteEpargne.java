package bankonet.dto;

public class CompteEpargne extends Compte{

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