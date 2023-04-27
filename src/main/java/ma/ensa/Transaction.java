package ma.ensa;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	private String ref;
	private String cptDeb;
	private String cptCred;
	private double montant;
	private String type;
	private String date;

	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCptDeb() {
		return cptDeb;
	}
	public void setCptDeb(String cptDeb) {
		this.cptDeb = cptDeb;
	}
	public String getCptCred() {
		return cptCred;
	}
	public void setCptCred(String cptCred) {
		this.cptCred = cptCred;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Transaction(String ref, String cptDeb, String cptCred, double montant) {
		super();
		this.ref = ref;
		this.cptDeb = cptDeb;
		this.cptCred = cptCred;
		this.montant = montant;
		String subDeb = cptDeb.substring(0,3);
		if( subDeb.equals(cptCred.substring(0,3))) 
			this.type = "VARINT";
		else 
			this.type = "VARCHAR";
		
		Date d= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		this.date= sdf.format(d);
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
