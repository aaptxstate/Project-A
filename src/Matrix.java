public class Matrix {

    private int rows, columns;
    private int[][] matrix;
    private Throwable zeroSize = new Throwable("Error: Rows and Columns cannot be less than '1'");
    // constructor to formulate new matrix
    Matrix(int rows, int columns) {
        try {
            if (rows < 1 || columns < 1) {
                throw zeroSize;
            }
            this.rows = rows;
            this.columns = columns;
            matrix = new int[rows][columns];

            for (int rw = 0; rw < rows; rw++) {
                for (int col = 0; col < columns; col++) {
                    matrix[rw][col] = (int) Math.floor(Math.random() * 100);
                }
            }
        }
        catch (Throwable zeroSize) {
            zeroSize.printStackTrace();
        }

    }

    // constructor for new matrix by multiplication
    // of 2 declared matrices
    Matrix(Matrix first, Matrix second) {
        if (first.getColumns() == second.getRows()) {
            this.rows = first.getRows();
            this.columns = second.getColumns();
            matrix = new int[first.getRows()][second.getColumns()];
            for (int col = 0; col < this.getColumns(); col++) {
                int sum;
                int commonality = first.getColumns(); // number to handle summation loop
                for (int rw = 0; rw < this.getRows(); rw++) {
                    sum = 0;
                    // summation loop
                    for (int x = 0; x < commonality; x++) {
                        sum += first.getValue(rw, x) * second.getValue(x, col);
                    }
                    matrix[rw][col] = sum;
                }

            }
        } else {
            System.out.println("Matrices cannot be multiplied");
        }
    }
    public void multiplyMatrix(Matrix multiplier) {

        if (this.columns == multiplier.getRows()) {
            Matrix tempMatrix = new Matrix(this, multiplier);
            tempMatrix.printMatrix();
        } else {
            System.out.println("Matrices cannot be multiplied");
        }
    }
    public void addMatrix(Matrix second) {
        if (rows == second.getRows() && columns == second.getColumns()) {
            for (int rw = 0; rw < rows; rw++) {
                for (int col = 0; col < columns; col++) {
                    matrix[rw][col] += second.getValue(rw,col);
                }
            }
        }   else {
            System.out.println("Cannot add due to: Mismatched sizes");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // TODO need something here to throw catch first if
    public int getValue(int row, int col) {
        if (row < 0 || col < 0) {
            System.out.println("Error: Value does not exist");
        } else {
            return matrix[row][col];
        }
        return -1;
    }
    public void printMatrix() {
        for (int x = 0; x <= columns; x++) {
            System.out.print("\t___");
            if (x == columns) { System.out.print('\n'); }
        }
        for (int r = 0; r < rows; r++) {
            System.out.print("| ");
            for (int c = 0; c < columns; c++) {
                System.out.print(matrix[r][c] + "\t");
            }
            System.out.print(" \t|\n");
        }
            for (int x = 0; x <= columns; x++) {
                System.out.print("\t___");
                if (x == columns) { System.out.print('\n'); }
        }
    }




}
