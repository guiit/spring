package br.ucsal.gestaoHospitalar.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity 
@PrimaryKeyJoinColumn(name="idPessoa")
public class Paciente extends Pessoa{

	
}
