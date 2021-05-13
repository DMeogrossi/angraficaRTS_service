package it.sogei.svildep.angraficaRTS.mapper.gestioneAnagraficaRts;

import it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts.InsertRtsDto;
import it.sogei.svildep.common.entity.enums.FlagSN;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestionesoggetti.Comune;
import it.sogei.svildep.common.entity.gestioneutenti.Utente;
import it.sogei.svildep.common.mapper.DtoToEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
