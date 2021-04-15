package br.ucsal.gestaoHospitalar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gestaoHospitalar.entity.Historico;
import br.ucsal.gestaoHospitalar.entity.Procedimento;
import br.ucsal.gestaoHospitalar.repository.HistoricoRepository;

@Service
@Transactional
public class HistoricoService {
	@Autowired
    private HistoricoRepository repo;
	
	public Historico  getHistorico(Long id) {
		return repo.findById(id).get();
	}
	
	public void insert(Historico historico) {
		repo.save(historico);
	}
	
	public void update(Historico historico) {
		
	}
	
	public void delete(Historico historico) {
		repo.delete(historico);
	}
	
	public List<Historico> findAll() {
		return repo.findAll();
	}
}
