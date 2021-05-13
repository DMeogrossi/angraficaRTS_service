package it.sogei.svildep.angraficaRTS.controller;

import it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts.InsertRtsDto;
import it.sogei.svildep.angraficaRTS.dto.gestioneAnagraficaRts.ModificaRtsDto;
import it.sogei.svildep.angraficaRTS.service.AnagraficaRtsService;
import it.sogei.svildep.common.dto.ResponseDto;
import it.sogei.svildep.common.exception.SvildepException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("anagraficaRts")
@RequiredArgsConstructor
@CrossOrigin
public class AnagraficaRtsController {

    private final AnagraficaRtsService anagraficaRtsService;

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> dettaglioAbilitaizone(@Valid @PathVariable("id") String id) throws SvildepException {
        return ResponseEntity.ok().body(anagraficaRtsService.get(Long.parseLong(id)));
    }

    @GetMapping("listaAnagraficaRts")
    public ResponseEntity<ResponseDto> lista() throws SvildepException {
        return ResponseEntity.ok().body(anagraficaRtsService.getAll());
    }

    @PostMapping("nuovaRts")
    public ResponseEntity<ResponseDto> nuovaRts(@Valid @RequestBody InsertRtsDto insertRtsDto,
                                                BindingResult bindingResult) throws SvildepException {

        if (bindingResult.hasErrors()) throw new SvildepException(bindingResult);
        return ResponseEntity.ok().body(anagraficaRtsService.insertRts(insertRtsDto));
    }

    @PutMapping("modificaRts")
    public ResponseEntity<ResponseDto> modificaRts(@Valid @RequestBody ModificaRtsDto modificaRtsDto, BindingResult bindingResult) throws SvildepException {
        if (bindingResult.hasErrors()) throw new SvildepException(bindingResult);
        return ResponseEntity.ok().body(anagraficaRtsService.modificaRts(modificaRtsDto));
    }

    @GetMapping("listaDirettoriRts/{id}")
    public ResponseEntity<ResponseDto> listaDirettoriRts(@Valid @PathVariable("id") String id) throws SvildepException {
        return ResponseEntity.ok().body(anagraficaRtsService.getAllDirettori(Long.parseLong(id)));
    }
    @PutMapping("chiusuraRts/{id}")
    public ResponseEntity<ResponseDto> chiudiRts(@Valid @PathVariable("id") String id) throws SvildepException {
        return ResponseEntity.ok().body(anagraficaRtsService.chiudiRts(Long.parseLong(id)));
    }


}
