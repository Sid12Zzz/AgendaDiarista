package com.agendadiarista.service;

import com.agendadiarista.entity.Profissional;
import com.agendadiarista.exceptions.ResourceNotFoundException;
import com.agendadiarista.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    public Profissional salvar (Profissional profissional){
        return profissionalRepository.save(profissional);
    }


    public Profissional buscarPorId(Long id){
        return profissionalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado com o ID:" + id));
    }


    public List<Profissional> buscarTodos(){
        return profissionalRepository.findAll();
    }

    public Profissional atualizar(Long id, Profissional profissional){
        Profissional profissionalatualizado = buscarPorId(id);
        profissionalatualizado.setEmail(profissional.getEmail());
        profissionalatualizado.setNome(profissional.getNome());
        profissionalatualizado.setTelefone(profissional.getTelefone());
        return profissionalatualizado;
   }

   public void deletar(Long id){
        Profissional profissionalbusca = buscarPorId(id);
        profissionalRepository.delete(profissionalbusca);
   }

}
