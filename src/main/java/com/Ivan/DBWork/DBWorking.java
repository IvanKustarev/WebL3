package com.Ivan.DBWork;

import com.Ivan.Values;

import java.util.List;

public interface DBWorking {
    public void addValues(Values values);
    public List<Values> getLastValues();
}
