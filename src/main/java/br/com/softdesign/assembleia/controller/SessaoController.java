package br.com.softdesign.assembleia.controller;

import br.com.softdesign.assembleia.dto.ApuracaoSessaoResponseDto;
import br.com.softdesign.assembleia.dto.SessaoDto;
import br.com.softdesign.assembleia.service.SessaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessoes")
public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping
    public ResponseEntity<SessaoDto> criar(@Valid @RequestBody SessaoDto sessaoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoService.iniciar(sessaoDto));
    }

    @GetMapping("/{internalId}")
    public ResponseEntity<SessaoDto> recuperar(@PathVariable String internalId){
        return ResponseEntity.ok(sessaoService.recuperar(internalId));
    }

    @GetMapping("/apuracao")
    public ResponseEntity<ApuracaoSessaoResponseDto> apuracao(@RequestParam("internalId") String internalId){
        return ResponseEntity.ok(sessaoService.apurarVotos(internalId));
    }


}
