package com.Ivan.Values;

import java.util.Date;

public class Values {
    private double x;
    private double y;
    private double r;
    private boolean isCatch ;
    private Date createDate;

    public Values(double x, double y, double r, boolean isCatch, Date date) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isCatch = isCatch;
        this.createDate = date;
    }

    public Values(double x, double y, double r, Date date) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.createDate = date;
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

    public boolean isCatch() {
        return isCatch;
    }

    public void setCatch(boolean aCatch) {
        isCatch = aCatch;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
