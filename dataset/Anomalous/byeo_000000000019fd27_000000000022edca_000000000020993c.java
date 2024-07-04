import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private static String vestigium(int[][] matrix) {
        int trace = 0;
        int N = matrix.length;
        int rowDuplicates = 0, colDuplicates = 0;

        // Calculate trace and row duplicates
        for (int r = 0; r < N; r++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int c = 0; c < N; c++) {
                if (rowSet.contains(matrix[r][c])) {
                    rowDuplicates++;
                    break;
                }
                rowSet.add(matrix[r][c]);
            }
            trace += matrix[r][r];
        }

        // Calculate column duplicates
        for (int c = 0; c < N; c++) {
            Set<Integer> colSet = new HashSet<>();
            for (int r = 0; r < N; r++) {
                if (colSet.contains(matrix[r][c])) {
                    colDuplicates++;
                    break;
                }
                colSet.add(matrix[r][c]);
            }
        }

        return trace + " " + rowDuplicates + " " + colDuplicates;
    }

    public static void main(String[] args) {
        int[][][] cases = readInput();
        for (int i = 0; i < cases.length; i++) {
            String result = vestigium(cases[i]);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int[][][] readInput() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][][] cases = new int[T][][];

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            cases[t] = new int[N][N];
            for (int n = 0; n < N; n++) {
                for (int i = 0; i < N; i++) {
                    cases[t][n][i] = scanner.nextInt();
                }
            }
        }
        return cases;
    }
}