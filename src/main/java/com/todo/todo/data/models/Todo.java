package com.todo.todo.data.models;

import jakarta.persistence.Id;
import lombok.Data;




@Data
public class Todo {
    @Id
    private String id;
    private String title;
    private boolean isCompleted;
}
