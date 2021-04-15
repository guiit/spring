package br.ucsal.gestaoHospitalar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Historico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Medicamento[] medicamentos;
	Medicacao[] medicacoes;
	String[] efeitosColaterais;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "procedimentoId")
	Procedimento procedimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medicamento[] getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(Medicamento[] medicamentos) {
		this.medicamentos = medicamentos;
	}
	public Medicacao[] getMedicacoes() {
		return medicacoes;
	}
	public void setMedicacoes(Medicacao[] medicacoes) {
		this.medicacoes = medicacoes;
	}
	public String[] getEfeitosColaterais() {
		return efeitosColaterais;
	}
	public void setEfeitosColaterais(String[] efeitosColaterais) {
		this.efeitosColaterais = efeitosColaterais;
	}
//	public Procedimento getProcedimento() {
//		return procedimento;
//	}
//	public void setProcedimento(Procedimento procedimento) {
//		this.procedimento = procedimento;
//	}
	

	
	
}
