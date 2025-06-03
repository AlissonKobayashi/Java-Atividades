package com.example.provaPraticaEliel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tarefa")
public class ControllerTarefa {

    @Autowired
    private ServiceTarefa serviceTarefa;

    @GetMapping
    public List<ModelTarefa> listAll(){
        return serviceTarefa.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelTarefa> listById(@PathVariable Long id){
        serviceTarefa.listarById(id);
        return serviceTarefa.listarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ModelTarefa> createTarefa(@RequestBody ModelTarefa modelTarefa){
        ModelTarefa modelTarefa1 = serviceTarefa.criarTarefa(modelTarefa);
        return ResponseEntity.ok().body(modelTarefa1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editTarefa(@PathVariable Long id, @RequestBody ModelTarefa modelTarefa){
        modelTarefa.setId(id);
        serviceTarefa.editarTarefa(id, modelTarefa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        serviceTarefa.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
