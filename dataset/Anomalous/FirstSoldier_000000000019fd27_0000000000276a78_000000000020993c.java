import java.util.ArrayList;
import java.util.HashSet;
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

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        Matrix[] matrices = new Matrix[testCases];
        int[] sums = new int[testCases];

        for (int i = 0; i < testCases; i++) {
            int size = in.nextInt();
            matrices[i] = new Matrix(size);
            int diagonalSum = 0;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrices[i].getMatrix()[row][col] = in.nextInt();
                    if (row == col) {
                        diagonalSum += matrices[i].getMatrix()[row][col];
                    }
                }
            }
            sums[i] = diagonalSum;
        }

        Main main = new Main();
        for (int i = 0; i < testCases; i++) {
            matrices[i].setRepeatCounts(main.checkRepeats(matrices[i].getMatrix()));
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + sums[i] + " " + matrices[i].getRepeatCounts()[0] + " " + matrices[i].getRepeatCounts()[1]);
        }
    }

    public int[] checkRepeats(int[][] matrix) {
        int[] repeatCounts = new int[2];
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                repeatCounts[0]++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }

            if (hasDuplicates(column)) {
                repeatCounts[1]++;
            }
        }

        return repeatCounts;
    }

    private boolean hasDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}