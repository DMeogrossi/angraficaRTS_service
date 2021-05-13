package it.sogei.svildep.angraficaRTS.repository;

import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CompetenzaRtsRepository extends JpaRepository<CompetenzaRts, Long> {

    public CompetenzaRts findByDataInizioBeforeAndDataFineAfterAndRts_Id
            (LocalDate dataInizio, LocalDate dataFine, Long id);
}
