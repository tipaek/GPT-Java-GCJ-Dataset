import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

    public static void checkLatinSquare(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0, rowCount = 0, colCount = 0;
        Set<Integer> seen = new HashSet<>();

        // Calculate trace and check for duplicate elements in rows
        for (int i = 0; i < size; i++) {
            seen.clear();
            boolean rowHasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!seen.add(matrix[i][j])) {
                    rowHasDuplicate = true;
                }
            }
            if (rowHasDuplicate) {
                rowCount++;
            }
        }

        // Check for duplicate elements in columns
        for (int j = 0; j < size; j++) {
            seen.clear();
            boolean colHasDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (!seen.add(matrix[i][j])) {
                    colHasDuplicate = true;
                }
            }
            if (colHasDuplicate) {
                colCount++;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowCount + " " + colCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int value = scanner.nextInt();
                    while (value < 1 || value > size) {
                        System.out.println("Invalid input. Please enter a value between 1 and " + size);
                        value = scanner.nextInt();
                    }
                    matrix[i][j] = value;
                }
            }

            checkLatinSquare(matrix, size, t);
        }

        scanner.close();
    }
}