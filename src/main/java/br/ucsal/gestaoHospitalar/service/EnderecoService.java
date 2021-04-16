package br.ucsal.gestaoHospitalar.service;

import java.util.List;

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
	
	public Endereco  getEndereco(Long id) {
		return respo.findById(id).get();
	}

	public List<Endereco> findAll() {
		return respo.findAll();
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
