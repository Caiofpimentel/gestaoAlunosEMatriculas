package com.caiofpimentel.gestaoAlunosEMatriculas.DTO;

import java.time.LocalDate;

import java.util.List;





public record AlunoRequest(String nome, String telefone, LocalDate dataDeNascimento, List<MatriculaDTO> matriculas) {

  

}
