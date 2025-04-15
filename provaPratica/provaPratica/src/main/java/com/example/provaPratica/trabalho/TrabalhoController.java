package com.example.provaPratica.trabalho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/trabalho")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    public List<TrabalhoModel> listAll(){
        return trabalhoService.listarAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoModel> listById(@PathVariable Long id){
        trabalhoService.listarById(id);
        return trabalhoService.listarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrabalhoModel> create(@RequestBody TrabalhoModel trabalhoModel){
        TrabalhoModel trabalhoModel1 = trabalhoService.criarTrabalho(trabalhoModel);
        return  ResponseEntity.ok().body(trabalhoModel1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editTrabalho(@PathVariable Long id, @RequestBody TrabalhoModel trabalhoModel){
        trabalhoModel.setId(id);
        trabalhoService.editarTrabalho(id, trabalhoModel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrabalho(@PathVariable Long id){
        trabalhoService.deletarTrabalho(id);
        return ResponseEntity.noContent().build();
    }

}
