import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int k = 1; k <= t; ++k) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = sc.nextInt();
                    while (temp < 1 || temp > n) {
                        System.out.println("invalid");
                        temp = sc.nextInt();
                    }
                    matrix[i][j] = temp;
                }
            }
            evaluateLatinSquare(matrix, n, k);
        }
        sc.close();
    }

    public static void evaluateLatinSquare(int[][] matrix, int size, int testCase) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        Set<Integer> seen = new HashSet<>();

        // Check rows for duplicates
        for (int[] row : matrix) {
            seen.clear();
            boolean hasDuplicate = false;
            for (int value : row) {
                if (!seen.add(value)) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                rowDuplicates++;
            }
        }

        // Check columns for duplicates and calculate trace
        for (int j = 0; j < size; j++) {
            seen.clear();
            boolean hasDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!seen.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                colDuplicates++;
            }
        }

        System.out.println("case #" + testCase + " : " + trace + " " + rowDuplicates + " " + colDuplicates);
    }
}