package com.example.livro.controller;

import com.example.livro.dto.LivroDto;
import com.example.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDto>> all() {
        List<LivroDto> livros = livroService.findAll();
        return ResponseEntity.ok().body(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Long id) {
        Optional<LivroDto> livro = livroService.findById(id);
        return livro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LivroDto> criarLivro(@RequestBody LivroDto livroDto) {
        LivroDto livroCriado = livroService.criarLivro(livroDto);
        return ResponseEntity.ok().body(livroCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> update(@PathVariable Long id, @RequestBody LivroDto livroDto) {
        LivroDto livroEditado = livroService.editarLivro(id, livroDto);
        if (livroEditado != null) {
            return ResponseEntity.ok().body(livroEditado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (livroService.deletarLivro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
