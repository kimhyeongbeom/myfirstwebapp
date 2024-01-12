package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    private TodoRepository todoRepository;

    //private TodoService todoService;

    public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
        super();
        //this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUserName();

        System.out.println("username : " + username);

        List<Todo> todos = todoRepository.findByUsername(username);

        model.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model) {
        String username = getLoggedInUserName();
        Todo todo = new Todo(0, username, "Default Description", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUserName();
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo/{id}", method = RequestMethod.GET)
    public String deleteTodo(@PathVariable int id) {
        //todoService.deleteById(id);
        todoRepository.deleteById(id);
        System.out.println("delete-todo : " + id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo/{id}", method = RequestMethod.GET)
    public String showUpdateTodoPage(@PathVariable int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();

        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo/{id}", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUserName();
        todo.setUsername(username);
        //todoService.update(todo);
        todoRepository.save(todo);
        return "redirect:/list-todos";
    }

    private String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
