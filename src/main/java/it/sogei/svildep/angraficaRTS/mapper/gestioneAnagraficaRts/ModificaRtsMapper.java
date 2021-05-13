package it.sogei.svildep.angraficaRTS.mapper.gestioneAnagraficaRts;

import it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts.ModificaRtsDto;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModificaRtsMapper{
    @Autowired
    private RecapitoMapper recapitoMapper;




    public Rts mapDtoToRts(ModificaRtsDto modificaRtsDto, Rts rts) throws RuntimeException {
        rts.setRecapiti(recapitoMapper.mapDtoToEntity(modificaRtsDto.getRecapitiDto()));
        rts.setCodiceOrdinante(modificaRtsDto.getCodiceOrdinante());

        return rts;
    }
}
