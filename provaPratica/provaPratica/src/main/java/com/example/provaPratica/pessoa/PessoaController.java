package com.example.provaPratica.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaModel> listAll(){
        return pessoaService.listarAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> listById(@PathVariable Long id){
        pessoaService.listarById(id);
        return pessoaService.listarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PessoaModel> create(@RequestBody PessoaModel pessoaModel){
        PessoaModel pessoaModel1 = pessoaService.criarPessoa(pessoaModel);
        return ResponseEntity.ok().body(pessoaModel1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editPessoa(@PathVariable Long id, @RequestBody PessoaModel pessoaModel){
        pessoaModel.setId(id);
        pessoaService.editarPessoa(id, pessoaModel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

}
