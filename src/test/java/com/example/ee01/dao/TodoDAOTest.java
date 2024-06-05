package com.example.ee01.dao;

import com.example.ee01.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoDAOTest {
    private TodoDAO dao;

    @BeforeEach
    void setUp() {
        dao = new TodoDAO();
    }

    @Test
    void selectTime() {
        System.out.println(dao.selectTime());
    }

    @Test
    void selectTime2() throws Exception {
        System.out.println(dao.selectTime2());
    }

    @Test
    void insertTodo() throws Exception {
        TodoVO vo =
                TodoVO.builder()
                .content("test1")
                .todoDate(LocalDate.now())
                .finished(false)
                .build();

        dao.insertTodo(vo);
    }

    @Test
    void selectAll() throws Exception{
        List<TodoVO> todoVOList = dao.selectAll();
        System.out.println("todoVOList = " + todoVOList);
    }

}