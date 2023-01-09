package com.todo.todo.data.repositories;

import com.todo.todo.data.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface TodoRepo extends MongoRepository<Todo, String> {

}
