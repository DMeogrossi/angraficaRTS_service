package it.sogei.svildep.angraficaRTS.mapper.gestioneAnagraficaRts;

import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestionesoggetti.Provincia;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CompetenzaRtsMapper {

    public CompetenzaRts mapToCompetenzaRts(String provinciaId, Rts rts){
        return CompetenzaRts.builder()
                .provincia(Provincia.builder()
                        .id(Long.parseLong(provinciaId))
                        .build())
                .dataInizio(LocalDate.now())
                .dataFine(LocalDate.parse("9999-12-31"))
                .rts(rts)
          .build();
    }
}
