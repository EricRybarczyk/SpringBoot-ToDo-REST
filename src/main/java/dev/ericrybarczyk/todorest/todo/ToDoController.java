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

    @PutMapping("/users/{username}/todos/{todoId}")
    public ResponseEntity<ToDo> updateToDoItem(@PathVariable String username, @PathVariable long todoId, @RequestBody ToDo toDo) {
        ToDo updatedToDo = todoHardcodedService.save(toDo);
        return new ResponseEntity<>(updatedToDo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos/")
    public ResponseEntity<ToDo> saveNewToDoItem(@PathVariable String username, @RequestBody ToDo toDo) {
        ToDo createdToDo = todoHardcodedService.save(toDo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdToDo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
