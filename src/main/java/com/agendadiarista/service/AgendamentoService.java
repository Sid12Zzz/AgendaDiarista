package com.agendadiarista.service;

import com.agendadiarista.DTO.AgendamentoRequestDTO;
import com.agendadiarista.DTO.AgendamentoResponseDTO;
import com.agendadiarista.entity.Agendamento;
import com.agendadiarista.entity.Cliente;
import com.agendadiarista.entity.Profissional;
import com.agendadiarista.exceptions.ResourceNotFoundException;
import com.agendadiarista.repository.AgendamentoRepository;
import com.agendadiarista.repository.ClienteRepository;
import com.agendadiarista.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final ProfissionalRepository profissionalRepository;

    public AgendamentoResponseDTO salvar(AgendamentoRequestDTO dto){
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o id: " + dto.getClienteId()));
        Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
                .orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado com o id: " + dto.getProfissionalId()));

        Agendamento agendamento = new Agendamento();
        agendamento.setDataHora(dto.getDataHora());
        agendamento.setCliente(cliente);
        agendamento.setProfissional(profissional);

        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
        return new AgendamentoResponseDTO(agendamentoSalvo);
    }

    public AgendamentoResponseDTO buscarPorId(Long id){
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado com o ID:" + id));

        return new AgendamentoResponseDTO(agendamento);
    }

    public Agendamento encontrarPorId(Long id){
        return agendamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado."));
    }

    public List<AgendamentoResponseDTO> buscarTodos(){
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return agendamentos.stream()
                .map(AgendamentoResponseDTO::new)
                .toList();

        //transforma cada agendamento em um responsedto
    }

    public AgendamentoResponseDTO atualizar(Long id, AgendamentoRequestDTO dto){
        Agendamento agendamentoEncontrado = encontrarPorId(id);

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o id: " + dto.getClienteId()));
        Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
                .orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado com o id: " + dto.getProfissionalId()));


        agendamentoEncontrado.setDataHora(dto.getDataHora());
        agendamentoEncontrado.setCliente(cliente);
        agendamentoEncontrado.setProfissional(profissional);
        Agendamento agendamentoAtualizado = agendamentoRepository.save(agendamentoEncontrado);
        return new AgendamentoResponseDTO(agendamentoAtualizado);
    }

    public void deletar(Long id){
        Agendamento agendamentoEncontrado = encontrarPorId(id);
        agendamentoRepository.delete(agendamentoEncontrado);
    }
}