import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// TODO make main a menu for user to interact with and import all of our classes as a package
// TODO also may need to make an additional "solver" class for matrices
public class Main {
    public static void main(String[] args) throws IOException {
        //Quicksort
//        QuickSort sorter = new QuickSort();
//        int[] myArray = new int[(int) Math.floor(Math.random() * 101)];
//
//        for (int x = 0; x < myArray.length; x++) {
//            myArray[x] = (int) Math.floor(Math.random() * 101);
//        }
//        System.out.print("Quicksort\n");
//        System.out.print("Pre: " + myArray[0]);
//        for (int x = 1; x < myArray.length; x++) {
//            System.out.print(", " + myArray[x]);
//        }
//
//        sorter.sortThis(myArray);
//
//
//        System.out.print("\nPost: " + myArray[0]);
//        for (int x = 1; x < myArray.length; x++) {
//            System.out.print(", " + myArray[x]);
//        }
//
//
////        Matrices
//        System.out.print("\nMatrices \n");
//        Matrix firstMatrix = new Matrix(6, 3);
//        Matrix secondMatrix = new Matrix(3, 5);
//        System.out.print("MATRIX 1: \n");
//        firstMatrix.printMatrix();
//        System.out.print("MATRIX 2: \n");
//        secondMatrix.printMatrix();
//        System.out.print("MATRIX 1 post addition: \n");
//        firstMatrix.addMatrix(secondMatrix);
//        firstMatrix.printMatrix();
//
//        Matrix multipleMatrix = new Matrix(firstMatrix, secondMatrix);
//        System.out.print("MULTIPLIED MATRIX: \n");
//        multipleMatrix.printMatrix();
//
//          // number tool
//        NumberTool tool = new NumberTool();
//        System.out.print("Strict Print\n");
//        tool.strictPrint(2);
//        System.out.print("\nBinary Print\n");
//        tool.binaryPrint(5);

//        Dictionary dictionary = new Dictionary();
//        String[] strarr = {"Computer","Fruit"};
//        Definition def1 = new Definition("Apple", strarr);
//        Definition def2 = new Definition("Java", new String[] {"Coffee", "CS Language"});
//        Definition def3 = new Definition("Mug", new String[] {"Container", "To Steal"});
//        Definition def4 = new Definition("Iron", new String[] {"Metal", "Tool"});
//        Definition def5 = new Definition("Bull", new String[] {"Male Cow", "A false Statement"});
//        Definition[] defs = new Definition[] {def1, def2, def3, def4, def5};
//        for(int x = 0; x < 5; x++) {
//            dictionary.add(defs[x]);
//        }
//        for (int x = 0; x < 5; x++) {
//            dictionary.query(defs[x].name);
//        }
        FileReader reader = null;
        FileWriter writer = null;
        Dictionary dictionary = new Dictionary();
        try {
            reader = new FileReader("/Users/Arthur/dictionary.txt");
            writer = new FileWriter("/Users/Arthur/newFile.txt");
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
            if (writer != null) {
                writer.close();
        }
        }

        String[] names = {"Java", "Iron", "Pork","Bull","Mug","Monitor","Flavor","Textbook","Isis","Drumstick"};
        for (int x = 0; x < 9; x++) {
            dictionary.query(names[x]);
        }

//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        dictionary.query(name);
    }
}
