import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k % n != 0) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseIndex);
            } else {
                boolean found = false;
                for (int j = 1; j <= n; j++) {
                    if (n * j == k) {
                        System.out.printf("Case #%d: POSSIBLE%n", caseIndex);
                        generateMatrix(n, j);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.printf("Case #%d: IMPOSSIBLE%n", caseIndex);
                }
            }
        }
    }

    private static void generateMatrix(int size, int startNumber) {
        int[][] matrix = new int[size][size];
        int number = startNumber;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = number;
                System.out.print(number);
                if (j < size - 1) {
                    System.out.print(" ");
                }
                number = number % size + 1;
            }
            System.out.println();
        }
    }
}