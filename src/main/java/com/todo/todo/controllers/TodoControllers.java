package com.todo.todo.controllers;

import com.todo.todo.data.models.Todo;
import com.todo.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/todos")
public class TodoControllers {
    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    public Todo newTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }

    @GetMapping("/{todoId}")
    public Optional<Todo> getTodoById(@PathVariable("todoId") String id) {
        return todoService.findById(id);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("todoId") String id, @RequestBody Todo todo) {

        return new ResponseEntity<>(todoService.updateTodo(id, todo), HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public String deleteTodo(@PathVariable("todoId") String id) {
        todoService.deleteTodo(id);
        return "Successfully deleted";
    }


}

