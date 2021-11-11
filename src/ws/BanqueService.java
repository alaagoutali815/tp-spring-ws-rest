package ws;


import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import metier.Compte;

@WebService (serviceName = "BanqueWS")
public class BanqueService {
	
	@WebMethod(operationName = "ConversionEuroToDT")
public double conversion (@WebParam(partName = "montant")  double mt) {
	return mt*3;
}
@WebMethod
public Compte getCompte (@WebParam(partName = "code") int code) {
	return new Compte(code, Math.random()*1000, new Date());
}
@WebMethod
public ArrayList<Compte> listComptes(){
	
	ArrayList<Compte> comptes = new ArrayList<Compte>();
	comptes.add(new Compte(1, Math.random()*1000, new Date()));
	comptes.add(new Compte(2, Math.random()*1000, new Date()));
	comptes.add(new Compte(3, Math.random()*1000, new Date()));
	return comptes;	
}



}
