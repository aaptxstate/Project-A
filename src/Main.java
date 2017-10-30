import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// TODO make main a menu for user to interact with and import all of our classes as a package
// TODO also may need to make an additional "solver" class for matrices
public class Main {
    public static void main(String[] args) throws IOException {

        char userChoice = 'z';
        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
        Main main = new Main();
        do {
            main.printMenu();
            userChoice = scanner.next().charAt(0);
            userChoice = Character.toUpperCase(userChoice);
            switch (userChoice) {
                case 'A':
                    main.runQuadraticTest();
                    break;
                case 'B':
                    main.runMatrixTest();
                    break;
                case 'C':
                    main.runAutoMatrixTest();
                    break;
                case 'D':
                    main.runAutoSortTest();
                    break;
                case 'E':
                    main.runAutoNumberToolTest();
                    break;
                case 'F':
                    main.runAutoDictionaryTest();
                    break;
                case 'G':
                    main.runDictionaryTest();
                    break;
                case 'Q':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Whoa that's not an option friend!");
                    break;
            }
            System.out.println();
        } while (userChoice != 'Q');




//        main.runAutoNumberToolTest();
//        main.runAutoSortTest();
//        main.runAutoDictionaryTest();
    }
    public void runQuadraticTest(){
        String filename = "txt-files/quadraticArgs.txt";
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
    public void runMatrixTest() {
        Scanner scanner = new Scanner(System.in);
        int userRows1;
        int userCols1;
        int userRows2;
        int userCols2;
        Matrix userMatrix1;
        Matrix userMatrix2;
        try {
            System.out.print("Enter number of rows for Matrix 1: ");
            userRows1 = scanner.nextInt();
            System.out.print("Enter number of cols for Matrix 1: ");
            userCols1 = scanner.nextInt();
            System.out.print("Enter number of rows for Matrix 2: ");
            userRows2 = scanner.nextInt();
            System.out.print("Enter number of cols for Matrix 2: ");
            userCols2 = scanner.nextInt();
            userMatrix1 = new Matrix(userRows1, userCols1);
            userMatrix2 = new Matrix(userRows2, userCols2);
            userMatrix1.printMatrix();
            userMatrix2.printMatrix();
            System.out.println("This be that new mult");
            userMatrix1.multiplyMatrix(userMatrix2);
        } catch (Exception x) {
            System.out.println("Error: Please enter only numbers");
        }


        System.out.println();
    }

    public void runAutoMatrixTest(){
        System.out.print("\nMatrices \n");
        Matrix firstMatrix = new Matrix(6, 3);
        Matrix secondMatrix = new Matrix(3, 5);
        System.out.print("MATRIX 1: \n");
        firstMatrix.printMatrix();
        System.out.print("MATRIX 2: \n");
        secondMatrix.printMatrix();
        System.out.print("MATRIX 1 post addition: \n");
        firstMatrix.addMatrix(secondMatrix);
        firstMatrix.printMatrix();

        Matrix multipleMatrix = new Matrix(firstMatrix, secondMatrix);
        System.out.print("MULTIPLIED MATRIX: \n");
        multipleMatrix.printMatrix();
    }
    public void runAutoSortTest(){
        QuickSort sorter = new QuickSort();
        int[] myArray = new int[(int) Math.floor(Math.random() * 101)];

        for (int x = 0; x < myArray.length; x++) {
            myArray[x] = (int) Math.floor(Math.random() * 101);
        }
        System.out.print("Quicksort\n");
        System.out.print("Pre: " + myArray[0]);
        for (int x = 1; x < myArray.length; x++) {
            System.out.print(", " + myArray[x]);
        }

        sorter.sortThis(myArray);


        System.out.print("\nPost: " + myArray[0]);
        for (int x = 1; x < myArray.length; x++) {
            System.out.print(", " + myArray[x]);
        }
    }
    public void runAutoNumberToolTest(){
        // number tool
        NumberTool tool = new NumberTool();
        System.out.print("Strict Print\n");
        tool.strictPrint(2);
        System.out.print("\nBinary Print\n");
        tool.binaryPrint(5);
    }

    public void runAutoDictionaryTest() throws IOException {
        FileReader reader = null;
        Dictionary dictionary = new Dictionary();
        try {
            reader = new FileReader("txt-files/dictionary.txt");
            int x;
            String fileString = "";
            String nameString = "";
            String[] defs = new String[2];
            Definition definition;
            while ((x = reader.read()) != -1) {
                switch (x) {
                    case 10:    // new line
                        defs[1] = fileString;
                        definition = new Definition(nameString, defs);
                        dictionary.add(definition);
                        fileString = "";
                        break;
                    case 44:    // comma
                        defs[0] = fileString;
                        fileString = "";
                        break;
                    case 61:    // equals sign
                        nameString = fileString;
                        fileString = "";
                        break;
                    case 62:    // greater than symbol, do nothing
                        break;
                    default:
                        fileString += (char) x;
                        break;
                }
            }
        } catch(IOException error) {
            System.out.print("\nidk why " + error + " happened");
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }

        String[] names = {"Java", "Iron", "Pork","Bull","Mug","Monitor","Flavor","Textbook","Isis","Drumstick"};
        for (int x = 0; x < 9; x++) {
            dictionary.query(names[x]);
        }
    }

    public void runDictionaryTest() throws IOException {
        FileReader reader = null;
        Dictionary dictionary = new Dictionary();
        try {
            reader = new FileReader("txt-files/dictionary.txt");
            int x;
            String fileString = "";
            String nameString = "";
            String[] defs = new String[2];
            Definition definition;
            while ((x = reader.read()) != -1) {
                switch (x) {
                    case 10:    // new line
                        defs[1] = fileString;
                        definition = new Definition(nameString, defs);
                        dictionary.add(definition);
                        fileString = "";
                        break;
                    case 44:    // comma
                        defs[0] = fileString;
                        fileString = "";
                        break;
                    case 61:    // equals sign
                        nameString = fileString;
                        fileString = "";
                        break;
                    case 62:    // greater than symbol, do nothing
                        break;
                    default:
                        fileString += (char) x;
                        break;
                }
            }
        } catch(IOException error) {
            System.out.println("idk why " + error + " happened");
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
        // Normally we would convert the query to fit our format but the tool for that is not found in util package
        System.out.println("Please type a definition to query. Note dictionary is case sensitive and all Definitions begin with a capital. Enter 'Quit' to end.");
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while(!name.equals("Quit")) {
            name = scanner.nextLine();
            dictionary.query(name);
            System.out.println("Please type a definition to query. Enter 'Quit' to end.");
        }
    }

    public void printMenu() {
        System.out.println("Menu Options");
        System.out.println("-------------");
        System.out.println("A) Test Quadratic Function");
        System.out.println("B) Test Matrix with your input");
        System.out.println("C) Test Matrix automatically");
        System.out.println("D) Test QuickSort");
        System.out.println("E) Test Ascending Numbers & Binary Print");
        System.out.println("F) Test Dictionary Automatically");
        System.out.println("G) Test Dictionary with your input");
        System.out.println("Q) Quit");
        System.out.print("Please enter an option: ");
    }
}
