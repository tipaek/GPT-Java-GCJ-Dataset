import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

    public static void checkLatinSquare(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        // Calculate trace and row duplicates
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }
        }

        // Calculate column duplicates
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    while (value < 1 || value > n) {
                        System.out.println("Invalid input. Please enter a value between 1 and " + n + ":");
                        value = sc.nextInt();
                    }
                    matrix[i][j] = value;
                }
            }

            checkLatinSquare(matrix, n, k);
        }

        sc.close();
    }
}