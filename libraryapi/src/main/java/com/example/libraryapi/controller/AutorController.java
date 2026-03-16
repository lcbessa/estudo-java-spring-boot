package com.example.libraryapi.controller;

import com.example.libraryapi.controller.dto.AutorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @PostMapping
    public ResponseEntity salvarAutor(@RequestBody AutorDTO autor) {
        return new ResponseEntity("Autor salvo com sucesso!" + autor, HttpStatus.CREATED);
    }
}
