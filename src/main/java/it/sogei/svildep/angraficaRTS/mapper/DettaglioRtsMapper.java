package it.sogei.svildep.angraficaRTS.mapper;

import it.sogei.svildep.angraficaRTS.dto.DettaglioAnagraficaRtsDto;
import it.sogei.svildep.common.entity.enums.FlagRuolo;
import it.sogei.svildep.common.entity.enums.FlagSN;
import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestionetesorerie.CompetenzaTesoreria;
import it.sogei.svildep.common.entity.gestioneutenti.Abilitazione;
import it.sogei.svildep.common.entity.gestioneutenti.Utente;
import it.sogei.svildep.common.mapper.EntityToDtoMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
