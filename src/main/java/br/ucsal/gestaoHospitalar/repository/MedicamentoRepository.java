package br.ucsal.gestaoHospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gestaoHospitalar.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
