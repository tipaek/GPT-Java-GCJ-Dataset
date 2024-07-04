import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static class TestCase {
        int n;
        int[][] matrix;

        TestCase(int n) {
            this.n = n;
            this.matrix = new int[n][n];
        }
    }

    public static void findTrace(int[][] matrix) {
        int size = matrix.length;
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        // Count number of rows with duplicate elements
        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size];
            for (int j = 0; j < size; j++) {
                if (rowCheck[matrix[i][j] - 1]) {
                    rowDuplicates++;
                    break;
                }
                rowCheck[matrix[i][j] - 1] = true;
            }
        }

        // Count number of columns with duplicate elements
        for (int i = 0; i < size; i++) {
            boolean[] colCheck = new boolean[size];
            for (int j = 0; j < size; j++) {
                if (colCheck[matrix[j][i] - 1]) {
                    colDuplicates++;
                    break;
                }
                colCheck[matrix[j][i] - 1] = true;
            }
        }

        System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        TestCase[] testCases = new TestCase[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            testCases[i] = new TestCase(n);

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    testCases[i].matrix[row][col] = sc.nextInt();
                }
            }
        }

        for (TestCase testCase : testCases) {
            findTrace(testCase.matrix);
        }
    }
}