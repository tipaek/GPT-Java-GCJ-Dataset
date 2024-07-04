import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            solveCase(t, n, matrix);
        }
        scanner.close();
    }

    static void solveCase(int testCaseNumber, int n, int[][] matrix) {
        List<Set<Integer>> rowSets = new ArrayList<>(n);
        List<Set<Integer>> colSets = new ArrayList<>(n);
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < n; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowSets.get(i).add(matrix[i][j]);
                colSets.get(j).add(matrix[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (rowSets.get(i).size() != n) {
                rowCount++;
            }
            if (colSets.get(i).size() != n) {
                colCount++;
            }
        }

        System.out.println("Case #" + (testCaseNumber + 1) + ": " + trace + " " + rowCount + " " + colCount);
    }
}