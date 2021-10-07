package com.Ivan.Values;

import com.Ivan.DBWork.DBWorking;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ValuesManagerBean implements ValuesManaging{

    private List<Values> valuesList = Collections.synchronizedList(new ArrayList<>());
    private List<Values> notSynchronizedValues = Collections.synchronizedList(new ArrayList<>());
    private DBWorking dbWorking;
    private boolean successStartSynchronise;

    @PostConstruct
    public void addLastRequests(){
        try {
            List<Values> lastValues = dbWorking.getLastValues();
            valuesList.addAll(lastValues);
            Collections.sort(valuesList);
            successStartSynchronise = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Проблемы с подключением к БД!");
            successStartSynchronise = false;
        }
    }


    @Override
    public void addValue(Values values) {
        notSynchronizedValues.add(values);
        if(synchronize()){
            System.out.println("Объект успешно добавлен и сонхронизорован");
        }else {
            System.out.println("Проблемы с синхронизацией!");
        }
    }

    @Override
    public List<Values> getAllValues() {
        if(dbWorking.isConnectionValid()){
            if(!successStartSynchronise){
                addLastRequests();
                successStartSynchronise = true;
            }
            boolean successSynch = synchronize();
            List<Values> values = new ArrayList<>(valuesList);
            Collections.sort(values);
            return values;
        }else {
            System.out.println("Нет подключения к бд!");
            List<Values> values = new ArrayList<>(valuesList);
            values.addAll(notSynchronizedValues);
            Collections.sort(values);
            return values;
        }
    }

    public DBWorking getDbWorking() {
        return dbWorking;
    }

    public void setDbWorking(DBWorking dbWorking) {
        this.dbWorking = dbWorking;
    }

    public boolean synchronize(){
        if(dbWorking.isConnectionValid()) {
            if(!successStartSynchronise){
                addLastRequests();
                successStartSynchronise = true;
            }

            Iterator iterator = notSynchronizedValues.iterator();
            while (iterator.hasNext()) {
                Values values = (Values) iterator.next();
                try {
                    dbWorking.addValues(values);
                    valuesList.add(values);
                    iterator.remove();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public List<Values> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<Values> valuesList) {
        this.valuesList = valuesList;
    }
}