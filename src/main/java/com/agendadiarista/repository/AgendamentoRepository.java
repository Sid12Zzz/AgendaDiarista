package com.agendadiarista.repository;

import com.agendadiarista.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

 boolean existsByProfissionalIdAndDataHora(Long profissionalId, LocalDate dataHora);

 boolean existsByProfissionalIdAndDataHoraAndIdNot(Long profissionalId, LocalDate dataHora, Long id);

 boolean existsByClienteId(Long clienteId);

 boolean existsByProfissionalId(Long profissionalId);
}