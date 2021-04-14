package br.ucsal.gestaoHospitalar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gestaoHospitalar.entity.Medicacao;
import br.ucsal.gestaoHospitalar.repository.MedicacaoRepository;

@Service
@Transactional
public class MedicacaoService {
	@Autowired
    private MedicacaoRepository repo;
	
	public Medicacao  getMedicacao(Long id) {
		return repo.findById(id).get();
	}
	
	public void insert(Medicacao medicacao) {
		repo.save(medicacao);
	}
	
	public void update(Medicacao medicacao) {
		
	}
	
	public void delete(Medicacao medicacao) {
		repo.delete(medicacao);
	}
}
