package it.sogei.svildep.angraficaRTS.mapper.gestioneCompetenzaRts;

import it.sogei.svildep.angraficaRTS.dto.gestioneCompetenzaRts.InsertCompetenzaRtsDto;
import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestionesoggetti.Provincia;
import it.sogei.svildep.common.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InsertCompetenzaMapper implements Mapper<CompetenzaRts, InsertCompetenzaRtsDto> {
    @Override
    public CompetenzaRts mapDtoToEntityImpl(InsertCompetenzaRtsDto dto) throws RuntimeException {
        return CompetenzaRts.builder()
                .rts(Rts.builder()
                        .id(Long.parseLong(dto.getRtsId()))
                        .build())
                .provincia(Provincia.builder()
                        .id(Long.parseLong(dto.getProvinciaId()))
                        .build())
                .dataInizio(LocalDate.now())
                .dataFine(LocalDate.parse("9999-12-31"))
                .build();

    }

    @Override
    public InsertCompetenzaRtsDto mapEntityToDtoImpl(CompetenzaRts competenzaRts) throws RuntimeException {
        return null;
    }
}
