import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[100][100];
        boolean[] hasOccurred = new boolean[100];

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int sumDiagonal = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;
            int size = scanner.nextInt();
            scanner.nextLine();

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        sumDiagonal += matrix[row][col];
                    }
                }
                if (row != size - 1) {
                    scanner.nextLine();
                }
            }

            // Check for repeated elements in rows
            for (int row = 0; row < size; row++) {
                resetArray(hasOccurred);
                for (int col = 0; col < size; col++) {
                    if (hasOccurred[matrix[row][col]]) {
                        repeatedRows++;
                        break;
                    } else {
                        hasOccurred[matrix[row][col]] = true;
                    }
                }
            }

            // Check for repeated elements in columns
            for (int col = 0; col < size; col++) {
                resetArray(hasOccurred);
                for (int row = 0; row < size; row++) {
                    if (hasOccurred[matrix[row][col]]) {
                        repeatedCols++;
                        break;
                    } else {
                        hasOccurred[matrix[row][col]] = true;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + sumDiagonal + " " + repeatedRows + " " + repeatedCols);
        }

        scanner.close();
    }

    private static void resetArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = false;
        }
    }
}