package it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts;

import it.sogei.svildep.common.dto.SvildepDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UtenteDto extends SvildepDto {
    private String nome;
    private String cognome;
    private String titoloDirettore;
    private String dataInizio;
    private String dataFine;


}
