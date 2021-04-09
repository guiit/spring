package br.ucsal.gestaoHospitalar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ucsal.gestaoHospitalar.entity.Endereco;
import br.ucsal.gestaoHospitalar.repository.EnderecoRepository;

@Service
@Transactional
public class EnderecoService {

	@Autowired
    private EnderecoRepository respo;
	
	public Endereco  getPaciente(Long id) {
		return respo.findById(id).get();
	}
	
	public void insert(Endereco endereco) {
		respo.save(endereco);
	}
	
	public void update(Endereco endereco) {
		
	}
	
	public void delete(Endereco endereco) {
		respo.delete(endereco);
	}
}
