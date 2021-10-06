package com.Ivan.Values;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValuesManager implements ValuesManaging{

    private List<Values> valuesList = Collections.synchronizedList(new ArrayList<Values>());

    @Override
    public void addValue(Values values) {
        valuesList.add(values);
    }

    @Override
    public List<Values> getAllValues() {
        return new ArrayList<>(valuesList);
    }
}
