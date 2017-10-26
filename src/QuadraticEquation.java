package com.assignmentA;

import java.lang.Math;

public class QuadraticEquation {

    public double a, b, c, discriminant;

    public QuadraticEquation() {
        super();
        a = 0;
        b = 0;
        c = 0;
        discriminant = 0;
    }

    public QuadraticEquation(double coefA, double coefB, double coefC) {
        a = coefA;
        b = coefB;
        c = coefC;
        calcDiscriminant();
    }

    public void calcDiscriminant() {
        discriminant = (Math.pow(b, 2) - (4 * a * c));
    }

    public double getRoot1() {
        return (-b + Math.sqrt(discriminant))/(2 * a);
    }

    public double getRoot2() {
        return (-b - Math.sqrt(discriminant))/(2 * a);
    }

    public double getLeftSide() {
        return (-b/(2 * a));
    }

    public double getRightSide1() {
        return (- Math.sqrt(discriminant))/(2 * a);
    }

    public double getRightSide2() {
        return ( Math.sqrt(discriminant))/(2 * a);
    }

}
