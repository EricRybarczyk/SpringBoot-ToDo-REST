package dev.ericrybarczyk.todorest.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoJpaRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByUsername(String username);
    Optional<ToDo> findByIdAndUsername(Long id, String username);
}
