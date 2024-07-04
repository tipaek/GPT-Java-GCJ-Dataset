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

            if (k % n != 0) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                int[][] matrix = new int[n][n];
                int[] baseArray = new int[n];
                int baseValue = k / n;
                int currentValue = 1;

                baseArray[0] = baseValue;
                for (int i = 1; i < n; i++) {
                    if (currentValue != baseValue) {
                        baseArray[i] = currentValue;
                        currentValue++;
                    } else {
                        currentValue++;
                        i--;
                    }
                }

                int[] rotatedArray = new int[n];
                for (int i = 0; i < n; i++) {
                    if (i > 0) {
                        System.arraycopy(baseArray, 0, rotatedArray, 1, n - 1);
                        rotatedArray[0] = baseArray[n - 1];
                        baseArray = rotatedArray.clone();
                    }

                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = baseArray[j];
                    }
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
}