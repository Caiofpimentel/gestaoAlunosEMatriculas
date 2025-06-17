package com.caiofpimentel.gestaoAlunosEMatriculas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caiofpimentel.gestaoAlunosEMatriculas.DTO.AlunoRequest;
import com.caiofpimentel.gestaoAlunosEMatriculas.DTO.AlunoResponse;
import com.caiofpimentel.gestaoAlunosEMatriculas.DTO.MatriculaDTO;
import com.caiofpimentel.gestaoAlunosEMatriculas.Entity.Aluno;
import com.caiofpimentel.gestaoAlunosEMatriculas.Entity.Matricula;
import com.caiofpimentel.gestaoAlunosEMatriculas.Mapper.AlunoMapper;
import com.caiofpimentel.gestaoAlunosEMatriculas.Repository.AlunoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
    public class AlunoService {


        private final AlunoRepository alunoRepository;
        private final AlunoMapper alunoMapper;

    

    public AlunoResponse salvarAluno(AlunoRequest alunoRequest) {
        Aluno aluno = alunoMapper.toEntity(alunoRequest);
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return alunoMapper.toResponse(alunoSalvo);
    }


    public List<AlunoResponse> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(alunoMapper::toResponse).toList();
    }

    public List<MatriculaDTO> listarMatriculas(Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com o ID: " + id));
        return aluno.getMatriculas().stream()
                .map(m -> new MatriculaDTO(
                        m.getCodigoMatricula(),
                        m.getNomeCurso(),
                        m.getDataInicio()))
                .toList();
    }

    public void remover(Long id){
        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Aluno não encontrado com o ID: " + id);
        }
        alunoRepository.deleteById(id);
    }

    public AlunoResponse atualizarAluno(Long id, AlunoRequest alunoRequest) {
        Aluno alunoEncontrado = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com o ID: " + id));
        alunoEncontrado.setNome(alunoRequest.nome());
        alunoEncontrado.setTelefone(alunoRequest.telefone());
        alunoEncontrado.setDataDeNascimento(alunoRequest.dataDeNascimento());

        for (MatriculaDTO m : alunoRequest.matriculas()){
            Matricula matricula = new Matricula();
            matricula.setCodigoMatricula(m.codigoMatricula());
            matricula.setNomeCurso(m.nomeCurso());
            matricula.setDataInicio(m.dataInicio());
            alunoEncontrado.getMatriculas().add(matricula);
        }

        return alunoMapper.toResponse(alunoRepository.save(alunoEncontrado));

         
    }
}
