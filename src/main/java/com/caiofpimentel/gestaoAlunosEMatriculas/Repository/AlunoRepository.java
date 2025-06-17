package com.caiofpimentel.gestaoAlunosEMatriculas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiofpimentel.gestaoAlunosEMatriculas.Entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
