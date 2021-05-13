package it.sogei.svildep.angraficaRTS.mapper;

import it.sogei.svildep.angraficaRTS.dto.InsertRtsDto;
import it.sogei.svildep.common.entity.enums.FlagSN;
import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestionesoggetti.Comune;
import it.sogei.svildep.common.entity.gestionesoggetti.Indirizzo;
import it.sogei.svildep.common.entity.gestionesoggetti.Provincia;
import it.sogei.svildep.common.entity.gestioneutenti.Utente;
import it.sogei.svildep.common.exception.SvildepException;
import it.sogei.svildep.common.mapper.DtoToEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class InsertRtsMapper implements DtoToEntityMapper<Rts, InsertRtsDto> {
@Autowired
public RecapitoMapper recapitoMapper;
    @Override
    public Rts mapDtoToEntityImpl(InsertRtsDto dto) throws RuntimeException {
       return  Rts.builder()
                .denominazioneRTS(dto.getDenominazioneRts())
                .comune(Comune.builder()
                        .id(Long.parseLong(dto.getComuneId()))
                        .build())
                .codiceOrdinante(dto.getCodiceOrdinante())
                .utenti(Collections.singletonList(Utente.builder()
                        .id(Long.parseLong(dto.getUtenteId()))
                        .flagAbilitatoSN(FlagSN.S)
                        .build()))
                .build();


    }


}
