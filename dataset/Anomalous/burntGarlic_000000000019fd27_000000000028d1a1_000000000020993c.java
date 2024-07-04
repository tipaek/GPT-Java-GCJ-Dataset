import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();

        for (int k = 1; k <= t; ++k) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = sc.nextInt();
                    while (temp < 1 || temp > n) {
                        System.out.println("Invalid input. Enter a number between 1 and " + n);
                        temp = sc.nextInt();
                    }
                    matrix[i][j] = temp;
                }
            }

            evaluateLatinSquare(matrix, n, k);
        }

        sc.close();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime / 1000);
    }

    public static void evaluateLatinSquare(int[][] matrix, int n, int testCaseNumber) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        Set<Integer> seen = new HashSet<>();

        // Calculate trace and check for row duplicates
        for (int i = 0; i < n; i++) {
            seen.clear();
            boolean hasRowDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!seen.add(matrix[i][j])) {
                    hasRowDuplicate = true;
                }
            }
            if (hasRowDuplicate) {
                rowDuplicates++;
            }
        }

        // Check for column duplicates
        for (int j = 0; j < n; j++) {
            seen.clear();
            boolean hasColDuplicate = false;
            for (int i = 0; i < n; i++) {
                if (!seen.add(matrix[i][j])) {
                    hasColDuplicate = true;
                }
            }
            if (hasColDuplicate) {
                colDuplicates++;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }
}