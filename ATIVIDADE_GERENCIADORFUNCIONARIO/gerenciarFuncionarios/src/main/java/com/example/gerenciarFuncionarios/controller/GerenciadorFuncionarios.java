package com.example.gerenciarFuncionarios.controller;

import com.example.gerenciarFuncionarios.model.domain.ModelFuncionario;
import com.example.gerenciarFuncionarios.model.repository.RepositoryFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class GerenciadorFuncionarios {

    @Autowired
    private RepositoryFuncionario repositoryFuncionario;

    @GetMapping("/listarTodos")
    public List<ModelFuncionario> all(){
        return repositoryFuncionario.findAll();
    }

    @PostMapping("/criar")
    public ModelFuncionario create(@RequestBody ModelFuncionario novoFuncionario){
        return repositoryFuncionario.save(novoFuncionario);
    }

    @PutMapping("/editar/{id}")
    public void update(@PathVariable int id, @RequestBody ModelFuncionario editFucionario){
        editFucionario.setId(id);
        repositoryFuncionario.save(editFucionario);
    }

    @DeleteMapping("/deletar")
    public void delete(@PathVariable Long id){
        repositoryFuncionario.deleteById(id);
    }
}
