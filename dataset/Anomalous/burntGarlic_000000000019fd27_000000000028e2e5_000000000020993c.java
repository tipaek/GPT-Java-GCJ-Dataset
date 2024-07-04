import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

    public static void checkLatinSquare(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        // Calculate trace and check for row duplicates
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
                rowDuplicates++;
            }
        }

        // Check for column duplicates
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean colHasDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colHasDuplicate = true;
                }
            }
            if (colHasDuplicate) {
                colDuplicates++;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
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
                        System.out.println("Invalid value. Please enter a number between 1 and " + size);
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