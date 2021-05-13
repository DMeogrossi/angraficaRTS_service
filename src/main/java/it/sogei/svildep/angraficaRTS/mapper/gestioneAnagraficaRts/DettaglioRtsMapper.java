package it.sogei.svildep.angraficaRTS.mapper.gestioneAnagraficaRts;

import it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts.DettaglioAnagraficaRtsDto;
import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestionetesorerie.CompetenzaTesoreria;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DettaglioRtsMapper {
    @Autowired
    public IndirizzoMapper indirizzoMapper;

    @Autowired
    public RecapitoMapper recapitoMapper;

    @Autowired
    public UtenteMapper utenteMapper;

    public DettaglioAnagraficaRtsDto mapToDettaglioAnagraficaRtsDto(Rts rts, CompetenzaTesoreria competenzaTesoreria,
                                                                    CompetenzaRts competenzaRts,
                                                                    DettaglioAnagraficaRtsDto dettaglioAnagraficaRtsDto) throws RuntimeException {

        dettaglioAnagraficaRtsDto.setDenominazioneRts(rts.getDenominazioneRTS());
        dettaglioAnagraficaRtsDto.setDenominazioneComune(rts.getComune().getDenominazioneComune());
        dettaglioAnagraficaRtsDto.setIndirizzoDto(indirizzoMapper.mapEntityToDto(rts.getIndirizzo()));
        dettaglioAnagraficaRtsDto.setRecapiti(recapitoMapper.mapEntityToDto(rts.getRecapiti()));
        dettaglioAnagraficaRtsDto.setCodiceOrdinante(rts.getCodiceOrdinante());
        dettaglioAnagraficaRtsDto.setDataInizio(String.valueOf(competenzaRts.getDataInizio()));
        dettaglioAnagraficaRtsDto.setDataFine(String.valueOf(competenzaRts.getDataFine()));
        dettaglioAnagraficaRtsDto.setDenominazioneTesoreria(competenzaTesoreria.getTesoreria().getDenominazione());
        return dettaglioAnagraficaRtsDto;
    }

}
