import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static int[] solve(int[][] matrix, int size) {
        int duplicateRows = 0, duplicateCols = 0, trace = 0;
        Set<Integer> uniqueElements = new HashSet<>();

        // Calculate trace and count duplicate elements in rows
        for (int i = 0; i < size; i++) {
            uniqueElements.clear();
            for (int j = 0; j < size; j++) {
                if (uniqueElements.contains(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
                uniqueElements.add(matrix[i][j]);
            }
            trace += matrix[i][i];
        }

        // Count duplicate elements in columns
        for (int i = 0; i < size; i++) {
            uniqueElements.clear();
            for (int j = 0; j < size; j++) {
                if (uniqueElements.contains(matrix[j][i])) {
                    duplicateCols++;
                    break;
                }
                uniqueElements.add(matrix[j][i]);
            }
        }

        return new int[]{duplicateRows, duplicateCols, trace};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] result = solve(matrix, n);
            System.out.printf("Case #%d: %d %d %d%n", testCase, result[2], result[0], result[1]);
        }
    }
}