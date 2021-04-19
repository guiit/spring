package br.ucsal.gestaoHospitalar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ucsal.gestaoHospitalar.entity.Medico;
import br.ucsal.gestaoHospitalar.repository.MedicoRepository;

@Service
@Transactional
public class MedicoService {

	@Autowired
    private MedicoRepository respo;
	
	public Medico  getMedico(Long id) {
		return respo.findById(id).get();
	}
	
	public List<Medico>  findAll() {
		return respo.findAll();
	}
	
	public void insert(Medico medico) {
		respo.save(medico);
	}
	
	public void delete(Medico medico) {
		respo.delete(medico);
	}
}
