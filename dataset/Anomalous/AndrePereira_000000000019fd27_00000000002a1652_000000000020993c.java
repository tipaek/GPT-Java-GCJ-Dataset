package CodeJam2020;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    private static void calculateVestigium(int caseNumber, int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        // Calculate the trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for repeated elements in rows
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!seen.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        // Check for repeated elements in columns
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!seen.add(matrix[j][i])) {
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

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            calculateVestigium(caseNumber, matrix);
        }
    }
}