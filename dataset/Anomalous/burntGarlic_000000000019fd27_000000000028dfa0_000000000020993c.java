import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

    public static void isLatinSquare(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0;
        int rowDuplicateCount = 0;
        int colDuplicateCount = 0;

        // Calculate trace and count row duplicates
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j])) {
                    rowHasDuplicate = true;
                }
            }
            if (rowHasDuplicate) {
                rowDuplicateCount++;
            }
        }

        // Count column duplicates
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean colHasDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colHasDuplicate = true;
                }
            }
            if (colHasDuplicate) {
                colDuplicateCount++;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowDuplicateCount + " " + colDuplicateCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    while (value < 1 || value > n) {
                        System.out.println("Invalid input. Please enter a value between 1 and " + n + ":");
                        value = scanner.nextInt();
                    }
                    matrix[i][j] = value;
                }
            }

            isLatinSquare(matrix, n, t);
        }

        scanner.close();
    }
}