package com.agendadiarista.controller;

import com.agendadiarista.DTO.ProfissionalRequestDTO;
import com.agendadiarista.DTO.ProfissionalResponseDTO;
import com.agendadiarista.entity.Profissional;
import com.agendadiarista.exceptions.ResourceNotFoundException;
import com.agendadiarista.service.ProfissionalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/profissionais")
@RestController
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalResponseDTO> salvar(@RequestBody @Valid ProfissionalRequestDTO dadosProfissional) {
        Profissional novoProfissional = profissionalService.salvar(dadosProfissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProfissionalResponseDTO(novoProfissional));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid ProfissionalRequestDTO profissional) {
        try {
            Profissional profissionalAtualizado = profissionalService.atualizar(id, profissional);
            return ResponseEntity.ok(new ProfissionalResponseDTO(profissionalAtualizado));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            Profissional profissional = profissionalService.buscarPorId(id);
            return ResponseEntity.ok(new ProfissionalResponseDTO(profissional));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponseDTO>> listarTodos() {
        List<ProfissionalResponseDTO> profissionais = profissionalService.buscarTodos()
                .stream()
                .map(ProfissionalResponseDTO::new)
                .toList();
        return ResponseEntity.ok(profissionais);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            profissionalService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }
}