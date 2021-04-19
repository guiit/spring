package br.ucsal.gestaoHospitalar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ucsal.gestaoHospitalar.entity.Enfermeiro;
import br.ucsal.gestaoHospitalar.repository.EnfermeiroRepository;
@Service
@Transactional
public class EnfermeiroService{

	@Autowired
    private EnfermeiroRepository respo;
	
	public Enfermeiro  getEnfermeiro(Long id) {
		return respo.findById(id).get();
	}
	
	public List<Enfermeiro>  findAll() {
		return respo.findAll();
	}
	
	public void insert(Enfermeiro enfermeiro) {
		respo.save(enfermeiro);
	}
	
	public void delete(Enfermeiro enfermeiro) {
		respo.delete(enfermeiro);
	}
}
