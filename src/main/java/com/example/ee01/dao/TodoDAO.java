package com.example.ee01.dao;

import com.example.ee01.domain.TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    public String selectTime() {
        String now = null;

        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement ps = conn.prepareStatement("select sysdate from dual");
                ResultSet rs = ps.executeQuery();
        ) {
            if (rs.next()) {
                now = rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return now;
    }

    public String selectTime2() throws Exception{
        String now = null;


//            @Cleanup은 롬복이 지원하는 어노테이션이다.
//            해당 객체를 자동으로 close() 해준다.
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement ps = conn.prepareStatement("select sysdate from dual");
            @Cleanup ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                now = rs.getString(1);
            }

            return now;
    }

    public void insertTodo(TodoVO todoVO) throws Exception{
        String sql = "insert into TBL_TODO (TODO_ID, CONTENT, TODO_DATE, FINISHED) VALUES (SEQ_TODO.nextval, ?, ?, ?)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, todoVO.getContent());
        ps.setDate(2, Date.valueOf(todoVO.getTodoDate()));
        ps.setBoolean(3, todoVO.isFinished());

        ps.executeUpdate();
    }

    public List<TodoVO> selectAll() throws Exception{
        String sql = "select TODO_ID, CONTENT, TODO_DATE, FINISHED" +
                " from TBL_TODO";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = ps.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while (rs.next()){
            TodoVO vo = TodoVO.builder()
                    .todoId(rs.getLong(1))
                    .content(rs.getString(2))
                    .todoDate(rs.getDate(3).toLocalDate())
                    .finished(rs.getBoolean(4))
                    .build();

            list.add(vo);
        }

        return list;

    }

    public TodoVO selectById(Long todoId) throws Exception{
        String sql = """ 
        select TODO_ID, CONTENT, TODO_DATE, FINISHED 
        from TBL_TODO
        where TODO_ID = ?
        """;

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setLong(1, todoId);

        @Cleanup ResultSet rs = ps.executeQuery();

        if(rs.next()){
            return TodoVO.builder()
                    .todoId(rs.getLong(1))
                    .content(rs.getString(2))
                    .todoDate(rs.getDate(3).toLocalDate())
                    .finished(rs.getBoolean(4))
                    .build();

        }

        return null;
    }


}
