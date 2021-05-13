package it.sogei.svildep.angraficaRTS.repository;

import it.sogei.svildep.common.entity.gestioneutenti.Abilitazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AbilitazioneRepository extends JpaRepository<Abilitazione, Long> {
    public List<Abilitazione> findByDataFineBeforeAndRuolo_Id
            (LocalDate dataFine, Long ruoloId);
}
