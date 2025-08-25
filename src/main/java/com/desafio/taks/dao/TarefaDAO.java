package com.desafio.taks.dao;

import com.desafio.taks.model.Tarefa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarefaDAO extends CrudRepository<Tarefa, Integer> {

}
