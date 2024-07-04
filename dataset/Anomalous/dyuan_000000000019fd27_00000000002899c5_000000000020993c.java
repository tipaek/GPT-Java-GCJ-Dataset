import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int[][][] cases = new int[t][][];

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            cases[i] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    cases[i][j][k] = scanner.nextInt();
                }
            }
        }

        int[][] results = new int[t][3];
        for (int i = 0; i < t; i++) {
            results[i] = calculateResults(cases[i]);
            System.out.println("Case #" + (i + 1) + ": " + results[i][0] + " " + results[i][1] + " " + results[i][2]);
        }

        scanner.close();
    }

    static int[] calculateResults(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (hasColumnDuplicates(matrix, i)) {
                columnDuplicates++;
            }
        }

        return new int[]{trace, rowDuplicates, columnDuplicates};
    }

    static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    static boolean hasColumnDuplicates(int[][] matrix, int colIndex) {
        Set<Integer> seen = new HashSet<>();
        for (int[] row : matrix) {
            if (!seen.add(row[colIndex])) {
                return true;
            }
        }
        return false;
    }
}