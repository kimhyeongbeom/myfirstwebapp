package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
    
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;
    
    static {
        todos.add(new Todo(++todosCount, "in28minutes", "Learn1 AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn1 DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn1 Full stack development", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream()
        .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
        .toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {
        return todos.stream()
        .filter(todo -> todo.getId() == id)
        .findFirst()
        .orElse(null);
    }

    public void update(@Valid Todo todo) {
        todos.removeIf(t -> t.getId() == todo.getId());
        todos.add(todo);
    }

}
