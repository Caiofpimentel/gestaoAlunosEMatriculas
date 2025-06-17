package com.caiofpimentel.gestaoAlunosEMatriculas.Controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiofpimentel.gestaoAlunosEMatriculas.DTO.AlunoRequest;
import com.caiofpimentel.gestaoAlunosEMatriculas.DTO.AlunoResponse;
import com.caiofpimentel.gestaoAlunosEMatriculas.DTO.MatriculaDTO;
import com.caiofpimentel.gestaoAlunosEMatriculas.Service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @PostMapping
    public ResponseEntity<AlunoResponse> salvarAluno(@RequestBody AlunoRequest alunoRequest) {
        AlunoResponse alunoResponse = alunoService.salvarAluno(alunoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoResponse);
    }  


    @GetMapping
    public List<AlunoResponse> listarTodosAlunos() {
        return alunoService.listarAlunos();
    }

    @GetMapping("{id}/matriculas")
    public List<MatriculaDTO> listarMatriculas(@PathVariable Long id) {
        return alunoService.listarMatriculas(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizarAluno(@PathVariable Long id, @RequestBody AlunoRequest alunoRequest) {
        AlunoResponse alunoResponse = alunoService.atualizarAluno(id, alunoRequest);
        return ResponseEntity.ok(alunoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAluno(@PathVariable Long id) {
        alunoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
