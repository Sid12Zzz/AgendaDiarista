package com.agendadiarista.controller;

import com.agendadiarista.DTO.AgendamentoRequestDTO;
import com.agendadiarista.DTO.AgendamentoResponseDTO;
import com.agendadiarista.entity.Agendamento;
import com.agendadiarista.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/agendamentos")
@RestController
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    //------------------ C R U D --------------------------

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> salvar(@RequestBody @Valid AgendamentoRequestDTO dto){
        AgendamentoResponseDTO response = agendamentoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AgendamentoRequestDTO dto){
        AgendamentoResponseDTO response = agendamentoService.atualizar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> buscarPorId(@PathVariable Long id){
        AgendamentoResponseDTO response = agendamentoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> listarTodos(){
        List<AgendamentoResponseDTO> agendamentos = agendamentoService.buscarTodos();
        return ResponseEntity.ok(agendamentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        agendamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}