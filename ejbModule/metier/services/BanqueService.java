package metier.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.Entity;

import metier.entites.Compte;
import metier.session.IBanqueLocal;

@Stateless
@WebService
public class BanqueService {
	@EJB
	private IBanqueLocal metier;
	@WebMethod
	public void addCompte(@WebParam(name = "solde") Double soldeInitial){
		Compte cp = new Compte(soldeInitial,new Date(), true);
		metier.addCompte(cp);
	}
	@WebMethod
	public List<Compte> listCompte(){
		return metier.getAllComptes();
	}
	@WebMethod
	public Compte consulter(@WebParam(name = "code") Long code) {
		return metier.getCompte(code);
	}
	
	@WebMethod
	public void verser(
			@WebParam(name = "montant")Double mt,
			@WebParam(name = "code") Long code){
		metier.verser(mt, code);
	}
	public void retirer(
			@WebParam(name = "montant")Double mt,
			@WebParam(name = "code") Long code){
		metier.retirer(mt, code);
	}
	public void virement(
			@WebParam(name = "montant")Double mt,
			@WebParam(name = "Cpte1") Long c1,
			@WebParam(name = "Cpte2") Long c2){
		metier.virement(mt, c1, c2);
	}
}
