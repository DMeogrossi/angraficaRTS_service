package it.sogei.svildep.angraficaRTS.dto;

import it.sogei.svildep.common.dto.SvildepDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RtsPerListaDto extends SvildepDto {
    private String denominazioneRts;
    private UtenteDto direttoreDto;
    private String denominazioneTesoreria;
    private String dataInizio;
    private String dataFine;
}
