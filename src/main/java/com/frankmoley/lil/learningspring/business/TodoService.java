package com.frankmoley.lil.learningspring.business;

import com.frankmoley.lil.learningspring.data.Todo;
import com.frankmoley.lil.learningspring.data.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public String getTodos(){
        return todoRepository.getTodos();
    }
}
