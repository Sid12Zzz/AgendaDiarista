package com.agendadiarista.service;

import com.agendadiarista.entity.Cliente;
import com.agendadiarista.exceptions.ResourceNotFoundException;
import com.agendadiarista.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID:" + id));
                //exceção de recurso nao encontrado
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente atualizar(Long id, Cliente dadosAtualizados){
        Cliente clienteEncontrado = buscarPorId(id);
        clienteEncontrado.setNome(dadosAtualizados.getNome());
        clienteEncontrado.setEmail(dadosAtualizados.getEmail());
        clienteEncontrado.setTelefone(dadosAtualizados.getTelefone());
        clienteEncontrado.setEndereco(dadosAtualizados.getEndereco());

        return clienteRepository.save(clienteEncontrado);
    }

    public void deletar(Long id){
        Cliente clienteEncontrado = buscarPorId(id);
        clienteRepository.delete(clienteEncontrado);
    }
}

