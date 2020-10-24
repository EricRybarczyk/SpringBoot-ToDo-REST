package dev.ericrybarczyk.todorest.todo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@Profile({"springdatajpa"})
public class ToDoJpaService implements TodoService {

    private final ToDoJpaRepository repository;

    public ToDoJpaService(ToDoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ToDo> findAll(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public ToDo findById(String username, long id) {
        return repository.findByIdAndUsername(id, username).orElse(null);
    }

    @Override
    public ToDo save(String username, ToDo toDo) {
        if (!username.equalsIgnoreCase(toDo.getUsername())) {
            throw new InvalidParameterException("username parameter must match the ToDo username");
        }
        return repository.save(toDo);
    }

    @Override
    public ToDo deleteById(String username, long id) {
        Optional<ToDo> found = repository.findByIdAndUsername(id, username);
        if (found.isPresent()) {
            repository.deleteById(id);
            return found.get();
        }
        return null;
    }

}
