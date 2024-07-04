import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

    public static void isLatinSquare(int[][] matrix, int size, int testCase) {
        int trace = 0, rowCount = 0, colCount = 0;
        Set<Integer> seen = new HashSet<>();

        // Calculate trace and row duplicates
        for (int i = 0; i < size; i++) {
            seen.clear();
            boolean rowDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!seen.add(matrix[i][j])) {
                    rowDuplicate = true;
                }
            }
            if (rowDuplicate) {
                rowCount++;
            }
        }

        // Calculate column duplicates
        for (int j = 0; j < size; j++) {
            seen.clear();
            boolean colDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (!seen.add(matrix[i][j])) {
                    colDuplicate = true;
                }
            }
            if (colDuplicate) {
                colCount++;
            }
        }

        System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int value = sc.nextInt();
                    while (value < 1 || value > size) {
                        System.out.println("Invalid input. Please enter a value between 1 and " + size + ":");
                        value = sc.nextInt();
                    }
                    matrix[i][j] = value;
                }
            }

            isLatinSquare(matrix, size, t);
        }

        sc.close();
    }
}