package com.example.Campeonato.controller;

import com.example.Campeonato.model.domain.ModelCampeonato;
import com.example.Campeonato.model.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campeonato")
public class CampeonatoController {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @GetMapping("/buscar")
    public List<ModelCampeonato> all(){
        return campeonatoRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Optional<ModelCampeonato> findById(@PathVariable Long id){
        return campeonatoRepository.findById(id);
    }

    @PostMapping("/criar")
    public ModelCampeonato create(@RequestBody ModelCampeonato novoCampeonato){
        return campeonatoRepository.save(novoCampeonato);
    }

}
