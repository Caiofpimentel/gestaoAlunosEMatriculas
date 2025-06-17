package com.caiofpimentel.gestaoAlunosEMatriculas.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import com.caiofpimentel.gestaoAlunosEMatriculas.DTO.AlunoRequest;
import com.caiofpimentel.gestaoAlunosEMatriculas.DTO.AlunoResponse;
import com.caiofpimentel.gestaoAlunosEMatriculas.DTO.MatriculaDTO;
import com.caiofpimentel.gestaoAlunosEMatriculas.Entity.Aluno;
import com.caiofpimentel.gestaoAlunosEMatriculas.Entity.Matricula;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoRequest request){
        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setTelefone(request.telefone());
        aluno.setDataDeNascimento(request.dataDeNascimento());

        List<Matricula> matriculas = request.matriculas().stream().map( m -> {
                Matricula matricula = new Matricula();
                matricula.setCodigoMatricula(m.codigoMatricula());
                matricula.setDataInicio(m.dataInicio());
                matricula.setNomeCurso(m.nomeCurso());

                return matricula;
        } ).toList();
        aluno.setMatriculas(matriculas);
        return aluno;
    }


    public AlunoResponse toResponse(Aluno aluno) {
        List<MatriculaDTO> matriculaDTOS = aluno.getMatriculas().stream().map(m -> 
             new MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(), m.getDataInicio())).toList();

             return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getTelefone(),
                aluno.getDataDeNascimento(),
                matriculaDTOS);

    }

}
