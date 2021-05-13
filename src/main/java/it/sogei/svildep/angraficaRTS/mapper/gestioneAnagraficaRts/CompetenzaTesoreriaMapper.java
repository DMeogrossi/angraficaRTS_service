package it.sogei.svildep.angraficaRTS.mapper.gestioneAnagraficaRts;

import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestionetesorerie.CompetenzaTesoreria;
import it.sogei.svildep.common.entity.gestionetesorerie.Tesoreria;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CompetenzaTesoreriaMapper {
    public CompetenzaTesoreria mapToCompetenzaTesoreria(String tesoreriaId, Rts rts) {
        return CompetenzaTesoreria.builder()
                .tesoreria(Tesoreria.builder()
                        .id(Long.parseLong(tesoreriaId))
                        .build())
                .dataInizio(LocalDate.now())
                .dataFine(LocalDate.parse("9999-12-31"))
                .rts(rts)
                .build();

    }
}
