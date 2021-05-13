package it.sogei.svildep.angraficaRTS.mapper;

import it.sogei.svildep.angraficaRTS.dto.UtenteDto;
import it.sogei.svildep.common.entity.gestioneutenti.Abilitazione;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DirettoreMapper {

    public UtenteDto convertToDto(Abilitazione abilitazione) {
        return UtenteDto.builder()
                .id(String.valueOf(abilitazione.getUtente().getId()))
                .nome(abilitazione.getUtente().getNome())
                .cognome(abilitazione.getUtente().getCognome())
                .titoloDirettore(abilitazione.getUtente().getTitolo().getDescrizione())
                .dataInizio(String.valueOf(abilitazione.getDataInizio()))
                .dataFine(String.valueOf(abilitazione.getDataFine()))
                .build();
    }
}
