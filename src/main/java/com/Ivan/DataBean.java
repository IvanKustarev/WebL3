package com.Ivan;

import com.Ivan.AreaChecker.AreaChecking;
import com.Ivan.DBWork.DBWorking;

public class DataBean {
    private double x = 0;
    private double y = 0;
    private double r = 0;

    private DBWorking dbWorker;
    private AreaChecking areaChecker;

    public String doAction(){
        boolean isCatch = areaChecker.checkArea(x, y, r);
        return null;
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

    public DBWorking getDbWorker() {
        return dbWorker;
    }

    public void setDbWorker(DBWorking dbWorker) {
        this.dbWorker = dbWorker;
    }

    public AreaChecking getAreaChecker() {
        return areaChecker;
    }

    public void setAreaChecker(AreaChecking areaChecker) {
        this.areaChecker = areaChecker;
    }
}
