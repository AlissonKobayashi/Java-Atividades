package com.example.livro.service;

import com.example.livro.dto.LivroDto;
import com.example.livro.model.domain.ModelLivro;
import com.example.livro.model.repository.LivroRepository;
import com.example.livro.enun.StatusLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    private LivroDto toDto(ModelLivro livro) {
        return new LivroDto(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getStatusLivro());
    }

    private ModelLivro toEntity(LivroDto dto) {
        ModelLivro livro = new ModelLivro();
        livro.setId(dto.getId());
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setStatusLivro(dto.getStatusLivro());
        return livro;
    }

    public List<LivroDto> findAll() {
        return livroRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Optional<LivroDto> findById(Long id) {
        return livroRepository.findById(id).map(this::toDto);
    }

    public LivroDto criarLivro(LivroDto livroDto) {
        ModelLivro modelLivro = toEntity(livroDto);
        return toDto(livroRepository.save(modelLivro));
    }

    public LivroDto editarLivro(Long id, LivroDto livroDto) {
        Optional<ModelLivro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isPresent()) {
            ModelLivro livro = livroOptional.get();
            livro.setTitulo(livroDto.getTitulo());
            livro.setAutor(livroDto.getAutor());
            livro.setStatusLivro(livroDto.getStatusLivro());
            return toDto(livroRepository.save(livro));
        }
        return null;  // Ou pode retornar Optional.empty() se preferir
    }

    public boolean deletarLivro(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
