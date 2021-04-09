package br.ucsal.gestaoHospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gestaoHospitalar.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
