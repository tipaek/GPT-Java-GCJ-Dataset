import java.util.ArrayList;
import java.util.Scanner;

class Matrix {
    private int[][] matrix;
    private int[] count = new int[2];

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }

    public Matrix(int size) {
        matrix = new int[size][size];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}

public class MatrixProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Matrix[] matrices = new Matrix[testCases];
        int[] sums = new int[testCases];

        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            matrices[i] = new Matrix(size);
            int diagonalSum = 0;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrices[i].getMatrix()[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrices[i].getMatrix()[row][col];
                    }
                }
            }
            sums[i] = diagonalSum;
        }

        MatrixProcessor processor = new MatrixProcessor();
        for (int i = 0; i < testCases; i++) {
            matrices[i].setCount(processor.checkRepeats(matrices[i].getMatrix()));
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + sums[i] + " " + matrices[i].getCount()[0] + " " + matrices[i].getCount()[1]);
        }
    }

    public int[] checkRepeats(int[][] matrix) {
        int[] count = new int[2];
        count[0] = count[1] = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (hasRepeats(matrix[i])) {
                count[0]++;
            }

            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }

            if (hasRepeats(column)) {
                count[1]++;
            }
        }

        return count;
    }

    private boolean hasRepeats(int[] array) {
        ArrayList<Integer> elements = new ArrayList<>();
        for (int num : array) {
            if (elements.contains(num)) {
                return true;
            }
            elements.add(num);
        }
        return false;
    }
}