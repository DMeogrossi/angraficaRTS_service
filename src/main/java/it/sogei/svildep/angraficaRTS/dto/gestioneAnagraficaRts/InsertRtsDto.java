package it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts;

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
public class InsertRtsDto extends SvildepDto {
    @NotBlank
    private String denominazioneRts;
    @NotNull
    @ParsableLong
    private String provinciaId;
    @NotNull
    @ParsableLong
    private String comuneId;
    private IndirizzoDto indirizzoDto;
    private List<RecapitoDto> recapitiDto;
    @NotBlank
    private String codiceOrdinante;
    @NotNull
    @ParsableLong
    private String tesoreriaId;
    @NotNull
    @ParsableLong
    private String utenteId;
}
