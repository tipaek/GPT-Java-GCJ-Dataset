import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(input.nextLine());
        for (int i = 0; i < t; i++) {
            int[] parameters = Arrays.stream(input.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            String solution = solve(parameters[0], parameters[1]);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(int n, int target) {
        boolean[][] rowNumbers = new boolean[n][];
        boolean[][] columnNumbers = new boolean[n][];
        for (int i = 0; i < n; i++) {
            rowNumbers[i] = new boolean[n + 1];
            Arrays.fill(rowNumbers[i], true);

            columnNumbers[i] = new boolean[n + 1];
            Arrays.fill(columnNumbers[i], true);
        }

        String solution = solve(0, 0, rowNumbers, columnNumbers, target, new int[n][n]);
        return solution != null ? solution : "IMPOSSIBLE";
    }

    private static String solve(int r, int c, boolean[][] rowNumbers, boolean[][] columnNumbers, int target, int[][] matrix) {
        if (c == matrix.length) {
            String solution = null;
            if (r + 1 != matrix.length) {
                solution = solve(r + 1, 0, rowNumbers, columnNumbers, target, matrix);
            } else {
                int sum = IntStream.range(0, matrix.length)
                        .map(i -> matrix[i][i])
                        .sum();

                if (sum == target) {
                    solution = Arrays.stream(matrix)
                            .map(row -> Arrays.stream(row)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining(" ")))
                            .collect(Collectors.joining("\n", "POSSIBLE\n", ""));
                }
            }

            return solution;
        } else {
            for (int i = 1; i <= matrix.length; i++) {
                if (rowNumbers[c][i] && columnNumbers[r][i]) {
                    rowNumbers[c][i] = false;
                    columnNumbers[r][i] = false;
                    matrix[r][c] = i;
                    String solution = solve(r, c + 1, rowNumbers, columnNumbers, target, matrix);
                    if (solution != null) {
                        return solution;
                    }
                    rowNumbers[c][i] = true;
                    columnNumbers[r][i] = true;
                }
            }
            return null;
        }
    }
    
}
