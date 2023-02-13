package br.com.softdesign.assembleia.controller;

import br.com.softdesign.assembleia.dto.PautaDto;
import br.com.softdesign.assembleia.service.PautaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    public ResponseEntity<PautaDto> criar(@Valid @RequestBody PautaDto pautaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pautaService.cadastrar(pautaDto));
    }

    @PutMapping("/{internalId}")
    public ResponseEntity<PautaDto> atualizar(@PathVariable String internalId, @RequestBody @Valid PautaDto pautaDto){
        return ResponseEntity.ok(pautaService.atualizar(internalId, pautaDto));
    }

    @GetMapping("/{internalId}")
    public ResponseEntity<PautaDto> recuperar(@PathVariable String internalId){
        return ResponseEntity.ok(pautaService.recuperar(internalId));
    }

    @DeleteMapping("/{internalId}")
    public ResponseEntity<Void> excluir(@PathVariable String internalId){
        pautaService.excluir(internalId);
        return ResponseEntity.ok().build();
    }
}
