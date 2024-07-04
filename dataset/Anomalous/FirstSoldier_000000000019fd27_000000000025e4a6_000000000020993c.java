import java.util.ArrayList;
import java.util.Scanner;

class Matrix {
    private int[][] matrix;
    private int[] count;

    public Matrix(int size) {
        this.matrix = new int[size][size];
        this.count = new int[2];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }
}

public class MatrixAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Matrix[] matrices = new Matrix[testCases];
        int[] diagonalSums = new int[testCases];

        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            matrices[i] = new Matrix(size);
            int[][] matrix = matrices[i].getMatrix();
            int diagonalSum = 0;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }
            diagonalSums[i] = diagonalSum;
        }

        for (Matrix matrix : matrices) {
            matrix.setCount(checkRepeats(matrix.getMatrix()));
        }

        for (int i = 0; i < testCases; i++) {
            int[] count = matrices[i].getCount();
            System.out.printf("Case #%d: %d %d %d%n", i + 1, diagonalSums[i], count[0], count[1]);
        }

        scanner.close();
    }

    public static int[] checkRepeats(int[][] matrix) {
        int[] count = new int[2];
        ArrayList<Integer> rowElements = new ArrayList<>();
        ArrayList<Integer> colElements = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            rowElements.clear();
            colElements.clear();

            for (int j = 0; j < matrix.length; j++) {
                rowElements.add(matrix[i][j]);
                colElements.add(matrix[j][i]);
            }

            if (hasDuplicates(rowElements)) {
                count[0]++;
            }

            if (hasDuplicates(colElements)) {
                count[1]++;
            }
        }

        return count;
    }

    private static boolean hasDuplicates(ArrayList<Integer> elements) {
        for (int i = 0; i < elements.size(); i++) {
            for (int j = i + 1; j < elements.size(); j++) {
                if (elements.get(i).equals(elements.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}