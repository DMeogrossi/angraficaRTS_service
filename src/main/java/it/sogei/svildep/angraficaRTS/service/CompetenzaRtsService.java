package it.sogei.svildep.angraficaRTS.service;

import it.sogei.svildep.angraficaRTS.dto.gestioneCompetenzaRts.CompetenzaRtsDto;
import it.sogei.svildep.angraficaRTS.dto.gestioneCompetenzaRts.InsertCompetenzaRtsDto;
import it.sogei.svildep.angraficaRTS.exception.Messages;
import it.sogei.svildep.angraficaRTS.mapper.gestioneCompetenzaRts.CompetenzaRtsPerListaMapper;
import it.sogei.svildep.angraficaRTS.mapper.gestioneCompetenzaRts.InsertCompetenzaMapper;
import it.sogei.svildep.angraficaRTS.repository.CompetenzaRtsRepository;
import it.sogei.svildep.angraficaRTS.repository.RtsRepository;
import it.sogei.svildep.common.dto.ResponseDto;
import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import it.sogei.svildep.common.entity.gestionerts.Rts;
import it.sogei.svildep.common.exception.SvildepException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class CompetenzaRtsService {

    private final CompetenzaRtsRepository competenzaRtsRepository;
    private final CompetenzaRtsPerListaMapper competenzaRtsPerListaMapper;
    private final RtsRepository rtsRepository;
    private final InsertCompetenzaMapper insertCompetenzaMapper;

    public ResponseDto findAllByIdRts(Long id) {
        List<CompetenzaRts> competenzeRts = competenzaRtsRepository.findByRts_id(id);
        List<CompetenzaRtsDto> competenzeDto = competenzaRtsPerListaMapper.mapEntityToDto(competenzeRts);
        return new ResponseDto(competenzeDto);
    }

    @Transactional
    public ResponseDto insertCompetenza(InsertCompetenzaRtsDto insertCompetenzaRtsDto) {
        Rts rts = rtsRepository.findById(Long.parseLong(insertCompetenzaRtsDto.getRtsId()))
                .orElseThrow(() -> new SvildepException(Messages.RtsNonTrovata, HttpStatus.BAD_REQUEST));
        List<CompetenzaRts> competenze = competenzaRtsRepository.findByRts_id(rts.getId());
        for (CompetenzaRts competenza : competenze) {
            if (competenza.getProvincia().getId().equals(Long.parseLong(insertCompetenzaRtsDto.getProvinciaId()))) {
                throw new SvildepException(Messages.competenzaProvincialeGiaPresente, HttpStatus.BAD_REQUEST);
            }
        }
        CompetenzaRts competenzaDaChiudere = competenzaRtsRepository.
                findByProvincia_IdAndDataFineAfter(Long.parseLong(insertCompetenzaRtsDto.getProvinciaId()), LocalDate.now());
       if(competenzaDaChiudere != null) {
           competenzaDaChiudere.setDataFine(LocalDate.now());
           competenzaRtsRepository.save(competenzaDaChiudere);
       }
        competenzaRtsRepository.save(insertCompetenzaMapper.mapDtoToEntity(insertCompetenzaRtsDto));
        return new ResponseDto(Messages.operazioneRiuscita, HttpStatus.OK);

    }
}
