package com.dlut.yonglun.location.dto;

/**
 * @author yonglunyao
 */
public class LocationResponse {
    int floor;
    double south;
    double east;

    public LocationResponse(int floor, double south, double east) {
        this.floor = floor;
        this.south = south;
        this.east = east;
    }

    public int getFloor() {
        return floor;
    }

    public double getSouth() {
        return south;
    }

    public double getEast() {
        return east;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setSouth(double south) {
        this.south = south;
    }

    public void setEast(double east) {
        this.east = east;
    }
}
