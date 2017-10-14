class Matrix {

    private int rows, columns;
    private int[][] matrix;

    // constructor to formulate new matrix
    // TODO Needs error handling for non int values
    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];

        for (int rw = 0; rw < rows; rw++) {
            for (int col = 0; col < columns; col++) {
                matrix[rw][col] = (int) Math.floor(Math.random() * 100);
            }
        }
    }

    // constructor for new matrix by multiplication
    // of 2 declared matrices
    // TODO needs error handling for
    // if first matrix cols != second matrix rows
    // if Matrices are not passed into
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
            System.out.print("Matrices cannot be multiplied\n");
        }
    }

    // TODO error handling if not same size
    public void addMatrix(Matrix second) {
        if (rows == second.getRows() && columns == second.getColumns()) {
            for (int rw = 0; rw < columns; rw++) {
                for (int col = 0; col < rows; col++) {
                    matrix[rw][col] += second.getValue(rw,col);
                }
            }
        }   else {
            System.out.print("Cannot add due to: Mismatched sizes\n");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    // TODO error handling
    // if no int values passed into row and col && if those ints are out of range
    public int getValue(int row, int col) {
        return matrix[row][col];
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
                System.out.print("___");
                if (x == columns) { System.out.print('\n'); }
        }
    }




}
