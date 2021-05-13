package it.sogei.svildep.angraficaRTS.mapper.gestioneAnagraficaRts;

import it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts.IndirizzoDto;
import it.sogei.svildep.common.entity.gestionesoggetti.Indirizzo;

import it.sogei.svildep.common.mapper.Mapper;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class IndirizzoMapper implements Mapper<Indirizzo, IndirizzoDto> {


    @Override
    public IndirizzoDto mapEntityToDtoImpl(Indirizzo indirizzo) throws RuntimeException {
        return IndirizzoDto.builder()
                .indirizzo(indirizzo.getIndirizzo())
                .civico(indirizzo.getCivico())
                .cap(indirizzo.getCap())
                .build();
    }

    @Override
    public Indirizzo mapDtoToEntityImpl(IndirizzoDto indirizzoDto) throws RuntimeException {
        Indirizzo indirizzo = new Indirizzo();
        if(indirizzoDto.getId() != null){
            indirizzo.setId(Long.parseLong(indirizzoDto.getId()));
        }
        indirizzo.setIndirizzo(indirizzoDto.getIndirizzo());
        indirizzo.setCivico(indirizzoDto.getCivico());
        indirizzo.setCap(indirizzoDto.getCap());
        return indirizzo;

    }
}
