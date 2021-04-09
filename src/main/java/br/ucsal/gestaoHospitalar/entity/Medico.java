package br.ucsal.gestaoHospitalar.entity;

import br.ucsal.gestaoHospitalar.entity.enums.Especialidade;

public class Medico {

	private String crm;
	private Especialidade especialidade;
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
}
