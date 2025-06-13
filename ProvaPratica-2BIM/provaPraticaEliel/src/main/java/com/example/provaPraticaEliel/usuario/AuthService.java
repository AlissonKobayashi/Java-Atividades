package com.example.provaPraticaEliel.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<?> registrar(AuthDTO dto) {
        if (repositoryUsuario.findByLogin(dto.getLogin()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }

        ModelUsuario novo = new ModelUsuario();
        novo.setLogin(dto.getLogin());
        novo.setSenha(passwordEncoder.encode(dto.getSenha()));
        repositoryUsuario.save(novo);

        return ResponseEntity.ok("Usuário registrado com sucesso");
    }

    public ResponseEntity<?> logar(AuthDTO dto) {
        return repositoryUsuario.findByLogin(dto.getLogin())
                .filter(user -> passwordEncoder.matches(dto.getSenha(), user.getSenha()))
                .map(user -> ResponseEntity.ok((Object) new TokenResponse(jwtUtil.generateToken(user.getLogin()))))
                .orElse(ResponseEntity.status(401).body("Credenciais inválidas"));
    }

}
