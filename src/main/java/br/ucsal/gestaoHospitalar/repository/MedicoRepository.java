package br.ucsal.gestaoHospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gestaoHospitalar.entity.Medicacao;
import br.ucsal.gestaoHospitalar.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
