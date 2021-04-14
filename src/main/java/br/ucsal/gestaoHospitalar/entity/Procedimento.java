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
public abstract class Procedimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected TipoProcedimento tipo;
	protected Funcionario[] funcionario;
//	protected Diagnostico[] diagnostico;
//	protected Espaco[] Espaco;
	protected Date fim;
	protected String cpf;
	protected Date inicio;
	protected String descricao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoProcedimento getTipo() {
		return tipo;
	}
	public void setTipo(TipoProcedimento tipo) {
		this.tipo = tipo;
	}
	public Funcionario[] getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario[] funcionario) {
		this.funcionario = funcionario;
	}
//	public Diagnostico[] getDiagnostico() {
//		return diagnostico;
//	}
//	public void setDiagnostico(Diagnostico[] diagnostico) {
//		this.diagnostico = diagnostico;
//	}
//	public Espaco[] getEspaco() {
//		return Espaco;
//	}
//	public void setEspaco(Espaco[] espaco) {
//		Espaco = espaco;
//	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	


}
