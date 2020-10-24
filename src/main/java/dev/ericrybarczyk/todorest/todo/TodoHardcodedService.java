package dev.ericrybarczyk.todorest.todo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile({"default","hardcoded"})
public class TodoHardcodedService implements TodoService {

    private static List<ToDo> toDoList = new ArrayList<>();
    private static long idCounter = 0;

    static {
        toDoList.add(new ToDo(++idCounter, "in28minutes", "Learn Spring Security", LocalDate.now(), false));
        toDoList.add(new ToDo(++idCounter, "in28minutes", "Learn Spring Data JPA", LocalDate.now(), false));
        toDoList.add(new ToDo(++idCounter, "in28minutes", "Learn Spring Boot Microservices", LocalDate.now(), false));
        toDoList.add(new ToDo(++idCounter, "demouser", "Complete Angular Crash Course", LocalDate.now(), false));
        toDoList.add(new ToDo(++idCounter, "demouser", "Complete Microservices Course", LocalDate.now(), false));
        toDoList.add(new ToDo(++idCounter, "demouser", "Build a strong demo app portfolio", LocalDate.now(), false));
    }

    @Override
    public List<ToDo> findAll(String username) {
        return toDoList.stream()
                .filter(e -> e.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());
    }

    @Override
    public ToDo findById(String username, long id) {
        return toDoList.stream()
                .filter(e -> e.getUsername().equalsIgnoreCase(username) && e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public ToDo save(String username, ToDo toDo) {
        if (toDo.getId() < 1) {
            toDo.setUsername(username);
            toDo.setId(++idCounter);
            toDoList.add(toDo);
        } else {
            updateExisting(username, toDo);
        }
        return toDo;
    }

    private void updateExisting(String username, ToDo toDo) {
        ToDo existingToDo = findById(username, toDo.getId());
        if (existingToDo == null) {
            return;
        }
        existingToDo.setDescription(toDo.getDescription());
        existingToDo.setTargetDate(toDo.getTargetDate());
        existingToDo.setDone(toDo.isDone());
    }

    @Override
    public ToDo deleteById(String username, long id) {
        ToDo todo = findById(username, id);
        if (toDoList.remove(todo)) {
            return todo;
        }
        return null;
    }

}
