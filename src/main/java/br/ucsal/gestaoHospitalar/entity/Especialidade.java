package br.ucsal.gestaoHospitalar.entity;

public enum Especialidade {
	Cirurgião ("Cirurgião"),
	Fisioterapeota ("Fisioterapeota"),
	Psicologo ("Psicologo"),
	Anestegista ("Anestegista");
	
	private String descricao;

	Especialidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
