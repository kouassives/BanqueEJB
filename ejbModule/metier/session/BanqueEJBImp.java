package metier.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entites.Compte;

@Stateless(name = "BK")
public class BanqueEJBImp implements IBanqueLocal,IBanqueRemote{
	@PersistenceContext(unitName = "UP_BANQUE")
	private EntityManager em;
	@Override
	public void addCompte(Compte c) {
		em.persist(c);
	}

	@Override
	public List<Compte> getAllComptes() {
		Query rq= em.createQuery("SELECT c FROM Compte c");
		return rq.getResultList();
	}

	@Override
	public Compte getCompte(Long code) {
		Compte cp = em.find(Compte.class, code);
		if (cp==null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(Double mt, Long code) {
		Compte cp= getCompte(code);
		cp.setSolde(cp.getSolde()+mt);
		em.persist(cp);
	}

	@Override
	public void retirer(Double mt, Long code) {
		Compte c=getCompte(code);
		if((c.getSolde()-mt)>0)
		c.setSolde(c.getSolde()-mt);
		System.out.print("Solde Insuffisant Pour ce retrait");
	}

	@Override
	public void virement(Double mt, Long cpte1, Long cpte2) {
		retirer(mt, cpte1);
		verser(mt, cpte2);
	}

	@Override
	public void update(Compte cpte) {
		em.merge(cpte);
	}

	@Override
	public void supprimer(Long code) {
		em.remove(getCompte(code));
	}


}
