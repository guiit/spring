package br.ucsal.gestaoHospitalar.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Medicacao {

	private Long id;
	private Medicamento medicamento;
	private float dosagem;
	private LocalDateTime dateTime;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
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
