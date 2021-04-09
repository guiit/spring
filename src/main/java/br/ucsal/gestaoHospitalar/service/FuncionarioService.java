package br.ucsal.gestaoHospitalar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ucsal.gestaoHospitalar.entity.Funcionario;
import br.ucsal.gestaoHospitalar.repository.FuncionarioRepository;

@Service
@Transactional
public class FuncionarioService {
	@Autowired
    private FuncionarioRepository respo;
	
	public Funcionario  getPaciente(Long id) {
		return respo.findById(id).get();
	}
	
	public void insert(Funcionario funcionario) {
		respo.save(funcionario);
	}
	
	public void update(Funcionario funcionario) {
		
	}
	
	public void delete(Funcionario funcionario) {
		respo.delete(funcionario);
	}
}
