package com.Ivan.DBWork;

import com.Ivan.Values.Values;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBWorker implements DBWorking {

    private Connector connector = new Connector();
    private Connection connection;

    public DBWorker() {
        try {
            connection = connector.connect();
        } catch (SQLException throwables) { }
    }

    @Override
    public void addValues(Values values) {

    }

    @Override
    public List<Values> getLastValues() {
        return new ArrayList<Values>();
    }

    @Override
    public boolean supportConnection() {
        if (connection != null) {
            return true;
        } else {
            try {
                connection = connector.connect();
                return true;
            } catch (SQLException throwables) {
                return false;
            }
        }
    }
}
