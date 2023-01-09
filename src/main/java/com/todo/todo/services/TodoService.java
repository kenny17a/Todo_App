package com.todo.todo.services;

import com.todo.todo.data.models.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Todo createTodo(Todo todo);
    Optional<Todo> findById(String id);
    Todo updateTodo(String id, Todo todo);
    void deleteTodo(String id);
    List<Todo> getAllTodo();
}
