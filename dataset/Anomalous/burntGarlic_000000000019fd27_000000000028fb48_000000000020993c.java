import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {
    
    public static void isLatinSquare(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0, rowDuplicateCount = 0, colDuplicateCount = 0;

        // Check for duplicates in rows
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicateCount++;
                    break;
                }
            }
        }

        // Check for duplicates in columns and calculate the trace
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!colSet.add(matrix[i][j])) {
                    colDuplicateCount++;
                    break;
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowDuplicateCount + " " + colDuplicateCount);
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
                        System.out.println("Invalid input. Please enter a value between 1 and " + size + ":");
                        value = scanner.nextInt();
                    }
                    matrix[i][j] = value;
                }
            }

            isLatinSquare(matrix, size, t);
        }

        scanner.close();
    }
}