import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[100][100];
        boolean[] hasOccurred = new boolean[102];

        for (int testCase = 0; testCase < testCases; testCase++) {
            int sum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            int n = scanner.nextInt();
            scanner.nextLine();

            // Read the matrix and calculate the diagonal sum
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        sum += matrix[row][col];
                    }
                }
                scanner.nextLine();
            }

            // Check for duplicate values in each row
            for (int row = 0; row < n; row++) {
                resetBooleanArray(hasOccurred, 100);
                for (int col = 0; col < n; col++) {
                    if (hasOccurred[matrix[row][col]]) {
                        duplicateRows++;
                        break;
                    } else {
                        hasOccurred[matrix[row][col]] = true;
                    }
                }
            }

            // Check for duplicate values in each column
            for (int col = 0; col < n; col++) {
                resetBooleanArray(hasOccurred, 100);
                for (int row = 0; row < n; row++) {
                    if (hasOccurred[matrix[row][col]]) {
                        duplicateColumns++;
                        break;
                    } else {
                        hasOccurred[matrix[row][col]] = true;
                    }
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + sum + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static void resetBooleanArray(boolean[] array, int length) {
        for (int i = 0; i < length; i++) {
            array[i] = false;
        }
    }
}