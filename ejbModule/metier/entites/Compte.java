package metier.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "COMPTES")
public class Compte implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODE")
	private Long code;
	@Column(name = "SOLDE")
	private Double Solde;
	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	private boolean active;
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public Double getSolde() {
		return Solde;
	}
	public void setSolde(Double solde) {
		Solde = solde;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Compte() {
		super();
	}
	public Compte(Double solde, Date dateCreation, boolean active) {
		super();
		Solde = solde;
		this.dateCreation = dateCreation;
		this.active = active;
	}
	
	
	
}
