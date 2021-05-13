package it.sogei.svildep.angraficaRTS.mapper;

import it.sogei.svildep.angraficaRTS.dto.UtenteDto;
import it.sogei.svildep.common.entity.gestioneutenti.Utente;
import it.sogei.svildep.common.mapper.EntityToDtoMapper;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class UtenteMapper implements EntityToDtoMapper<Utente, UtenteDto> {
    @Override
    public UtenteDto mapEntityToDtoImpl(Utente utente) throws RuntimeException {
        return UtenteDto.builder()
                .nome(utente.getNome())
                .cognome(utente.getCognome())
                .titoloDirettore(utente.getTitolo().getDescrizione())
                .build();
    }
}
