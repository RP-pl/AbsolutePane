package com.pane.absolutepane;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Positon {
    private DoubleProperty x;
    private DoubleProperty y;

    public Positon(DoubleProperty x, DoubleProperty y) {
        this.x = x;
        this.y = y;
    }
    public Positon() {
        this.x = null;
        this.y = null;
    }

    public Positon(double x,double y){
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
    }

    public DoubleProperty getX() {
        return x;
    }
    public void setX(DoubleProperty x) {
        this.x = x;
    }
    public DoubleProperty getY() {
        return y;
    }
    public void setY(DoubleProperty y) {
        this.y = y;
    }
}
