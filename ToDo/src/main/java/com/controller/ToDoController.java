package com.controller;

import com.model.ToDo;
import com.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ToDoController {

    @Autowired
    private ToDoService service;

    //Fetch all To-Do items:
    @GetMapping("/viewToDoList")
    public ResponseEntity<List<ToDo>> getAllToDoItems() {
        List<ToDo> toDoList = service.getAllToDoItems();
        return ResponseEntity.ok(toDoList);
    }

    //Get a specific To-Do item by ID.
    @PutMapping("/updateToDoStatus/{id}")
    public ResponseEntity<Map<String, String>> updateToDoStatus(@PathVariable Long id) {
        boolean updated = service.updateStatus(id);
        return updated ?
                ResponseEntity.ok(Collections.singletonMap("message", "Updated Successfully")) :
                ResponseEntity.badRequest().body(Collections.singletonMap("error", "Failed to Update"));
    }

    //Create a new To-Do item.
    @PostMapping("/saveToDoItem")
    public ResponseEntity<Map<String, String>> saveToDoItem(@RequestBody ToDo todo) {
        boolean saved = service.saveOrUpdateToDoItem(todo);
        return saved ?
                ResponseEntity.ok(Collections.singletonMap("message", "Successfully saved")) :
                ResponseEntity.badRequest().body(Collections.singletonMap("error", "Failed to Save"));
    }

    //Update the status of a To-Do item.
    @GetMapping("/getToDoItem/{id}")
    public ResponseEntity<ToDo> getToDoItemById(@PathVariable Long id) {
        ToDo todo = service.getToDoItemById(id);
        return todo != null ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    //Edit an existing To-Do item.
    @PutMapping("/editToDoItem")
    public ResponseEntity<Map<String, String>> editSaveToDoItem(@RequestBody ToDo todo) {
        boolean updated = service.saveOrUpdateToDoItem(todo);
        return updated ?
                ResponseEntity.ok(Collections.singletonMap("message", "Successfully Edited")) :
                ResponseEntity.badRequest().body(Collections.singletonMap("error", "Failed to Edit"));
    }

    //Delete a To-Do item.
    @DeleteMapping("/deleteToDoItem/{id}")
    public ResponseEntity<Map<String, String>> deleteToDoItem(@PathVariable Long id) {
        boolean deleted = service.deleteToDoItem(id);
        return deleted ?
                ResponseEntity.ok(Collections.singletonMap("message", "Deleted Successfully")) :
                ResponseEntity.badRequest().body(Collections.singletonMap("error", "Failed to Delete"));
    }
}
