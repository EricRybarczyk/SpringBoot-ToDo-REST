package dev.ericrybarczyk.todorest.todo;

import java.util.List;

public interface TodoService {

    List<ToDo> findAll(String username);
    ToDo findById(String username, long id);
    ToDo save(String username, ToDo toDo);
    ToDo deleteById(String username, long id);

}
