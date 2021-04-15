package br.ucsal.gestaoHospitalar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ucsal.gestaoHospitalar.entity.Procedimento;
import br.ucsal.gestaoHospitalar.repository.ProcedimentoRepository;

@Service
@Transactional
public class ProcedimentoService {
	@Autowired
    private ProcedimentoRepository respo;
	
	public Procedimento getProcedimento(Long id) {
		return respo.findById(id).get();
	}
	
	public void insert(Procedimento procedimento) {
		respo.save(procedimento);
	}
	
	public void update(Procedimento procedimento) {
		
	}
	
	public void delete(Procedimento procedimento) {
		respo.delete(procedimento);
	}
}
