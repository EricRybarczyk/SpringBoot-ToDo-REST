package dev.ericrybarczyk.todorest.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/users/{username}/todos/{todoId}")
    public ToDo getToDoItem(@PathVariable String username, @PathVariable long todoId) {
        return todoHardcodedService.findById(todoId);
    }

    @DeleteMapping("/users/{username}/todos/{todoId}")
    public ResponseEntity<Void> deleteToDoItem(@PathVariable String username, @PathVariable long todoId) {
        ToDo toDo = todoHardcodedService.deleteById(todoId);
        if (toDo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    // update a To-Do for a User
    // PUT /users/{username}/todos/{todoId}


    // create a new To-Do for a User
    // POST /users/{username}/todos

}
