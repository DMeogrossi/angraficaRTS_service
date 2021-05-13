package it.sogei.svildep.angraficaRTS.dto.gestioneCompetenzaRts;

import it.sogei.svildep.common.dto.SvildepDto;
import it.sogei.svildep.common.validation.annotation.ParsableLong;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
public class InsertCompetenzaRtsDto extends SvildepDto {
    @ParsableLong
    @NotNull
    private String rtsId;
    @ParsableLong
    @NotNull
    private String provinciaId;
}
