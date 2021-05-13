package it.sogei.svildep.angraficaRTS.repository;

import it.sogei.svildep.common.entity.enums.FlagRuolo;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestioneutenti.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuoloRepository extends JpaRepository<Ruolo, Long> {
    public Ruolo findRuoloByCodice(FlagRuolo flagRuolo);
}
