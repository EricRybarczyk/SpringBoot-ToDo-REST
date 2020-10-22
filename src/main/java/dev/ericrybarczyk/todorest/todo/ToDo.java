package dev.ericrybarczyk.todorest.todo;

import java.time.LocalDate;

public class ToDo {

    private long id;
    private String username;
    private String description;
    private LocalDate targetDate;
    private boolean isDone;

    public ToDo() {
    }

    public ToDo(long id, String username, String description, LocalDate targetDate, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ToDo toDo = (ToDo) other;
        return id == toDo.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

}
