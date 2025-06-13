package com.example.provaPraticaEliel.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthDTO dto) {
        return authService.registrar(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO dto) {
        return authService.logar(dto);
    }
}
