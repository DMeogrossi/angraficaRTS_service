package it.sogei.svildep.angraficaRTS.repository;

import it.sogei.svildep.common.entity.gestioneutenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    public List<Utente> findByRts_Id(Long rtsId);
}
