import java.util.ArrayList;
import java.util.Scanner;

class Matrix {
    private int[][] matrix;
    private int[] repeatCounts = new int[2];

    public Matrix(int size) {
        matrix = new int[size][size];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] getRepeatCounts() {
        return repeatCounts;
    }

    public void setRepeatCounts(int[] repeatCounts) {
        this.repeatCounts = repeatCounts;
    }
}

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Matrix[] matrices = new Matrix[testCases];
        int[] diagonalSums = new int[testCases];

        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            matrices[i] = new Matrix(size);
            int sum = 0;
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrices[i].getMatrix()[row][col] = scanner.nextInt();
                    if (row == col) {
                        sum += matrices[i].getMatrix()[row][col];
                    }
                }
            }
            diagonalSums[i] = sum;
        }

        MatrixAnalysis analysis = new MatrixAnalysis();
        for (int i = 0; i < testCases; i++) {
            matrices[i].setRepeatCounts(analysis.checkRepeats(matrices[i].getMatrix()));
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + diagonalSums[i] + " " + matrices[i].getRepeatCounts()[0] + " " + matrices[i].getRepeatCounts()[1]);
        }
    }

    public int[] checkRepeats(int[][] matrix) {
        int[] repeatCounts = {0, 0};

        for (int i = 0; i < matrix.length; i++) {
            if (hasRepeats(matrix[i])) {
                repeatCounts[0]++;
            }

            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (hasRepeats(column)) {
                repeatCounts[1]++;
            }
        }

        return repeatCounts;
    }

    private boolean hasRepeats(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : array) {
            if (list.contains(value)) {
                return true;
            }
            list.add(value);
        }
        return false;
    }
}