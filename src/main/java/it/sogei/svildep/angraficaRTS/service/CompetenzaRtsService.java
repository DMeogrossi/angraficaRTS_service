package it.sogei.svildep.angraficaRTS.service;

import it.sogei.svildep.angraficaRTS.dto.gestioneCompetenzaRts.CompetenzaRtsDto;
import it.sogei.svildep.angraficaRTS.mapper.gestioneCompetenzaRts.CompetenzaRtsPerListaMapper;
import it.sogei.svildep.angraficaRTS.repository.CompetenzaRtsRepository;
import it.sogei.svildep.common.dto.ResponseDto;
import it.sogei.svildep.common.entity.gestionerts.CompetenzaRts;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class CompetenzaRtsService {

    private final CompetenzaRtsRepository competenzaRtsRepository;
    private final CompetenzaRtsPerListaMapper competenzaRtsPerListaMapper;

    public ResponseDto findAllByIdRts(Long id) {
        List<CompetenzaRts> competenzeRts = competenzaRtsRepository.findByRts_id(id);
        List<CompetenzaRtsDto> competenzeDto = competenzaRtsPerListaMapper.mapEntityToDto(competenzeRts);
        return new ResponseDto(competenzeDto);
    }
}
