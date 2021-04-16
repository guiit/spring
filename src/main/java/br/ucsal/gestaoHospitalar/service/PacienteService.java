package br.ucsal.gestaoHospitalar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import br.ucsal.gestaoHospitalar.entity.Paciente;
import br.ucsal.gestaoHospitalar.repository.PacienteRepository;

@Service
@Transactional
public class PacienteService {

	@Autowired
    private PacienteRepository respo;

	public List<Paciente> getPacientes() {
		return this.respo.findAll();
	}
	
	public Paciente getPaciente(Long id) {
		return respo.findById(id).get();
	}
	
	public void insert(Paciente paciente) {
		respo.save(paciente);
	}
	
	public void update(Paciente paciente) {
		
	}
	
	public void delete(Paciente paciente) {
		respo.delete(paciente);
	}
}
