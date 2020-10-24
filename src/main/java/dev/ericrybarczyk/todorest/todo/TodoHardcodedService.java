package dev.ericrybarczyk.todorest.todo;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<ToDo> toDoList = new ArrayList<>();
    private static int idCounter = 0;

    static {
        toDoList.add(new ToDo(++idCounter, "demouser", "Complete Angular Crash Course", LocalDate.now(), false));
        toDoList.add(new ToDo(++idCounter, "demouser", "Complete Microservices Course", LocalDate.now(), false));
        toDoList.add(new ToDo(++idCounter, "demouser", "Build a strong demo app portfolio", LocalDate.now(), false));
    }

    public List<ToDo> findAll() {
        return toDoList;
    }

    public ToDo findById(long id) {
        return toDoList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ToDo save(ToDo toDo) {
        if (toDo.getId() < 1) {
            toDo.setId(++idCounter);
            toDoList.add(toDo);
        } else {
            updateExisting(toDo);
        }
        return toDo;
    }

    private void updateExisting(ToDo toDo) {
        ToDo existingToDo = findById(toDo.getId());
        if (existingToDo == null) {
            return;
        }
        existingToDo.setDescription(toDo.getDescription());
        existingToDo.setTargetDate(toDo.getTargetDate());
        existingToDo.setDone(toDo.isDone());
    }

    public ToDo deleteById(long id) {
        ToDo todo = findById(id);
        if (toDoList.remove(todo)) {
            return todo;
        }
        return null;
    }

}
