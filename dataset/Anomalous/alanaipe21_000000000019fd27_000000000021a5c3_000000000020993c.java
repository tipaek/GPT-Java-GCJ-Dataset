import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[100][100];
        boolean[] hasOccurred = new boolean[100];

        for (int i = 0; i < testCases; i++) {
            int sum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        sum += matrix[row][col];
                    }
                }
                scanner.nextLine();
            }

            for (int row = 0; row < n; row++) {
                clearArray(hasOccurred);
                for (int col = 0; col < n; col++) {
                    if (hasOccurred[matrix[row][col]]) {
                        duplicateRows++;
                        break;
                    } else {
                        hasOccurred[matrix[row][col]] = true;
                    }
                }
            }

            for (int col = 0; col < n; col++) {
                clearArray(hasOccurred);
                for (int row = 0; row < n; row++) {
                    if (hasOccurred[matrix[row][col]]) {
                        duplicateColumns++;
                        break;
                    } else {
                        hasOccurred[matrix[row][col]] = true;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + sum + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static void clearArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = false;
        }
    }
}