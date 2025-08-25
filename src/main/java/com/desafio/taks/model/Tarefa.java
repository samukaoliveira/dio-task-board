package com.desafio.taks.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
public class Tarefa {

    public Tarefa() {
        this.status = Status.CRIADA;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private LocalDate data;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    private Status status;

}
