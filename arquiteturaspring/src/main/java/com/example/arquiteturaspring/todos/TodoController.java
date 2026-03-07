package com.example.arquiteturaspring.todos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        try {
            return this.service.salvar(todo);
        } catch (IllegalArgumentException e) {
            var mensagemErro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }
    }

    @PutMapping("/editar/{id}")
    public TodoEntity atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        return this.service.atualizarStatus(todo);
    }

    @GetMapping("/buscarporid/{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id) {
        return this.service.buscarPorId(id);
    }

    @GetMapping("/buscartodos")
    public List<TodoEntity> buscarTodos() {
        return this.service.buscarTodos();
    }
}
