package com.agendadiarista.controller;

import com.agendadiarista.entity.Agendamento;
import com.agendadiarista.service.AgendamentoService;
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
    public ResponseEntity<Agendamento> salvar(@RequestBody Agendamento agendamento){
        Agendamento novoAgendamento = agendamentoService.salvar(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody Agendamento agendamento){
        Agendamento agendamentoAtualizado = agendamentoService.atualizar(id, agendamento);
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(agendamentoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarTodos(){
        List<Agendamento> agendamentos = agendamentoService.buscarTodos();
        return ResponseEntity.ok(agendamentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        agendamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}