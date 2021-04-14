package br.ucsal.gestaoHospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gestaoHospitalar.entity.Medicacao;

public interface MedicacaoRepository extends JpaRepository<Medicacao, Long> {

}
