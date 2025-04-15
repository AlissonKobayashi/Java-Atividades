package com.example.provaPratica.pessoa;

import com.example.provaPratica.trabalho.TrabalhoModel;
import com.example.provaPratica.trabalho.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepositoy pessoaRepositoy;

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<PessoaModel> listarAll(){
        return pessoaRepositoy.findAll();
    }

    public Optional<PessoaModel> listarById(Long id){
        return pessoaRepositoy.findById(id);
    }

    public PessoaModel criarPessoa(PessoaModel pessoaModel){
        return pessoaRepositoy.save(pessoaModel);
    }

    public void editarPessoa(Long id, PessoaModel pessoaModel){
        pessoaModel.setId(id);
        pessoaRepositoy.save(pessoaModel);
    }

    public void deletarPessoa(Long id){
        pessoaRepositoy.deleteById(id);
    }

}
