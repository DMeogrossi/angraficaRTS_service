package it.sogei.svildep.angraficaRTS.mapper;

import it.sogei.svildep.angraficaRTS.dto.InsertRtsDto;
import it.sogei.svildep.common.entity.gestioneutenti.Abilitazione;
import it.sogei.svildep.common.entity.gestioneutenti.Ruolo;
import it.sogei.svildep.common.entity.gestioneutenti.Utente;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AbilitazioneMapper {

    public Abilitazione mapToAbilitazione(Ruolo ruolo, String utenteId){
        return Abilitazione.builder()
                .ruolo(ruolo)
                .utente(Utente.builder()
                        .id(Long.parseLong(utenteId))
                        .build())
                .dataInizio(LocalDate.now())
                .dataFine(LocalDate.parse("9999-12-31"))
                .build();
    }
}
