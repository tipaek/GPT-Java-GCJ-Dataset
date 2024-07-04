import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static void vestigium(int caseNumber, int[][] matrix) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        // Calculate trace and row repeats
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        // Calculate column repeats
        for (int j = 0; j < matrix[0].length; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < matrix.length; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colRepeats++;
                    break;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowRepeats, colRepeats);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            scanner.nextLine(); // consume the remaining newline

            for (int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            vestigium(testCase, matrix);
        }

        scanner.close();
    }
}