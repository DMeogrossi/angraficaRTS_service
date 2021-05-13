package it.sogei.svildep.angraficaRTS.service;

import it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts.*;
import it.sogei.svildep.angraficaRTS.exception.Messages;
import it.sogei.svildep.angraficaRTS.mapper.gestioneAnagraficaRts.*;
import it.sogei.svildep.angraficaRTS.repository.*;
import it.sogei.svildep.common.dto.ResponseDto;
import it.sogei.svildep.common.entity.enums.FlagRuolo;
import it.sogei.svildep.common.entity.enums.FlagSN;
import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.entity.gestionesoggetti.Indirizzo;
import it.sogei.svildep.common.entity.gestionesoggetti.Recapito;
import it.sogei.svildep.common.entity.gestionetesorerie.CompetenzaTesoreria;
import it.sogei.svildep.common.entity.gestioneutenti.Abilitazione;
import it.sogei.svildep.common.entity.gestioneutenti.Ruolo;
import it.sogei.svildep.common.entity.gestioneutenti.Utente;
import it.sogei.svildep.common.exception.SvildepException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Getter
@RequiredArgsConstructor
public class AnagraficaRtsService {

    private final AnagraficaRtsRepository anagraficaRtsRepository;
    private final CompetenzaRtsRepository competenzaRtsRepository;
    private final CompetenzaTesoreriaRepository competenzaTesoreriaRepository;
    private final DettaglioRtsMapper dettaglioRtsMapper;
    private final UtenteMapper utenteMapper;
    private final ListaRtsMapper listaRtsMapper;
    private final InsertRtsMapper insertRtsMapper;
    private final CompetenzaRtsMapper competenzaRtsMapper;
    private final CompetenzaTesoreriaMapper competenzaTesoreriaMapper;
    private final InsertAbilitazioneMapper insertAbilitazioneMapper;
    private final RuoloRepository ruoloRepository;
    private final AbilitazioneRepository abilitazioneRepository;
    private final IndirizzoMapper indirizzoMapper;
    private final IndirizzoRepository indirizzoRepository;
    private final RecapitoMapper recapitoMapper;
    private final RecapitoRepository recapitoRepository;
    private final ModificaRtsMapper modificaRtsMapper;
    private final UtenteRepository utenteRepository;
    private final DirettoreMapper direttoreMapper;


    public ResponseDto get(Long id) {
        CompetenzaTesoreria competenzaTesoreria = competenzaTesoreriaRepository.
                findByDataInizioBeforeAndDataFineAfterAndRts_id(LocalDate.now(), LocalDate.now(), id);
        CompetenzaRts competenzaRts = competenzaRtsRepository.
                findByDataInizioBeforeAndDataFineAfterAndRts_Id(LocalDate.now(), LocalDate.now(), id);
        Rts rts = anagraficaRtsRepository.findById(id)
                .orElseThrow(() -> new SvildepException(Messages.RtsNonTrovata, HttpStatus.BAD_REQUEST));
        DettaglioAnagraficaRtsDto dettaglioAnagraficaRtsDto = new DettaglioAnagraficaRtsDto();
        for (Utente utente : rts.getUtenti()) {
            if (utente.getFlagAbilitatoSN().equals(FlagSN.S)) {
                for (Abilitazione utenteAbilitato : utente.getAbilitazioni()) {
                    if (utenteAbilitato.getRuolo().getCodice().equals(FlagRuolo.RRD)) {
                        dettaglioAnagraficaRtsDto.setDirettoreDto(utenteMapper.mapEntityToDto(utente));
                    }
                }

            }

        }

        return new ResponseDto(dettaglioRtsMapper.mapToDettaglioAnagraficaRtsDto(rts, competenzaTesoreria, competenzaRts, dettaglioAnagraficaRtsDto));
    }


    public ResponseDto getAll() {
        List<Rts> listaAnagraficaRts = anagraficaRtsRepository.findAll();
        RtsPerListaDto rtsDto = new RtsPerListaDto();
        List<RtsPerListaDto> listaRtsDto = new ArrayList<>();

//        listaAnagraficaRts.forEach(anag -> anag.getUtenti()
//                .stream()
//                .filter(utente -> utente.getFlagAbilitatoSN().equals(FlagSN.S))
//                .forEach(utente -> utente.getAbilitazioni()
//                        .stream()
//                        .filter(utenteAbilitato -> utenteAbilitato.getRuolo().getCodice().equals(FlagRuolo.RRD))
//                        .forEach(utenteAbilitato -> rtsDto.setDirettoreDto(utenteMapper.mapEntityToDto(utente)))
//                )
//        );

        for (Rts rts : listaAnagraficaRts) {
            for (Utente utente : rts.getUtenti()) {
                if (utente.getFlagAbilitatoSN().equals(FlagSN.S)) {
                    for (Abilitazione utenteAbilitato : utente.getAbilitazioni()) {
                        if (utenteAbilitato.getRuolo().getCodice().equals(FlagRuolo.RRD)) {
                            rtsDto.setDirettoreDto(utenteMapper.mapEntityToDto(utente));
                        }
                    }
                }
            }
            CompetenzaTesoreria competenzaTesoreria = competenzaTesoreriaRepository.
                    findByDataInizioBeforeAndDataFineAfterAndRts_id(LocalDate.now(), LocalDate.now(), rts.getId());
            CompetenzaRts competenzaRts = competenzaRtsRepository.
                    findByDataInizioBeforeAndDataFineAfterAndRts_Id(LocalDate.now(), LocalDate.now(), rts.getId());
            if (competenzaTesoreria != null && competenzaRts != null) {
                listaRtsDto.add(listaRtsMapper.mapEntityToDtoList(rts, competenzaTesoreria, competenzaRts, rtsDto));
            }
        }
        return new ResponseDto(listaRtsDto);
    }

    @Transactional
    public ResponseDto insertRts(InsertRtsDto insertRtsDto) throws SvildepException {
        List<Rts> listRts = anagraficaRtsRepository.findAll();
        for (Rts rts : listRts) {
            if (rts.getDenominazioneRTS().equals(insertRtsDto.getDenominazioneRts())) {
                throw new SvildepException(Messages.denominazioneRtsEsistente, HttpStatus.BAD_REQUEST);
            }
        }
        Rts rts = insertRtsMapper.mapDtoToEntity(insertRtsDto);
        Indirizzo indirizzo = indirizzoMapper.mapDtoToEntity(insertRtsDto.getIndirizzoDto());
        rts.setIndirizzo(indirizzoRepository.saveAndFlush(indirizzo));
        List<Recapito> recapiti = recapitoMapper.mapDtoToEntity(insertRtsDto.getRecapitiDto());
        anagraficaRtsRepository.saveAndFlush(rts);
        Utente utente = utenteRepository.findById(Long.parseLong(insertRtsDto.getUtenteId())).
                orElseThrow(()-> new SvildepException(Messages.utenteInesistente, HttpStatus.BAD_REQUEST));
        utente.setRts(rts);

        competenzaRtsRepository.save(competenzaRtsMapper.mapToCompetenzaRts(insertRtsDto.getProvinciaId(), rts));
        competenzaTesoreriaRepository.save(competenzaTesoreriaMapper.mapToCompetenzaTesoreria(insertRtsDto.getTesoreriaId(), rts));
        Ruolo ruolo = ruoloRepository.findRuoloByCodice(FlagRuolo.RRD);
        abilitazioneRepository.save(insertAbilitazioneMapper.mapToAbilitazione(ruolo, insertRtsDto.getUtenteId()));
        return new ResponseDto(Messages.operazioneRiuscita, HttpStatus.OK);
    }

    @Transactional
    public ResponseDto modificaRts(ModificaRtsDto modificaRtsDto) throws SvildepException{
        Rts rts = anagraficaRtsRepository.findById(Long.parseLong(modificaRtsDto.getRtsId())).
                orElseThrow(() -> new SvildepException(Messages.RtsNonTrovata, HttpStatus.BAD_REQUEST));
        chiusuraTesoreria(rts);
        competenzaTesoreriaRepository.save(competenzaTesoreriaMapper.mapToCompetenzaTesoreria(modificaRtsDto.getTesoreriaId(), rts));
        Ruolo ruolo = ruoloRepository.findRuoloByCodice(FlagRuolo.RRD);
        chiusuraAbilitazioneUtente(rts, ruolo.getId());
        abilitazioneRepository.save(insertAbilitazioneMapper.mapToAbilitazione(ruolo, modificaRtsDto.getUtenteId()));

        rts = modificaRtsMapper.mapDtoToRts(modificaRtsDto, rts);
        List<Utente> utenti = rts.getUtenti();
        Utente utente = utenteRepository.findById(Long.parseLong(modificaRtsDto.getUtenteId()))
                .orElseThrow(()-> new SvildepException(Messages.utenteInesistente, HttpStatus.BAD_REQUEST));
        utente.setRts(rts);
        utente.setFlagAbilitatoSN(FlagSN.S);
        utenti.add(utente);
        rts.setUtenti(utenti);
        for (Recapito recapito : rts.getRecapiti()) {
            recapito.setRts(rts);
            recapitoRepository.save(recapito);
        }
        anagraficaRtsRepository.saveAndFlush(rts);

        return new ResponseDto(Messages.operazioneRiuscita, HttpStatus.OK);

    }

    public void chiusuraAbilitazioneUtente(Rts rts, Long idRuolo) {
        List<Abilitazione> abilitazioni = abilitazioneRepository.findByDataFineBeforeAndRuolo_Id(LocalDate.now(), idRuolo);
        for (Abilitazione abilitazione : abilitazioni) {
            for (Utente utente : rts.getUtenti()) {
                if (abilitazione.getUtente().equals(utente)) {
                    abilitazione.setDataFine(LocalDate.now());
                    utente.setFlagAbilitatoSN(FlagSN.N);
                }
            }
        }
    }

    public void chiusuraTesoreria(Rts rts) {
        CompetenzaTesoreria competenzaTesoreria =
                competenzaTesoreriaRepository.findByDataFineAfterAndRts_id(LocalDate.now(), rts.getId());
        competenzaTesoreria.setDataFine(LocalDate.now());
    }

    public ResponseDto getAllDirettori(Long id) throws SvildepException {
        Rts rts = anagraficaRtsRepository.findById(id).orElseThrow(() ->
                new SvildepException(Messages.RtsNonTrovata, HttpStatus.BAD_REQUEST));
        List<UtenteDto> direttori = new ArrayList<>();
        Ruolo ruolo = ruoloRepository.findRuoloByCodice(FlagRuolo.RRD);
        List<Abilitazione> abilitazioni = abilitazioneRepository.findByRuolo_Id(ruolo.getId());
        for(Abilitazione abilitazione : abilitazioni){
            if(abilitazione.getUtente().getRts().getId().equals(rts.getId())) {
                direttori.add(direttoreMapper.convertToDto(abilitazione));
            }
        }
        return new ResponseDto(direttori);

    }
}