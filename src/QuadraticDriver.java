package com.assignmentA;

import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.io.IOException;

public class QuadraticDriver {

    public static void main(String[] args) throws Exception {

        /*String filename = "data/quadraticArgs.txt";
        File file = new File(filename);
        if (file.exists()) { */
            /*try {
                FileInputStream fInputStream = new FileInputStream(filename);
                BufferedReader br = new BufferedReader(new InputStreamReader(fInputStream));
                String content = null;
                while ((content = br.readline()) != null) {
                    String line = content;
                    StringTokenizer str = new StringTokenizer(line, ",");
                    while (str.hasMoreElements()) {

                        double coA = Double.parseDouble(str.nextElement().toString());
                        double coB = Double.parseDouble(str.nextElement().toString());
                        double coC = Double.parseDouble(str.nextElement().toString()); */

                        QuadraticEquation quad = new QuadraticEquation(3, 4, 5);
                        double coP, coQ;
                        if (quad.discriminant > 0) {
                            coP = quad.getRoot1();
                            coQ = quad.getRoot2();
                            System.out.println("First root is: " + coP);
                            System.out.println("Second root is: " + coQ);
                            System.out.println("p + q is: " + (coP + coQ) );
                            System.out.println(" -b / a is: " + (-(quad.b/quad.a)));
                            System.out.println("pq is: " + (coP * coQ));
                            System.out.println("c/a is: " + (quad.c/quad.a) );
                        }
                        else if (quad.discriminant == 0) {
                            coP = coQ = quad.getRoot1();
                            System.out.println("Both roots are: " + coP);
                            System.out.println("p + q is: " + (coP + coQ) );
                            System.out.println(" -b / a is: " + (-(quad.b/quad.a)));
                            System.out.println("pq is: " + (coP * coQ));
                            System.out.println("c/a is: " + (quad.c/quad.a) );
                        }
                        else if (quad.discriminant < 0) {
                            System.out.println("First root is: " + quad.getLeftSide() + " + " + quad.getRightSide1() + "i");
                            System.out.println("First root is: " + quad.getLeftSide() + " + " + quad.getRightSide2() + "i");
                            ComplexNumbers comp = new ComplexNumbers(quad.getLeftSide(), quad.getRightSide1(), quad.getLeftSide(), quad.getRightSide2());
                            System.out.println("p + q is: " + comp.addition());
                            System.out.println(" -b / a is: " + (-(quad.b/quad.a)));
                            System.out.println("pq is: " + comp.multiplication());
                            System.out.println("c/a is: " + (quad.c/quad.a) );
                        }
                    //}

                //}
            //}
            // catch (FileNotFoundException e) { e.printStackTrace(); }
            // catch (IOFielException e) { e.printStackTrace(); }
            /* finally {
                try {
                    in.close();
                }
                catch (IOException e) { e.printStackTrace();}
            }
        }*/
    }

}
