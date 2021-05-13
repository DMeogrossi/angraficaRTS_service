package it.sogei.svildep.angraficaRTS.mapper.gestioneCompetenzaRts;

import it.sogei.svildep.angraficaRTS.dto.gestioneCompetenzaRts.CompetenzaRtsDto;
import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import it.sogei.svildep.common.mapper.EntityToDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class CompetenzaRtsPerListaMapper implements EntityToDtoMapper<CompetenzaRts, CompetenzaRtsDto> {

    @Override
    public CompetenzaRtsDto mapEntityToDtoImpl(CompetenzaRts competenzaRts) throws RuntimeException {
        return CompetenzaRtsDto.builder()
                .denominazioneProvincia(competenzaRts.getProvincia().getDenominazioneProvincia())
                .dataInizio(String.valueOf(competenzaRts.getDataInizio()))
                .dataFine(String.valueOf(competenzaRts.getDataFine()))
                .build();
    }
}
