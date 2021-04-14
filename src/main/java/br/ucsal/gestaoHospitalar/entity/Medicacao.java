package br.ucsal.gestaoHospitalar.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Medicacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*@OneToMany(cascade=CascadeType.ALL, targetEntity=Medicamento.class)
	@JoinColumn(name="id")
	private Medicamento medicamento;*/
	private float dosagem;
	private LocalDateTime dateTime;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public Medicamento getMedicamento() {
//		return medicamento;
//	}
//	public void setMedicamento(Medicamento medicamento) {
//		this.medicamento = medicamento;
//	}
	public float getDosagem() {
		return dosagem;
	}
	public void setDosagem(float dosagem) {
		this.dosagem = dosagem;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
