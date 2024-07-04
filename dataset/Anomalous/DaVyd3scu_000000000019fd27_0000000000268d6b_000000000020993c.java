import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] traces = new int[testCases], repeatingRows = new int[testCases], repeatingColumns = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            Matrix matrix = new Matrix(scanner, size);
            matrix.readMatrix();
            int[] results = matrix.calculateRepeatingRowsAndColumns();
            
            traces[t] = matrix.getTrace();
            repeatingRows[t] = results[0];
            repeatingColumns[t] = results[1];
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + traces[t] + " " + repeatingRows[t] + " " + repeatingColumns[t]);
        }
    }
}

class Matrix {
    private int size;
    private int trace;
    private int[][] elements;
    private Scanner scanner;

    public Matrix(Scanner scanner, int size) {
        this.size = size;
        this.scanner = scanner;
        this.elements = new int[size][size];
        this.trace = 0;
    }

    public void readMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                elements[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += elements[i][j];
                }
            }
        }
    }

    public int[] calculateRepeatingRowsAndColumns() {
        int repeatingRowsCount = 0;
        int repeatingColumnsCount = 0;

        for (int i = 0; i < size; i++) {
            if (hasDuplicate(elements[i])) {
                repeatingRowsCount++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = elements[j][i];
            }
            if (hasDuplicate(column)) {
                repeatingColumnsCount++;
            }
        }

        return new int[]{repeatingRowsCount, repeatingColumnsCount};
    }

    private boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    public int getTrace() {
        return trace;
    }
}