import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k % n != 0) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                int[][] matrix = new int[n][n];
                int[] initialArray = new int[n];
                int fillValue = k / n;
                int currentValue = 1;

                initialArray[0] = fillValue;
                for (int i = 1; i < n; i++) {
                    if (currentValue != fillValue) {
                        initialArray[i] = currentValue;
                        currentValue++;
                    } else {
                        currentValue++;
                        i--;
                    }
                }

                int[] tempArray = new int[n];
                System.arraycopy(initialArray, 0, matrix[0], 0, n);

                for (int i = 1; i < n; i++) {
                    System.arraycopy(initialArray, 0, tempArray, 1, n - 1);
                    tempArray[0] = initialArray[n - 1];

                    System.arraycopy(tempArray, 0, matrix[i], 0, n);
                    System.arraycopy(tempArray, 0, initialArray, 0, n);
                }

                System.out.println("Case #" + (testCase + 1) + ": POSSIBLE");
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