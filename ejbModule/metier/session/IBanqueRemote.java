package metier.session;

import java.util.List;

import javax.ejb.Remote;

import metier.entites.Compte;

@Remote
public interface IBanqueRemote {
	public void addCompte(Compte c);
	public List<Compte> getAllComptes();
	public Compte getCompte(Long code);
	public void verser(Double mt, Long code);
	public void retirer(Double mt, Long code);
	public void virement(Double mt, Long cpte1, Long cpte2);
	public void update(Compte cpte);
	public void supprimer(Long Code);

}
