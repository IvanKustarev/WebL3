package com.Ivan.DBWork;

import com.Ivan.Values;

import java.util.List;

public interface DBWorking {
    public void addValues(double x, double y, double r, boolean isCatch);
    public List<Values> getLastValues();
}
