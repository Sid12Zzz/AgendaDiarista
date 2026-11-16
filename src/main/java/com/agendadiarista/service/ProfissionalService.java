package com.agendadiarista.service;

import com.agendadiarista.DTO.ProfissionalRequestDTO;
import com.agendadiarista.entity.Profissional;
import com.agendadiarista.exceptions.ResourceNotFoundException;
import com.agendadiarista.repository.AgendamentoRepository;
import com.agendadiarista.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;
    private final AgendamentoRepository agendamentoRepository;

    @Transactional
    public Profissional salvar(ProfissionalRequestDTO dadosProfissional) {
        Profissional novoProfissional = new Profissional();
        novoProfissional.setNome(dadosProfissional.getNome());
        novoProfissional.setTelefone(dadosProfissional.getTelefone());
        novoProfissional.setEmail(dadosProfissional.getEmail());

        return profissionalRepository.save(novoProfissional);
    }

    public Profissional buscarPorId(Long id) {
        return profissionalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado com o ID:" + id));
    }

    public List<Profissional> buscarTodos() {
        return profissionalRepository.findAll();
    }

    @Transactional
    public Profissional atualizar(Long id, ProfissionalRequestDTO profissional) {
        Profissional profissionalAtualizado = buscarPorId(id);
        profissionalAtualizado.setEmail(profissional.getEmail());
        profissionalAtualizado.setNome(profissional.getNome());
        profissionalAtualizado.setTelefone(profissional.getTelefone());
        return profissionalRepository.save(profissionalAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        Profissional profissionalBusca = buscarPorId(id);

        if (agendamentoRepository.existsByProfissionalId(id)) {
            throw new IllegalArgumentException("Não é possível excluir o profissional pois existem agendamentos vinculados a ele.");
        }

        profissionalRepository.delete(profissionalBusca);
    }
}