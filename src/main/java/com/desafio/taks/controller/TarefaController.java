package com.desafio.taks.controller;

import com.desafio.taks.model.Tarefa;
import com.desafio.taks.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/new")
    public ModelAndView novo() {
        return new ModelAndView("tarefas/new")
                .addObject("tarefa", new Tarefa());
    }

    @PostMapping("/create")
    public String create(Tarefa tarefa) {
        tarefaService.save(tarefa);
        return "redirect:/tarefas/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        return new ModelAndView("tarefas/edit")
                .addObject("tarefa", tarefaService.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada!")));
    }

    @PostMapping("/update")
    public String update(Tarefa tarefa) {
        tarefaService.save(tarefa);
        return "redirect:/tarefas/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("tarefas/list");
        modelAndView.addObject("tarefas", tarefaService.findAll());
        return modelAndView;
    }

    @GetMapping("/concluir/{id}")
    public String concluir(@PathVariable("id") Integer id) {
        tarefaService.concluirTarefa(id);
        return "redirect:/tarefas/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        tarefaService.deleteById(id);
        return "redirect:/tarefas/list";
    }
}
