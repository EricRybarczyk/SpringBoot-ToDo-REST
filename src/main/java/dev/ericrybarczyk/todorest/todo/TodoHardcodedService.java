package dev.ericrybarczyk.todorest.todo;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<ToDo> toDoList = new ArrayList<>();
    private static int idCounter = 0;

    static {
        toDoList.add(new ToDo(++idCounter, "demouser", "Complete Angular Course", new Date(), false));
        toDoList.add(new ToDo(++idCounter, "demouser", "Complete Microservices Course", new Date(), false));
        toDoList.add(new ToDo(++idCounter, "demouser", "Build a strong demo app portfolio", new Date(), false));
    }

    public List<ToDo> findAll() {
        return toDoList;
    }

}
