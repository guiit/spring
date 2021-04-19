package br.ucsal.gestaoHospitalar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gestaoHospitalar.entity.Medicamento;
import br.ucsal.gestaoHospitalar.repository.MedicamentoRepository;

@Service
@Transactional
public class MedicamentoService {
	@Autowired
    private MedicamentoRepository repo;
	
	public Medicamento  getMedicamento(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Medicamento>  findAll() {
		return repo.findAll();
	}
	
	public void insert(Medicamento medicamento) {
		repo.save(medicamento);
	}
	
	public void update(Medicamento medicamento) {
		
	}
	
	public void delete(Medicamento medicamento) {
		repo.delete(medicamento);
	}
}
