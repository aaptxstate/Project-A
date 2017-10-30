public class ComplexNumbers {
    private double d, e, f, g, left, right;

    public ComplexNumbers (double coefD, double coefE, double coefF, double coefG) {
        d = coefD;
        e = coefE;
        f = coefF;
        g = coefG;
    }

    public String addition() {
        left = (double)Math.round((d + f) * 100) /100;
        right = (double)Math.round((e + g) * 100) /100;
        return left + "+" + right + "i";
    }

    public String multiplication() {
        left = (double)Math.round(((d * f) - (e * g)) * 100) /100;
        right = (double)Math.round(((d * g) + (e * f)) * 100) /100;
        return left + "+" + right + "i";
    }

}
