package dev.ericrybarczyk.todorest.todo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoController {

    private TodoHardcodedService todoHardcodedService;

    public ToDoController(TodoHardcodedService todoHardcodedService) {
        this.todoHardcodedService = todoHardcodedService;
    }

    @GetMapping("/users/{username}/todos")
    public List<ToDo> getAllToDoItems(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }

    // delete a To-Do for a User
    // DELETE /users/{username}/todos/{todoId}


    // update a To-Do for a User
    // PUT /users/{username}/todos/{todoId}


    // create a new To-Do for a User
    // POST /users/{username}/todos

}
