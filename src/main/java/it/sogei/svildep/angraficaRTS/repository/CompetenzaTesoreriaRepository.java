package it.sogei.svildep.angraficaRTS.repository;

import it.sogei.svildep.common.entity.gestionetesorerie.CompetenzaTesoreria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CompetenzaTesoreriaRepository extends JpaRepository<CompetenzaTesoreria, Long> {

    public CompetenzaTesoreria findByDataInizioBeforeAndDataFineAfterAndRts_id
            (LocalDate dataInizio, LocalDate dataFine, Long id);

    public CompetenzaTesoreria findByDataFineAfterAndRts_id (LocalDate dataFine, Long id);
}
