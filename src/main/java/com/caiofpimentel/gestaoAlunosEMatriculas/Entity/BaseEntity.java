package com.caiofpimentel.gestaoAlunosEMatriculas.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "data_inclusao",  updatable = false)
    private LocalDateTime dataInclusao;
    
    @LastModifiedDate
    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;


}
