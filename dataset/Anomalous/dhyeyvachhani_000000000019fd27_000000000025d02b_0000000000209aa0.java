import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k % n != 0 || k > n) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
                continue;
            }

            int quotient = k / n;
            int[][] matrix = new int[n][n];
            int[] initialArray = new int[n];
            int fillValue = quotient;
            int currentValue = 1;

            initialArray[0] = fillValue;
            for (int j = 1; j < n; j++) {
                if (currentValue != fillValue) {
                    initialArray[j] = currentValue;
                    currentValue++;
                } else {
                    currentValue++;
                    j--;
                }
            }

            int[] tempArray = new int[n];
            System.arraycopy(initialArray, 0, matrix[0], 0, n);

            for (int row = 1; row < n; row++) {
                System.arraycopy(initialArray, 0, tempArray, 1, n - 1);
                tempArray[0] = initialArray[n - 1];
                System.arraycopy(tempArray, 0, matrix[row], 0, n);
                System.arraycopy(tempArray, 0, initialArray, 0, n);
            }

            System.out.println("Case #" + (caseIndex + 1) + ": POSSIBLE");
            for (int[] row : matrix) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }
}