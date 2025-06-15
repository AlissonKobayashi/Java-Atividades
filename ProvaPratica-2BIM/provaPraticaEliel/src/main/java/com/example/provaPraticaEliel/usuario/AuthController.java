package com.example.provaPraticaEliel.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody ModelUsuario usuario) {
        if (repositoryUsuario.findByLogin(usuario.getLogin()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }

        ModelUsuario novoUsuario = repositoryUsuario.save(usuario);
        return ResponseEntity.ok(novoUsuario);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO login) {

        return repositoryUsuario.findByLogin(login.getLogin())
                .map(usuario -> {

                    if (usuario.getSenha().equals(login.getSenha())) {

                        String token = jwtUtil.generateToken(usuario.getLogin());


                        return ResponseEntity.ok("Bearer " + token);
                    }


                    return ResponseEntity.status(401).body("Senha inválida");
                })

                .orElse(ResponseEntity.status(401).body("Usuário não encontrado"));
    }
}