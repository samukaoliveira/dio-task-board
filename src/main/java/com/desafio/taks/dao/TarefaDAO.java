package com.desafio.taks.dao;

import com.desafio.taks.model.Tarefa;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class TarefaDAO implements CrudRepository<Tarefa, Integer> {

}
