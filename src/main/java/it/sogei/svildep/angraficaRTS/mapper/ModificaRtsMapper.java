package it.sogei.svildep.angraficaRTS.mapper;

import it.sogei.svildep.angraficaRTS.dto.ModificaRtsDto;
import it.sogei.svildep.common.entity.enums.FlagSN;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestioneutenti.Utente;
import it.sogei.svildep.common.mapper.DtoToEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ModificaRtsMapper{
    @Autowired
    private RecapitoMapper recapitoMapper;


    public Rts mapDtoToRts(ModificaRtsDto modificaRtsDto, Rts rts) throws RuntimeException {
        rts.setRecapiti(recapitoMapper.mapDtoToEntity(modificaRtsDto.getRecapitiDto()));
        rts.setCodiceOrdinante(modificaRtsDto.getCodiceOrdinante());
        rts.setUtenti(Collections.singletonList(Utente.builder()
                .id(Long.parseLong(modificaRtsDto.getUtenteId()))
                .flagAbilitatoSN(FlagSN.S)
                .build()));
        return rts;
    }
}
