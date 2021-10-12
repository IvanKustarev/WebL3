package com.Ivan.DBWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private Connection connection;

    public Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:8999/studs", "s309681", "yvr557");
        try {
            connection.setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
