import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<List<Integer>> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, n);
            int rowDups = calculateRowDuplicates(matrix, n);
            int colDups = calculateColumnDuplicates(matrix, n);

            results.add(Arrays.asList(diagonalSum, rowDups, colDups));
        }

        // Print results
        for (int i = 0; i < results.size(); i++) {
            List<Integer> result = results.get(i);
            System.out.println("Case #" + (i + 1) + ": " + result.get(0) + " " + result.get(1) + " " + result.get(2));
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int calculateRowDuplicates(int[][] matrix, int n) {
        int duplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!seen.add(matrix[i][j])) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }

    private static int calculateColumnDuplicates(int[][] matrix, int n) {
        int duplicates = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!seen.add(matrix[i][j])) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }
}