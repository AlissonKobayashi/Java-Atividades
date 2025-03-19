package com.produto.produto.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    private ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> produtoModel = produtoService.findAll();
        return ResponseEntity.ok().body(produtoModel);
    }

    @PostMapping
    private ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel novoProduto){
        ProdutoModel produtoModel = produtoService.criarProduto(novoProduto);
        return ResponseEntity.ok().body(produtoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProdutoModel editLivro) {
        produtoService.editarProduto(id, editLivro);
        return ResponseEntity.noContent().build();
}

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletarPorId(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
