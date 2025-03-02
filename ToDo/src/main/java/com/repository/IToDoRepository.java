package com.repository;

import com.model.ToDo;// Imports the To-Do entity/model.
import org.springframework.data.jpa.repository.JpaRepository;// Provides built-in CRUD methods for database operations.
import org.springframework.stereotype.Repository;// Marks this as a Spring Data repository so that Spring Boot can manage it.

@Repository
public interface IToDoRepository extends JpaRepository<ToDo, Long> {
    //Enables built-in database operations for To-Do entities.
}
