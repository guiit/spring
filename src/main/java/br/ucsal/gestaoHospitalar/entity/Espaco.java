package br.ucsal.gestaoHospitalar.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Espaco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected TipoEspaco tipo;
	protected String sala;
	protected Double custo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoEspaco getTipo() {
		return tipo;
	}
	public void setTipo(TipoEspaco tipo) {
		this.tipo = tipo;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		this.custo = custo;
	}
	
	

}
