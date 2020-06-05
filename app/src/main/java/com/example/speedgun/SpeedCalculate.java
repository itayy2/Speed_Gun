package com.example.speedgun;

public class SpeedCalculate {

    private double speedX;
    private double speedY;
    private double totalSpeed;

    private double distance;

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int n;
    private int m;

    private double proportionX1;
    private double proportionY1;
    private double proportionX2;
    private double proportionY2;

    private double numericalApertureAngle;

    private double dt;

    private double dTheta;
    private double dPhi;

    private double thetaDot;
    private double phiDot;


    public void SpeedCalculate(double distance, double numericalApertureAngle ,double dt , int n, int m){

        this.dt = dt / 1000;

        this.distance = distance;

        this.numericalApertureAngle = numericalApertureAngle;

        this.n = n;
        this.m = m;
    }

    public double getSpeedX(int x1, int x2) {

        this.proportionX1 = (double) ((x1) / (this.n));
        this.proportionX2 = (double) ((x2) / (this.n));

        this.dTheta = (double) (((this.proportionX2) - (this.proportionX1)) *(this.numericalApertureAngle));

        this.thetaDot = (double) ((this.dTheta) / (this.dt));

        this.speedX = (double) ((this.thetaDot) * (this.distance));
        return this.speedX;
    }

    public double getSpeedY(int y1, int y2) {

        this.proportionY1 = (double) (y1 / this.n); // divided by n and not m because we want to stay with
        this.proportionY2 = (double) (y2 / this.n); // the same Numerical Aperture angle. Important, reduces error by 19%

        this.dPhi = (double) (((this.proportionY2) - (this.proportionY1)) *(this.numericalApertureAngle));

        this.phiDot = (double) ((this.dPhi) / (this.dt));

        this.speedY = (double) ((this.phiDot) * (this.distance));
        return this.speedY;
    }

    public double getTotalSpeed() {
        this.totalSpeed = (Math.sqrt(((this.speedX) * (this.speedX))  + ((this.speedY) * (this.speedY))));
        return this.totalSpeed;
    }

    public double getDistance() {
        return distance;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setNumericalApertureAngle(double numericalApertureAngle) {
        this.numericalApertureAngle = numericalApertureAngle;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y1) {
        this.y2 = y2;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setDt(double dt) {
        this.dt = dt / 1000;
    }

    public double getNumericalApertureAngle() {
        return numericalApertureAngle;
    }
}
