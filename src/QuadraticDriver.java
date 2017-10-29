package com.assignmentA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;
import java.io.File;

public class QuadraticDriver {

    public static void main(String[] args) throws Exception {

        String filename = "C:/Users/brian/OneDrive/Documents/School/CS 3354/assignmentA/.idea/com/assignmentA/quadraticArgs.txt";
        File file = new File(filename);
        if (file.exists()) {
            try {
                FileInputStream fInputStream = new FileInputStream(filename);
                BufferedReader br = new BufferedReader(new InputStreamReader(fInputStream));
                String content = null;
                while ((content = br.readLine()) != null) {
                    StringTokenizer str = new StringTokenizer(content, ",");
                    while (str.hasMoreElements()) {

                        double coA = Double.parseDouble(str.nextElement().toString());
                        double coB = Double.parseDouble(str.nextElement().toString());
                        double coC = Double.parseDouble(str.nextElement().toString());

                        QuadraticEquation quad = new QuadraticEquation(coA, coB, coC);
                        double coP, coQ;

                        if (quad.calcDiscriminant() > 0) {
                            coP = quad.getRoot1();
                            coQ = quad.getRoot2();
                            System.out.println("First root is: " + coP);
                            System.out.println("Second root is: " + coQ);
                            System.out.println("p + q is: " + (double)Math.round((coP + coQ) * 100) /100);
                            System.out.println(" -b / a is: " + (double)Math.round(-(quad.b / quad.a) * 100) /100);
                            System.out.println("pq is: " + (double)Math.round((coP * coQ) * 100) /100);
                            System.out.println("c/a is: " + (double)Math.round((quad.c / quad.a) * 100) /100);
                        } else if (quad.calcDiscriminant() == 0) {
                            coP = quad.getRoot1();
                            coQ = coP;
                            System.out.println("Both roots are: " + coP);
                            System.out.println("p + q is: " + (double)Math.round((coP + coQ) * 100) /100);
                            System.out.println(" -b / a is: " + (double)Math.round(-(quad.b / quad.a) * 100) /100);
                            System.out.println("pq is: " + (double)Math.round((coP * coQ) * 100) /100);
                            System.out.println("c/a is: " + (double)Math.round((quad.c / quad.a) * 100) /100);
                        } else if (quad.calcDiscriminant() < 0) {
                            System.out.println("First root is: " + (double) Math.round(quad.getLeftSide() * 100) / 100 + " + " + (double) Math.round(quad.getRightSide1() * 100) / 100 + "i");
                            System.out.println("Second root is: " + (double) Math.round(quad.getLeftSide() * 100) / 100 + " + " + (double) Math.round(quad.getRightSide2() * 100) / 100 + "i");
                            ComplexNumbers comp = new ComplexNumbers(quad.getLeftSide(), quad.getRightSide1(), quad.getLeftSide(), quad.getRightSide2());
                            System.out.println("p + q is: " + comp.addition());
                            System.out.println(" -b / a is: " + (double)Math.round(-(quad.b / quad.a) * 100) /100);
                            System.out.println("pq is: " + comp.multiplication());
                            System.out.println("c/a is: " + (double)Math.round((quad.c / quad.a) * 100) /100);
                        }
                        System.out.println("");
                    }
                }
                br.close();
            }
            catch (FileNotFoundException e) { e.printStackTrace(); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }

}
