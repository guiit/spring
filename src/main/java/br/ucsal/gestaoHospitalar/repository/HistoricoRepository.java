package br.ucsal.gestaoHospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gestaoHospitalar.entity.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {

}
