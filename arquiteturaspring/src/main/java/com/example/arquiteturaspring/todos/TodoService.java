package com.example.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        return repository.save(novoTodo);
    }

    public TodoEntity atualizarStatus(TodoEntity todo) {
        return repository.save(todo);
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<TodoEntity> buscarTodos() {
        return repository.findAll();
    }
}
