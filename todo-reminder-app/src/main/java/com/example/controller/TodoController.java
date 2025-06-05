package com.example.controller;

import com.example.model.TodoItem;
import com.example.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping
    public ResponseEntity<TodoItem> addTodo(@RequestBody TodoItem todoItem) {
        TodoItem createdTodo = reminderService.addTodo(todoItem);
        return ResponseEntity.ok(createdTodo);
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getTodos() {
        List<TodoItem> todos = reminderService.getTodos();
        return ResponseEntity.ok(todos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        reminderService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}