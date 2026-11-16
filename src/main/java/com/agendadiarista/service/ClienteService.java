package com.agendadiarista.service;

import com.agendadiarista.DTO.ClienteRequestDTO;
import com.agendadiarista.entity.Cliente;
import com.agendadiarista.exceptions.ResourceNotFoundException;
import com.agendadiarista.repository.AgendamentoRepository;
import com.agendadiarista.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(ClienteRequestDTO dadosCliente) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dadosCliente.getNome());
        novoCliente.setTelefone(dadosCliente.getTelefone());
        novoCliente.setEmail(dadosCliente.getEmail());
        novoCliente.setEndereco(dadosCliente.getEndereco());

        return clienteRepository.save(novoCliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID:" + id));
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente atualizar(Long id, ClienteRequestDTO dadosAtualizados) {
        Cliente clienteEncontrado = buscarPorId(id);
        clienteEncontrado.setNome(dadosAtualizados.getNome());
        clienteEncontrado.setEmail(dadosAtualizados.getEmail());
        clienteEncontrado.setTelefone(dadosAtualizados.getTelefone());
        clienteEncontrado.setEndereco(dadosAtualizados.getEndereco());

        return clienteRepository.save(clienteEncontrado);
    }

    @Transactional
    public void deletar(Long id) {
        Cliente clienteEncontrado = buscarPorId(id);

        if (agendamentoRepository.existsByClienteId(id)) {
            throw new IllegalArgumentException("Não é possível excluir o cliente pois existem agendamentos vinculados a ele.");
        }
        clienteRepository.delete(clienteEncontrado);
    }
}