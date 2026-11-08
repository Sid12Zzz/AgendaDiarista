package com.agendadiarista.controller;

import com.agendadiarista.entity.Profissional;
import com.agendadiarista.service.ProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/profissionais")
@RestController
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    //------------------Crud--------------------------

    @PostMapping
    public ResponseEntity<Profissional> salvar(@RequestBody Profissional profissional){
        Profissional novoprofissional = profissionalService.salvar(profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoprofissional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long id, Profissional profissional){
        Profissional profissionalatualizado = profissionalService.atualizar(id, profissional);
        return ResponseEntity.status(HttpStatus.OK).body(profissionalatualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(profissionalService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> listarTodos(){
        List<Profissional> profissionais= profissionalService.buscarTodos();
        return ResponseEntity.ok(profissionais);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        profissionalService.deletar(id);
        return ResponseEntity.noContent().build();
    }




}
