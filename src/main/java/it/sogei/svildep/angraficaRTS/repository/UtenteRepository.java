package it.sogei.svildep.angraficaRTS.repository;

import it.sogei.svildep.common.entity.gestioneutenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
