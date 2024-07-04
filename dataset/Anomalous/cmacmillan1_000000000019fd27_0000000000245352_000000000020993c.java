import java.util.*;
import java.io.*;

class Solution {

    public static Matrix readFromScanner(Scanner in) {
        int size = in.nextInt();
        Matrix matrix = new Matrix(size, size);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                matrix.setValue(x, y, in.nextInt());
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            Matrix matrix = readFromScanner(in);
            runOutput(matrix, i + 1); // Case numbers should start from 1
        }
    }

    public static void runOutput(Matrix matrix, int caseId) {
        int trace = calculateTrace(matrix);
        int rowsRepeated = calculateRowsRepeated(matrix);
        int columnsRepeated = calculateColsRepeated(matrix);
        System.out.println("Case #" + caseId + ": " + trace + " " + columnsRepeated + " " + rowsRepeated);
    }

    public static int calculateTrace(Matrix matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.getWidth(); i++) {
            trace += matrix.getValue(i, i);
        }
        return trace;
    }

    public static int calculateRowsRepeated(Matrix matrix) {
        int rowsRepeated = 0;
        for (int y = 0; y < matrix.getHeight(); y++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int x = 0; x < matrix.getWidth(); x++) {
                if (!rowSet.add(matrix.getValue(x, y))) {
                    rowsRepeated++;
                    break;
                }
            }
        }
        return rowsRepeated;
    }

    public static int calculateColsRepeated(Matrix matrix) {
        int colsRepeated = 0;
        for (int x = 0; x < matrix.getWidth(); x++) {
            Set<Integer> colSet = new HashSet<>();
            for (int y = 0; y < matrix.getHeight(); y++) {
                if (!colSet.add(matrix.getValue(x, y))) {
                    colsRepeated++;
                    break;
                }
            }
        }
        return colsRepeated;
    }
}

class Matrix {
    private int width;
    private int height;
    private int[] array;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        this.array = new int[width * height];
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setValue(int x, int y, int value) {
        this.array[x + y * this.width] = value;
    }

    public int getValue(int x, int y) {
        return this.array[x + y * this.width];
    }
}