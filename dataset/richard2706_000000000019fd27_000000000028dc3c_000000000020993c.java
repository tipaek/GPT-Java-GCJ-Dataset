import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Matrix {

    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isNaturalLatinSquare() {
        return numColumnsRepeatedValues() == 0 && numRowsRepeatedValues() == 0;
    }

    /*
     * Returns number of rows with repeated values
     */
    public int numRowsRepeatedValues() {
        int numRows = 0;
        for (int[] row : matrix) {
            if (containsRepeatedValues(row)) {
                numRows++;
            }
        }
        return numRows;
    }

    public int numColumnsRepeatedValues() {
        int numColumns = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (containsRepeatedValues(column)) {
                numColumns++;
            }
        }
        return numColumns;
    }

    private boolean containsRepeatedValues(int[] array) {
        ArrayList<Integer> uniqueValues = new ArrayList<>();
        for (int element : array) {
            if (uniqueValues.contains(element)) {
                return true;
            } else {
                uniqueValues.add(element);
            }
        }
        return false;
    }

    public int trace() {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            total += matrix[i][i];
        }
        return total;
    }

    @Override
    public String toString() {
        String string = "";
        for (int[] row : matrix) {
            for (int value : row) {
                string += value + " ";
            }
            string += "\n";
        }
        return string;
    }
}

class Main {

    private static int numTestCases;

    public static void main(String[] args) {
        /*File inputFile = new File("input.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(0);
        }*/
        
        Scanner scanner = new Scanner(System.in);

        numTestCases = scanner.nextInt();
        scanner.nextLine();
        
        int x = 1;
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            scanner.nextLine();

            int[][] inputMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    inputMatrix[i][j] = scanner.nextInt();
                }
                scanner.nextLine();
            }

            Matrix matrix = new Matrix(inputMatrix);

            // System.out.println(matrix);
            // System.out.println("Trace: " + matrix.trace());
            // System.out.println("Num rows with repeated values: " + matrix.numRowsRepeatedValues());
            // System.out.println("Num columns with repeated values: " + matrix.numColumnsRepeatedValues());
            // System.out.println();

            int k = matrix.trace();
            int r = matrix.numRowsRepeatedValues();
            int c = matrix.numColumnsRepeatedValues();
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
            x++;
        }
    }
}
