package com.agendadiarista.repository;


import com.agendadiarista.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
