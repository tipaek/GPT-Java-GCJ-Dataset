import java.util.*;
import java.io.*;

public class App {

    public static Matrix readFromScanner(Scanner scanner) {
        int size = scanner.nextInt();
        Matrix matrix = new Matrix(size, size);
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                matrix.setValue(x, y, scanner.nextInt());
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            Matrix matrix = readFromScanner(scanner);
            processAndOutput(matrix, i);
        }
    }

    public static void processAndOutput(Matrix matrix, int caseId) {
        int trace = calculateTrace(matrix);

        Matrix rowMatrix = new Matrix(matrix.getWidth(), matrix.getHeight());
        Matrix colMatrix = new Matrix(matrix.getWidth(), matrix.getHeight());

        int rowsRepeated = 0;
        int columnsRepeated = 0;

        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                rowMatrix.setValue(matrix.getValue(x, y) - 1, y, 1);
                colMatrix.setValue(x, matrix.getValue(x, y) - 1, 1);
            }
        }

        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                if (rowMatrix.getValue(x, y) == 0) {
                    rowsRepeated++;
                    break;
                }
            }
        }

        for (int x = 0; x < matrix.getWidth(); x++) {
            for (int y = 0; y < matrix.getHeight(); y++) {
                if (colMatrix.getValue(x, y) == 0) {
                    columnsRepeated++;
                    break;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseId, trace, rowsRepeated, columnsRepeated);
    }

    public static int calculateTrace(Matrix matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.getWidth(); i++) {
            trace += matrix.getValue(i, i);
        }
        return trace;
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
        Arrays.fill(this.array, 0);
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