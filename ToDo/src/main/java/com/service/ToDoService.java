package com.service;


import com.model.ToDo;
import com.repository.IToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    @Autowired//Used for dependency injection
    IToDoRepository repository;

    //Retrieve all to do items
    public List<ToDo> getAllToDoItems(){
        ArrayList<ToDo> todoList = new ArrayList<>();
        //get all to-do items from the db, iterates through them and adds them to todolist
        repository.findAll().forEach(todo -> todoList.add(todo));
        return todoList;

    }

    //retrieve a to-do by id
    public ToDo getToDoItemById(Long id)
    {return repository.findById(id).orElse(null);
    } //extract the actual to-do object

    //update to-do status
    public boolean updateStatus(Long id){
        ToDo todo = getToDoItemById(id);
        todo.setStatus("Completed");
        return saveOrUpdateToDoItem(todo);
    }//update the status as completed

    //save or update to-do
    public boolean saveOrUpdateToDoItem (ToDo todo){
        ToDo updatedObj = repository.save(todo);
        if (getToDoItemById(updatedObj.getId()) != null) {
            return true;
        }return false; //save or update an item if exist
    }

    //delete a to-do by id
    public boolean deleteToDoItem(Long id){
        repository.deleteById(id);
        if (repository.findById(id).isEmpty()){
            return true;
        }return false;
    }




}
