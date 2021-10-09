package com.Ivan;

import com.Ivan.AreaChecker.AreaChecking;
import com.Ivan.Values.Values;
import com.Ivan.Values.ValuesManaging;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

public class ManagerBean {

    private UIComponent errWindow;

    private double x = 0;
    private double y = 0;
    private double r = 0;

    private AreaChecking areaChecking;
    private ValuesManaging valuesManaging;
    private List<Values> valuesList;
    private Values resultValue;

    public String doAction() {
        resultValue = new Values(x, y, r, new Date());
        resultValue.setCatch(areaChecking.checkArea(resultValue));
        valuesManaging.addValue(resultValue);
        return updateValuesList();
    }

    public String updateValuesList(){
        boolean successSynchronize = valuesManaging.synchronize();
        if(!successSynchronize){
            FacesContext.getCurrentInstance().addMessage(errWindow.getClientId(), new FacesMessage("Синхронизация невозможна! Проверьте соединение с БД!"));
        }
        valuesList = valuesManaging.getAllValues();
        return Returns.TO_MAIN.toString();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public AreaChecking getAreaChecking() {
        return areaChecking;
    }

    public void setAreaChecking(AreaChecking areaChecking) {
        this.areaChecking = areaChecking;
    }

    public ValuesManaging getValuesManaging() {
        return valuesManaging;
    }

    public void setValuesManaging(ValuesManaging valuesManaging) {
        this.valuesManaging = valuesManaging;
    }

    public List<Values> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<Values> valuesList) {
        this.valuesList = valuesList;
    }

    public Values getResultValue() {
        return resultValue;
    }

    public void setResultValue(Values resultValue) {
        this.resultValue = resultValue;
    }

    public UIComponent getErrWindow() {
        return errWindow;
    }

    public void setErrWindow(UIComponent errWindow) {
        this.errWindow = errWindow;
    }
}
