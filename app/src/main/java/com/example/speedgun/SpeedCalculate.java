package com.example.speedgun;

public class SpeedCalculate {

    private double speed;
    private double distance;

    private double coefficient;

    private int x;
    private int y;

    private double angle;


    public void SpeedCalculate(double distance, double angle, int x, int y){


    }


    public double getCoefficient() {
        return coefficient;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
