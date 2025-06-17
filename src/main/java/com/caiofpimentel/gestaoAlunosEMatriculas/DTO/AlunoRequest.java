package com.caiofpimentel.gestaoAlunosEMatriculas.DTO;

import java.time.LocalDateTime;
import java.util.List;

public record AlunoRequest(String nome, String telefone, LocalDateTime dataDeNascimento, List<MatriculaDTO> matriculas) {

  

}
