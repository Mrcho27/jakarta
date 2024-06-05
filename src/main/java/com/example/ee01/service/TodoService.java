package com.example.ee01.service;

import com.example.ee01.dao.TodoDAO;
import com.example.ee01.dto.TodoDTO;

public enum TodoService {
    INSTANCE;

    private final TodoDAO todoDAO;

    TodoService() {
        todoDAO = new TodoDAO();
    }

    public void registerTodo(TodoDTO todoDTO) throws Exception{
//        todoDAO.insertTodo(todoDTO.toVO());
        
    }
}
