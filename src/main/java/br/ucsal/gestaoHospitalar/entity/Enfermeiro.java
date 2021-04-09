package br.ucsal.gestaoHospitalar.entity;

import br.ucsal.gestaoHospitalar.entity.enums.Especialidade;

public class Enfermeiro extends Funcionario{
	private String coren;
	private Especialidade especialidade;

	public String getCoren() {
		return coren;
	}

	public void setCoren(String coren) {
		this.coren = coren;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
}
