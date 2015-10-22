package dto;



public enum Civilite {

	MONSIEUR("Monsieur"),MADAME("Madame"),MADEMOISELLE("Mademoiselle");
	
	
	private String value;
	
	private Civilite(String value) {
		this.value = value;
	}
	
	public String getValue() { return value; }
	
}
