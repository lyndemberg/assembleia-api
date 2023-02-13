package br.com.softdesign.assembleia.controller;

import br.com.softdesign.assembleia.dto.VotoDto;
import br.com.softdesign.assembleia.service.VotoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/votos")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping
    public ResponseEntity<VotoDto> registrar(@Valid @RequestBody VotoDto votoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(votoService.registrar(votoDto));
    }

}
