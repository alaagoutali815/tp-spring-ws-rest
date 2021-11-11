package metier;


import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement (name= "compte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {
@XmlAttribute
private int code;
@XmlElement
private double solde;
@XmlTransient
private Date dateCreation;

public Compte(int code, double solde, Date dateCreation) {
	super();
	this.code = code;
	this.solde = solde;
	this.dateCreation = dateCreation;
}

public double getSolde() {
	return solde;
}

public void setSolde(double solde) {
	this.solde = solde;
}

public Date getDateCreation() {
	return dateCreation;
}

public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}

public int getCode() {
	return code;
}

public void setCode(int code) {
	this.code = code;
}

public Compte() {
	super();
	// TODO Auto-generated constructor stub
}


}
