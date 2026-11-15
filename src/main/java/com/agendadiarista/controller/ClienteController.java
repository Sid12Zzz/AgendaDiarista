package com.agendadiarista.controller;

import com.agendadiarista.DTO.ClienteRequestDTO;
import com.agendadiarista.DTO.ClienteResponseDTO;
import com.agendadiarista.entity.Cliente;
import com.agendadiarista.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clientes")
@RequiredArgsConstructor
@RestController
public class ClienteController {

    private final ClienteService clienteService;

    //----------------------------------------- C R U D --------------------------------------------------------\\

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(@RequestBody @Valid ClienteRequestDTO dadosCliente) {
        Cliente novoCliente = clienteService.salvar(dadosCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteResponseDTO(novoCliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteRequestDTO dadosAtualizados) {
        Cliente cliente = clienteService.atualizar(id, dadosAtualizados);
        return ResponseEntity.ok(new ClienteResponseDTO(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
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
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(new ClienteResponseDTO(cliente));
    }
}