package it.sogei.svildep.angraficaRTS.controller;

import it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts.InsertRtsDto;
import it.sogei.svildep.angraficaRTS.dto.gestioneCompetenzaRts.InsertCompetenzaRtsDto;
import it.sogei.svildep.angraficaRTS.service.AnagraficaRtsService;
import it.sogei.svildep.angraficaRTS.service.CompetenzaRtsService;
import it.sogei.svildep.common.dto.ResponseDto;
import it.sogei.svildep.common.exception.SvildepException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("competenzaRts")
@RequiredArgsConstructor
@CrossOrigin
public class CompetenzaRtsController {

    private final CompetenzaRtsService competenzaRtsService;

    @GetMapping("listaCompetenze/{id}")
    public ResponseEntity<ResponseDto> listaCompetenze(@Valid @PathVariable("id") String id) throws SvildepException {
        return ResponseEntity.ok().body(competenzaRtsService.findAllByIdRts(Long.parseLong(id)));
    }

    @PostMapping("nuovaCompetenza")
    public ResponseEntity<ResponseDto> nuovaRts(@Valid @RequestBody InsertCompetenzaRtsDto insertCompetenzaRtsDto,
                                                BindingResult bindingResult) throws SvildepException {

        if (bindingResult.hasErrors()) throw new SvildepException(bindingResult);
        return ResponseEntity.ok().body(competenzaRtsService.insertCompetenza(insertCompetenzaRtsDto));
    }}
