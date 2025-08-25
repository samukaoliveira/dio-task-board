package com.desafio.taks.service;

import com.desafio.taks.dao.TarefaDAO;
import com.desafio.taks.model.Status;
import com.desafio.taks.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void concluirTarefa(Integer id) {
        Tarefa tarefa = findById(id).get();
        if(tarefa.getStatus() != Status.CONCLUIDA) {
            tarefa.setStatus(Status.CONCLUIDA);
            tarefaDAO.save(tarefa);
        }
    }

    public Optional<Tarefa> findById(Integer id) {
        return tarefaDAO.findById(id);
    }
}
