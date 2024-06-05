package com.example.ee01.dao;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionUtilTest {
    @Test
    void test() {
        System.out.println(10 + 20);
    }

    @Test
    void connectTest() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr2", "1234");
        System.out.println("conn = " + conn);


    }

    @Test
    void connectTest2() throws Exception{
        Connection connection = ConnectionUtil.INSTANCE.getConnection();

        PreparedStatement ps = connection.prepareStatement("select sysdate from dual");

        ResultSet rs = ps.executeQuery();

        rs.next();

        String sysdate = rs.getString(1);

        System.out.println("sysdate = " + sysdate);

    }
}