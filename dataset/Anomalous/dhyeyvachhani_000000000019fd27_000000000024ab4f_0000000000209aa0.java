import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = scanner.nextInt();

        for (int caseNumber = 0; caseNumber < totalCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k / 3 > n) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                int[][] matrix = new int[n][n];
                int[] initialArray = new int[n];
                int fillValue = k / 3;
                int currentValue = 1;

                initialArray[0] = fillValue;
                for (int i = 1; i < n; i++) {
                    if (currentValue != fillValue) {
                        initialArray[i] = currentValue;
                        currentValue++;
                    }
                }

                int[] tempArray = new int[n];
                for (int i = 0; i < n; i++) {
                    System.arraycopy(initialArray, 0, tempArray, 1, initialArray.length - 1);
                    tempArray[0] = initialArray[initialArray.length - 1];

                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = tempArray[j];
                    }

                    initialArray = tempArray.clone();
                }

                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}