import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int MOD = 1_000_000_007;
    private static final PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            writer.print("Case #" + i + ": ");
            solveTestCase();
        }
        writer.flush();
        writer.close();
        scanner.close();
    }

    private static void solveTestCase() throws IOException {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        Set<Integer> uniqueElements = new HashSet<>();
        long trace = 0, duplicateRows = 0, duplicateColumns = 0;

        for (int row = 0; row < n; row++) {
            uniqueElements.clear();
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scanner.nextInt();
                if (row == col) {
                    trace += matrix[row][col];
                }
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() != n) {
                duplicateRows++;
            }
        }

        for (int col = 0; col < n; col++) {
            uniqueElements.clear();
            for (int row = 0; row < n; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() != n) {
                duplicateColumns++;
            }
        }

        writer.println(trace + " " + duplicateRows + " " + duplicateColumns);
    }
}