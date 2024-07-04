import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

    public static void isLatinSquare(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;

        // Calculate trace
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate elements in rows
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (seen.contains(matrix[i][j])) {
                    rowCount++;
                    break;
                }
                seen.add(matrix[i][j]);
            }
        }

        // Check for duplicate elements in columns
        for (int j = 0; j < size; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (seen.contains(matrix[i][j])) {
                    colCount++;
                    break;
                }
                seen.add(matrix[i][j]);
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowCount + " " + colCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = sc.nextInt();
                    while (temp < 1 || temp > n) {
                        System.out.println("Invalid input. Please enter a number between 1 and " + n);
                        temp = sc.nextInt();
                    }
                    matrix[i][j] = temp;
                }
            }

            isLatinSquare(matrix, n, k);
        }

        sc.close();
    }
}