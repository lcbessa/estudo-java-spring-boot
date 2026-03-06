package com.example.arquiteturaspring.todos;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        return this.service.salvar(todo);
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
