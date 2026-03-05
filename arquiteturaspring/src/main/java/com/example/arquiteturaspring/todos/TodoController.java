package com.example.arquiteturaspring.todos;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public TodoEntity salvar(@RequestBody @Valid TodoEntity todo) {
        return this.service.salvar(todo);
    }

    @PutMapping
    public TodoEntity atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        return this.service.atualizarStatus(todo);
    }
}
