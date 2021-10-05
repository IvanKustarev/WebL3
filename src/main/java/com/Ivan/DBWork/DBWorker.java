package com.Ivan.DBWork;

import com.Ivan.Values;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBWorker implements DBWorking {

    Connection connection;

    //здесь нужно что-то сделать с пробросом ошибки
    public DBWorker() throws SQLException {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
    }

    @Override
    public void addValues(Values values) {

    }

    @Override
    public List<Values> getLastValues() {
        return null;
    }
}
