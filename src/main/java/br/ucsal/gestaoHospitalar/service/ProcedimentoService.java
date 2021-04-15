package br.ucsal.gestaoHospitalar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ucsal.gestaoHospitalar.entity.Procedimento;
import br.ucsal.gestaoHospitalar.repository.ProcedimentoRepository;

@Service
@Transactional
public class ProcedimentoService {
	@Autowired
    private ProcedimentoRepository repo;
	
	public Procedimento getProcedimento(Long id) {
		return repo.findById(id).get();
	}
	
	
	public void insert(Procedimento procedimento) {
		repo.save(procedimento);
	}
	
	public List<Procedimento> findAll() {
		return repo.findAll();
	}
	
	
	public void update(Procedimento procedimento) {
		
	}
	
	public void delete(Procedimento procedimento) {
		repo.delete(procedimento);
	}
}
