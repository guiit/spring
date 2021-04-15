package br.ucsal.gestaoHospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gestaoHospitalar.entity.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long>{

}
