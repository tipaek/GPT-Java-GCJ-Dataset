import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            Matrix matrix = readMatrix(scanner);
            processAndOutput(matrix, i);
        }
    }

    private static Matrix readMatrix(Scanner scanner) {
        int size = scanner.nextInt();
        Matrix matrix = new Matrix(size, size);
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                matrix.setValue(x, y, scanner.nextInt());
            }
        }
        return matrix;
    }

    private static void processAndOutput(Matrix matrix, int caseId) {
        int trace = calculateTrace(matrix);
        int rowsRepeated = countRepeatedRows(matrix);
        int columnsRepeated = countRepeatedColumns(matrix);

        System.out.println("Case #" + caseId + ": " + trace + " " + rowsRepeated + " " + columnsRepeated);
    }

    private static int calculateTrace(Matrix matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.getWidth(); i++) {
            trace += matrix.getValue(i, i);
        }
        return trace;
    }

    private static int countRepeatedRows(Matrix matrix) {
        int rowsRepeated = 0;
        for (int y = 0; y < matrix.getHeight(); y++) {
            boolean[] seen = new boolean[matrix.getWidth()];
            boolean hasDuplicate = false;
            for (int x = 0; x < matrix.getWidth(); x++) {
                int value = matrix.getValue(x, y) - 1;
                if (seen[value]) {
                    hasDuplicate = true;
                    break;
                }
                seen[value] = true;
            }
            if (hasDuplicate) {
                rowsRepeated++;
            }
        }
        return rowsRepeated;
    }

    private static int countRepeatedColumns(Matrix matrix) {
        int columnsRepeated = 0;
        for (int x = 0; x < matrix.getWidth(); x++) {
            boolean[] seen = new boolean[matrix.getHeight()];
            boolean hasDuplicate = false;
            for (int y = 0; y < matrix.getHeight(); y++) {
                int value = matrix.getValue(x, y) - 1;
                if (seen[value]) {
                    hasDuplicate = true;
                    break;
                }
                seen[value] = true;
            }
            if (hasDuplicate) {
                columnsRepeated++;
            }
        }
        return columnsRepeated;
    }
}

class Matrix {
    private final int width;
    private final int height;
    private final int[] array;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        this.array = new int[width * height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setValue(int x, int y, int value) {
        array[x + y * width] = value;
    }

    public int getValue(int x, int y) {
        return array[x + y * width];
    }
}