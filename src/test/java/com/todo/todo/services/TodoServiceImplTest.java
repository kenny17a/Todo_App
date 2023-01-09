package com.todo.todo.services;

import com.todo.todo.data.models.Todo;
import com.todo.todo.data.repositories.TodoRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TodoServiceImplTest {
    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoRepo todoRepo;
    private Todo todo;

    @BeforeEach
    void setUp() {
        todo = new Todo();
        todo.setTitle("New Year Resolution");
    }
    @AfterEach
    void afterEachTest(){
        todoRepo.deleteAll();
    }
    @Test
    void testThatTodoTaskCanBeCreatedAndSavedInDb(){
        Todo savedTodo = todoService.createTodo(todo);
        System.out.println(savedTodo.getId());
        assertNotNull(savedTodo.getId());
    }
    @Test
    void testThatTodoEntryCanBeFoundById(){
        Todo savedTodo = todoService.createTodo(todo);
        assertTrue(todoService.findById(savedTodo.getId()).isPresent());
    }
    @Test
    void testToGetAllTodoElement(){
        Todo savedTodo = todoService.createTodo(todo);
        assertEquals(1, todoService.getAllTodo().size());
    }
    @Test
    void testThatTodoEntryCanBeDeleted(){
        Todo savedTodo = todoService.createTodo(todo);
        var sizeOfTodoDbBeforeDeletingAnEntry = todoService.getAllTodo().size();
        assertEquals(1,sizeOfTodoDbBeforeDeletingAnEntry);
        todoService.deleteTodo(savedTodo.getId());
        var sizeOfTodoDbAfterDeletingAnEntry = todoService.getAllTodo().size();
        assertEquals(0, sizeOfTodoDbAfterDeletingAnEntry);
    }
    @Test
    void testThatTodoCanBeUpdated(){
        Todo savedTodo = todoService.createTodo(todo);
        Todo foundTodo = todoService.findById(savedTodo.getId()).get();
        assertEquals("New Year Resolution", foundTodo.getTitle());
        foundTodo.setTitle("updated todo");
        Todo updatedTodo = todoService.updateTodo(savedTodo.getId(), foundTodo);
        assertEquals("updated todo", updatedTodo.getTitle());
        assertEquals(foundTodo.getId(), updatedTodo.getId());

    }

}