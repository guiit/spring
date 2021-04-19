package br.ucsal.gestaoHospitalar.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gestaoHospitalar.entity.Espaco;
import br.ucsal.gestaoHospitalar.repository.EspacoRepository;

@Service
@Transactional
public class EspacoService {
	@Autowired
    private EspacoRepository repo;
	
	public Espaco  getEspaco(Long id) {
		return repo.findById(id).get();
	}
	
	public void insert(Espaco espaco) {
		repo.save(espaco);
	}
	
	public void update(Espaco espaco) {
		
	}
	
	public void delete(Espaco espaco) {
		repo.delete(espaco);
	}
	
	public List<Espaco> findAll() {
		return repo.findAll();
	}
}
