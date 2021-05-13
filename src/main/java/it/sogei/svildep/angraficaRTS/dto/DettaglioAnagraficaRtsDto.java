package it.sogei.svildep.angraficaRTS.dto;

import it.sogei.svildep.common.dto.SvildepDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class DettaglioAnagraficaRtsDto extends SvildepDto {

    private String denominazioneRts;
    private String denominazioneComune;
    private IndirizzoDto indirizzoDto;
    private List<RecapitoDto> recapiti;
    private String codiceOrdinante;
    private UtenteDto direttoreDto;
    private String denominazioneTesoreria;
    private String dataInizio;
    private String dataFine;
}
