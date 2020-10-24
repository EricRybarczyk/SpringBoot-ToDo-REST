package dev.ericrybarczyk.todorest.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoController {

    // TODO: the username path variable needs to be validated against the authenticated user

    private final TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/users/{username}/todos")
    public List<ToDo> getAllToDoItems(@PathVariable String username) {
        return todoService.findAll(username);
    }

    @GetMapping("/users/{username}/todos/{todoId}")
    public ToDo getToDoItem(@PathVariable String username, @PathVariable long todoId) {
        return todoService.findById(username, todoId);
    }

    @DeleteMapping("/users/{username}/todos/{todoId}")
    public ResponseEntity<Void> deleteToDoItem(@PathVariable String username, @PathVariable long todoId) {
        ToDo toDo = todoService.deleteById(username, todoId);
        if (toDo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{todoId}")
    public ResponseEntity<ToDo> updateToDoItem(@PathVariable String username, @PathVariable long todoId, @RequestBody ToDo toDo) {
        ToDo updatedToDo = todoService.save(username, toDo);
        return new ResponseEntity<>(updatedToDo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos/")
    public ResponseEntity<ToDo> saveNewToDoItem(@PathVariable String username, @RequestBody ToDo toDo) {
        toDo.setUsername(username);
        ToDo createdToDo = todoService.save(username, toDo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdToDo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
