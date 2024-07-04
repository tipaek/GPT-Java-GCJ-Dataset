import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            processCase(caseNumber, n, k);
        }
    }

    private static void processCase(int caseNumber, int n, int k) {
        if (k % n != 0) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            return;
        }
        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        int m = k / n;
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int value = m;
            for (int col = row; col < n; col++, value++) {
                if (value > n) {
                    value %= n;
                }
                matrix[row][col] = value;
            }
            for (int col = 0; col < row; col++, value++) {
                if (value > n) {
                    value %= n;
                }
                matrix[row][col] = value;
            }
        }

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}