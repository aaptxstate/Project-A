// TODO make main a menu for user to interact with and import all of our classes as a package
// TODO also may need to make an additional "solver" class for matrices
public class Main {
    public static void main(String[] args) {
        //Quicksort
//        QuickSort sorter = new QuickSort();
//        int[] myArray = new int[(int) Math.floor(Math.random() * 101)];
//
//        for (int x = 0; x < myArray.length; x++) {
//            myArray[x] = (int) Math.floor(Math.random() * 101);
//        }
//
//        System.out.print("Pre: " + myArray[0]);
//        for (int x = 1; x < myArray.length; x++) {
//            System.out.print(", " + myArray[x]);
//        }
//
//        sorter.sortThis(myArray);
//        System.out.print("\n");
//
//        System.out.print("Post: " + myArray[0]);
//        for (int x = 1; x < myArray.length; x++) {
//            System.out.print(", " + myArray[x]);
//        }


        // Matrix
//        System.out.print("MATRIX: \n");
//        Matrix firstMatrix = new Matrix(14, 3);
//        Matrix secondMatrix = new Matrix(3, 5);
//        System.out.print("MATRIX 1: \n");
//        firstMatrix.printMatrix();
//        System.out.print("MATRIX 2: \n");
//        secondMatrix.printMatrix();
////        System.out.print("MATRIX 1 post addition: \n");
////        firstMatrix.addMatrix(secondMatrix);
////        firstMatrix.printMatrix();
//
//        Matrix multipleMatrix = new Matrix(firstMatrix, secondMatrix);
//        System.out.print("MULTIPLIED MATRIX: \n");
//        multipleMatrix.printMatrix();

        NumberTool tool = new NumberTool();
        tool.strictPrint(3);
    }
}
