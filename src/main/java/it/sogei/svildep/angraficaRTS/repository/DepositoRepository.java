package it.sogei.svildep.angraficaRTS.repository;

import it.sogei.svildep.common.entity.gestionedepositi.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositoRepository extends JpaRepository<Deposito, Long>{
   public List<Deposito> findByRtsCompetente_IdAndRtsCostituzione_Id(Long idRts1, Long idRts);
}
