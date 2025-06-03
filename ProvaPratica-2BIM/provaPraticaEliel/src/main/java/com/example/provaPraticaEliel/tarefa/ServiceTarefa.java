package com.example.provaPraticaEliel.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTarefa {

    @Autowired
    private RepositoryTarefa repositoryTarefa;

    public List<ModelTarefa> listAll(){
        return repositoryTarefa.findAll();
    }

    public Optional<ModelTarefa> listarById(Long id){
        return repositoryTarefa.findById(id);
    }

    public ModelTarefa criarTarefa(ModelTarefa modelTarefa){
        return repositoryTarefa.save(modelTarefa);
    }

    public void editarTarefa(Long id, ModelTarefa modelTarefa){
        modelTarefa.setId(id);
        repositoryTarefa.save(modelTarefa);
    }

    public void deletarTarefa(Long id){
        repositoryTarefa.deleteById(id);
    }

}
