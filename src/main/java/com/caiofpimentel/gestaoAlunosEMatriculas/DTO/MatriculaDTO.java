package com.caiofpimentel.gestaoAlunosEMatriculas.DTO;

import java.time.LocalDate;


public record MatriculaDTO(String codigoMatricula, String nomeCurso, LocalDate dataInicio) {


}
