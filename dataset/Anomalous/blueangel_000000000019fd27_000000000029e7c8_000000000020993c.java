import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void processMatrix(int[][] matrix, int size) {
        int trace = 0;
        int countRowRepeat = 0;
        int countColumnRepeat = 0;

        for (int i = 0; i < size; i++) {
            boolean rowRepeat = false;
            boolean columnRepeat = false;
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (!rowRepeat) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeat = true;
                    }
                }

                if (!columnRepeat) {
                    if (!colSet.add(matrix[j][i])) {
                        columnRepeat = true;
                    }
                }
            }

            if (rowRepeat) countRowRepeat++;
            if (columnRepeat) countColumnRepeat++;
        }

        System.out.print(trace + " " + countRowRepeat + " " + countColumnRepeat);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            processMatrix(matrix, matrixSize);
            System.out.println();
        }
    }
}