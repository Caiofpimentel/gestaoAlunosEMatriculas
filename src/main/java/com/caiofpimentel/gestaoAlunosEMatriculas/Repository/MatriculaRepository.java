package com.caiofpimentel.gestaoAlunosEMatriculas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiofpimentel.gestaoAlunosEMatriculas.Entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

  

}
