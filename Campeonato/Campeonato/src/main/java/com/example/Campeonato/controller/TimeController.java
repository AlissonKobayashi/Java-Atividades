package com.example.Campeonato.controller;

import com.example.Campeonato.model.domain.ModelCampeonato;
import com.example.Campeonato.model.domain.ModelTime;
import com.example.Campeonato.model.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping("/buscar")
    public List<ModelTime> all(){
        return timeRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Optional<ModelTime> findById(@PathVariable Long id){
        return timeRepository.findById(id);
    }

    @PostMapping("/criar")
    public ModelTime create(@RequestBody ModelTime novoTime){
        return timeRepository.save(novoTime);
    }

    @PutMapping("/editar")
    public void update(@PathVariable Long id, @RequestBody ModelTime editTime){
        editTime.setId(id);
        timeRepository.save(editTime);
    }

    @DeleteMapping("/deletar")
    public void delete(@PathVariable Long id){
        timeRepository.deleteById(id);
    }
}
