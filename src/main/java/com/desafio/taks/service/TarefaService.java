package com.desafio.taks.service;

import com.desafio.taks.dao.TarefaDAO;
import com.desafio.taks.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaDAO tarefaDAO;

    public void save(Tarefa tarefa) {
        tarefaDAO.save(tarefa);
    }

    public Iterable<Tarefa> findAll() {
        return tarefaDAO.findAll();
    }
}
