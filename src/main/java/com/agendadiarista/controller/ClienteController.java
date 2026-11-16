package com.agendadiarista.controller;

import com.agendadiarista.DTO.ClienteRequestDTO;
import com.agendadiarista.DTO.ClienteResponseDTO;
import com.agendadiarista.entity.Cliente;
import com.agendadiarista.exceptions.ResourceNotFoundException;
import com.agendadiarista.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/clientes")
@RequiredArgsConstructor
@RestController
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(@RequestBody @Valid ClienteRequestDTO dadosCliente) {
        Cliente novoCliente = clienteService.salvar(dadosCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteResponseDTO(novoCliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteRequestDTO dadosAtualizados) {
        try {
            Cliente cliente = clienteService.atualizar(id, dadosAtualizados);
            return ResponseEntity.ok(new ClienteResponseDTO(cliente));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            clienteService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> buscarTodos() {
        List<ClienteResponseDTO> clientes = clienteService.buscarTodos()
                .stream()
                .map(ClienteResponseDTO::new)
                .toList();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.buscarPorId(id);
            return ResponseEntity.ok(new ClienteResponseDTO(cliente));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        }
    }
}