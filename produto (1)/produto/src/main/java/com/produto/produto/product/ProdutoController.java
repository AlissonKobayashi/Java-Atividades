package com.produto.produto.product;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll() {
        List<ProdutoModel> produtoModel = produtoService.findAll();
        return ResponseEntity.ok().body(produtoModel);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@Valid @RequestBody ProdutoModel novoProduto) {
        ProdutoModel produtoModel = produtoService.criarProduto(novoProduto);
        return ResponseEntity.ok().body(produtoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody ProdutoModel editProduto) {
        produtoService.editarProduto(id, editProduto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
