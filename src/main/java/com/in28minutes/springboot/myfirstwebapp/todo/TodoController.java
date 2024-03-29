package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model) {
        String username = (String)model.get("name");
        List<Todo> todos = todoService.findByUsername(username);

        model.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model) {
        String username = (String)model.get("name");
        Todo todo = new Todo(0, username, "Default Description", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String username = (String)model.get("name");
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo/{id}", method = RequestMethod.GET)
    public String deleteTodo(@PathVariable int id) {
        todoService.deleteById(id);
        System.out.println("delete-todo : " + id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo/{id}", method = RequestMethod.GET)
    public String showUpdateTodoPage(@PathVariable int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo/{id}", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String username = (String)model.get("name");
        todo.setUsername(username);
        todoService.update(todo);
        return "redirect:/list-todos";
    }
}
