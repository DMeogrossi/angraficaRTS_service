package it.sogei.svildep.angraficaRTS.mapper.gestioneAnagraficaRts;


import it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts.RtsPerListaDto;
import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestionetesorerie.CompetenzaTesoreria;
import org.springframework.stereotype.Component;

@Component

public class ListaRtsMapper {

    public RtsPerListaDto mapEntityToDtoList(Rts rts, CompetenzaTesoreria competenzaTesoreria,
                                             CompetenzaRts competenzaRts,
                                             RtsPerListaDto rtsPerListaDto) throws RuntimeException {

            rtsPerListaDto.setDenominazioneRts(rts.getDenominazioneRTS());
            rtsPerListaDto.setDenominazioneTesoreria(competenzaTesoreria.getTesoreria().getDenominazione());
            rtsPerListaDto.setDataInizio(String.valueOf(competenzaRts.getDataInizio()));
            rtsPerListaDto.setDataFine(String.valueOf(competenzaRts.getDataFine()));
            return rtsPerListaDto;
    }

}
