package com.pane.absolutepane;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Objects;

/**
 * A class that represents a position of a node in the pane
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positon positon = (Positon) o;
        return Objects.equals(x, positon.x) && Objects.equals(y, positon.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
