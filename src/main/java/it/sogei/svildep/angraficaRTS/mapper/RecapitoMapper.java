package it.sogei.svildep.angraficaRTS.mapper;

import it.sogei.svildep.angraficaRTS.dto.RecapitoDto;
import it.sogei.svildep.angraficaRTS.repository.TipoRecapitoRepository;
import it.sogei.svildep.common.entity.enums.FlagTipoRecapito;
import it.sogei.svildep.common.entity.gestionesoggetti.Recapito;
import it.sogei.svildep.common.entity.gestionesoggetti.TipoRecapito;
import it.sogei.svildep.common.mapper.EntityToDtoMapper;
import it.sogei.svildep.common.mapper.Mapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecapitoMapper implements Mapper<Recapito, RecapitoDto> {

    @Autowired
    public TipoRecapitoRepository tipoRecapitoRepository;

    @Override
    public RecapitoDto mapEntityToDtoImpl(Recapito recapito) throws RuntimeException {
        return RecapitoDto.builder()
                .valoreRecapito(recapito.getValore())
                .codiceTipoRecapito(String.valueOf(recapito.getTipoRecapito().getCodice()))
                .build();

    }

    @Override
    public Recapito mapDtoToEntityImpl(RecapitoDto recapitoDto) throws RuntimeException {
        List<TipoRecapito> tipiRecapito = tipoRecapitoRepository.findAll();
        Recapito recapito = new Recapito();
        if(recapitoDto.getId() != null){
            recapito.setId(Long.parseLong(recapitoDto.getId()));
        }
        recapito.setValore(recapitoDto.getValoreRecapito());
        for (TipoRecapito tipoRecapito : tipiRecapito) {
            if (recapitoDto.getCodiceTipoRecapito().equals(tipoRecapito.getCodice().name())) {
                recapito.setTipoRecapito(tipoRecapito);
            }
        }
        return recapito;

    }
}
