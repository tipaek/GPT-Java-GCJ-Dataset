import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    static class TestCase {
        int n;
        int[][] matrix;

        TestCase(int n) {
            this.n = n;
            this.matrix = new int[n][n];
        }
    }

    public static void findTrace(int index, TestCase testCase) {
        int size = testCase.n;
        int[][] matrix = testCase.matrix;
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        // Calculate trace
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        // Count rows with duplicate elements
        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size];
            for (int j = 0; j < size; j++) {
                if (rowCheck[matrix[i][j] - 1]) {
                    duplicateRows++;
                    break;
                }
                rowCheck[matrix[i][j] - 1] = true;
            }
        }

        // Count columns with duplicate elements
        for (int i = 0; i < size; i++) {
            boolean[] colCheck = new boolean[size];
            for (int j = 0; j < size; j++) {
                if (colCheck[matrix[j][i] - 1]) {
                    duplicateCols++;
                    break;
                }
                colCheck[matrix[j][i] - 1] = true;
            }
        }

        System.out.println("Case #" + index + ": " + trace + " " + duplicateRows + " " + duplicateCols);
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

        for (int i = 0; i < t; i++) {
            findTrace(i + 1, testCases[i]);
        }

        sc.close();
    }
}