package com.example.provaPratica.trabalho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<TrabalhoModel> listarAll(){
        return trabalhoRepository.findAll();
    }

    public Optional<TrabalhoModel> listarById(Long id){
        return trabalhoRepository.findById(id);
    }

    public TrabalhoModel criarTrabalho(TrabalhoModel trabalhoModel){
        return trabalhoRepository.save(trabalhoModel);
    }

    public void editarTrabalho(Long id, TrabalhoModel trabalhoModel){
        trabalhoModel.setId(id);
        trabalhoRepository.save(trabalhoModel);
    }

    public void deletarTrabalho(Long id){
        trabalhoRepository.deleteById(id);
    }

}
