import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= totalCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k % n != 0 || k / n > n) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                continue;
            }

            int quotient = k / n;
            int[][] matrix = new int[n][n];
            int[] initialRow = new int[n];
            int currentValue = 1;

            for (int i = 0; i < n; i++) {
                if (i < quotient) {
                    initialRow[i] = quotient;
                } else {
                    initialRow[i] = currentValue++;
                    if (currentValue == quotient) {
                        currentValue++;
                    }
                }
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = initialRow[(col + row) % n];
                }
            }

            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            for (int[] row : matrix) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }
}