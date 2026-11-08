package com.agendadiarista.service;

import com.agendadiarista.entity.Agendamento;
import com.agendadiarista.exceptions.ResourceNotFoundException;
import com.agendadiarista.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    public Agendamento salvar(Agendamento agendamento){
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento buscarPorId(Long id){
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado com o ID:" + id));
    }

    public List<Agendamento> buscarTodos(){
        return agendamentoRepository.findAll();
    }

    public Agendamento atualizar(Long id, Agendamento dadosAtualizados){
        Agendamento agendamentoEncontrado = buscarPorId(id);
        agendamentoEncontrado.setDataHora(dadosAtualizados.getDataHora());
        agendamentoEncontrado.setStatusPagamento(dadosAtualizados.getStatusPagamento());
        agendamentoEncontrado.setCliente(dadosAtualizados.getCliente());
        agendamentoEncontrado.setProfissional(dadosAtualizados.getProfissional());

        return agendamentoRepository.save(agendamentoEncontrado);
    }

    public void deletar(Long id){
        Agendamento agendamentoEncontrado = buscarPorId(id);
        agendamentoRepository.delete(agendamentoEncontrado);
    }
}