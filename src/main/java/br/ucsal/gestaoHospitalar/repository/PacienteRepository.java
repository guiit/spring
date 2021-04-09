package br.ucsal.gestaoHospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gestaoHospitalar.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
