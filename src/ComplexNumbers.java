package com.assignmentA;

public class ComplexNumbers {
    private double d, e, f, g, left, right;

    public ComplexNumbers (double coefD, double coefE, double coefF, double coefG) {
        d = coefD;
        e = coefE;
        f = coefF;
        g = coefG;
    }

    public String addition() {
        left = d + f;
        right = e + g;
        return left + "+" + right + "i";
    }

    public String multiplication() {
        left = ((d * f) - (e * g));
        right = ((d * g) + (e * f));
        return left + "+" + right + "i";
    }

}
