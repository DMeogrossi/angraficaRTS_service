package it.sogei.svildep.angraficaRTS.dto.gestioneCompetenzaRts;

import it.sogei.svildep.common.dto.SvildepDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CompetenzaRtsDto extends SvildepDto {
    private String denominazioneProvincia;
    private String dataInizio;
    private String dataFine;
}
