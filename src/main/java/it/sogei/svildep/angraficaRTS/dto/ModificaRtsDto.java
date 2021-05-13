package it.sogei.svildep.angraficaRTS.dto;

import it.sogei.svildep.common.dto.SvildepDto;
import it.sogei.svildep.common.validation.annotation.ParsableLong;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ModificaRtsDto extends SvildepDto {
    @ParsableLong
    @NotNull
    private String rtsId;
    private List<RecapitoDto> recapitiDto;
    @NotBlank
    private String codiceOrdinante;
    @ParsableLong
    @NotNull
    private String tesoreriaId;
    @ParsableLong
    @NotNull
    private String utenteId;
}
