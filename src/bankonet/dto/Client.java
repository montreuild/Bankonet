package bankonet.dto;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.lang.reflect.Field;

@Entity
@Table (name="client")
public class Client implements Serializable{
	
	@Id
	String login;

	@Column(name = "NOM", length = 30, nullable = false, unique = false)
	@ToString (uppercase=true)
	String nom;
	@Column(name = "PRENOM", length = 30, nullable = false, unique = false)
	@ToString
	String prenom;
	@Column(name = "IDENTIFIANT", length = 30, nullable = false, unique = false)
	String identifiant;
	@Column(name = "CIVILITE", length = 30, nullable = false, unique = false)
	Civilite civilite;
	@Transient
	Map<String,Compte> comptesMap;
	@Column(name = "MOTDEPASSE", length = 30, nullable = false, unique = false)
	String mdp;
	
	
	
	public Client(String nom, String prenom, String identifiant, Civilite civilite,	String login,String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.civilite=civilite;
		this.comptesMap= new HashMap<String,Compte>();
		this.login=login;
		this.mdp=mdp;
	}


	
	public Client() {
		this.comptesMap= new HashMap<String,Compte>();
	}



	public double calculerAvoirGlobale(){
		double avoirglobale = 0;
		
		Iterator<Compte> valuesIte = comptesMap.values().iterator();
		while (valuesIte.hasNext()) {
		Compte myCompte = (Compte) valuesIte.next();
			avoirglobale+=myCompte.getSolde();
			}
		
		return avoirglobale;
	}
	
	
	public void creerCompte(Compte compte){
		this.comptesMap.put(compte.getNumero(), compte);
	}
	
	
	public void supprimerCompte(Compte compte){
		this.comptesMap.remove(compte.getNumero());
	}
	
	public Compte retournerCompte(String numero) throws CompteNonTrouveException{
		
		Iterator<Compte> valuesIte = comptesMap.values().iterator();
		while (valuesIte.hasNext()) {
		Compte myCompte = (Compte) valuesIte.next();
			if (myCompte.getNumero()==numero)
				{
					return myCompte;
				}
		}
		throw new CompteNonTrouveException("Aucun compte trouvé pour ce numero.");
	}
	
	
	public void supprimerCompte(String numero)throws CompteNonTrouveException{
		try{
		Compte compteasup=retournerCompte(numero);
		supprimerCompte(compteasup);
		}catch (CompteNonTrouveException e){
			System.out.println(e.getMessage());
		}

	}

	//Getter Setter

	public String getNom() {
		return nom;
	}



	public Civilite getCivilite() {
		return civilite;
	}



	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getIdentifiant() {
		return identifiant;
	}



	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}



	public Map<String, Compte> getComptesMap() {
		return comptesMap;
	}



	public void setComptesMap(Map<String, Compte> comptesMap) {
		this.comptesMap = comptesMap;
	}



	@Override
	public String toString() {
	
		StringBuilder sb=new StringBuilder("Client [");

		
		Field[] fields=Client.class.getDeclaredFields();
		
		for(Field f :fields){
			ToString toStringAnn=f.getAnnotation(ToString.class);
			
			if(toStringAnn!=null)
			{
				sb.append(f.getName());
				sb.append(" : ");
				
				try {
					
						if(toStringAnn.uppercase()){
							sb.append(f.get(this).toString().toUpperCase());
						}else{
							sb.append(f.get(this));
					
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}sb.append(" ");
		}sb.append(" ] ");
		
		
		return sb.toString();

		//return "Client [nom=" + nom + ", prenom=" + prenom + ", identifiant=" + identifiant + ", civilite=" + civilite + ", comptesMap=" + comptesMap + "]";
	}



}