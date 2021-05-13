package it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts;

import it.sogei.svildep.common.dto.SvildepDto;
import it.sogei.svildep.common.validation.annotation.ParsableLong;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RecapitoDto extends SvildepDto {
    @ParsableLong
    private String id;
    @NotBlank
    private String valoreRecapito;
    @NotBlank
    private String codiceTipoRecapito;
}
