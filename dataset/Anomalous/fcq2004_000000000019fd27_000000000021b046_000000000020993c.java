import java.util.*;

public class Solution {
    private static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.print("Case #" + t + ": " + trace);
            solve(matrix);
            System.out.println();
        }
    }

    private static void solve(int[][] matrix) {
        int repeatedRows = 0;
        int repeatedColumns = 0;

        for (int i = 0; i < N; i++) {
            if (hasDuplicates(matrix[i])) {
                repeatedRows++;
            }

            int[] column = new int[N];
            for (int j = 0; j < N; j++) {
                column[j] = matrix[j][i];
            }

            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }

        System.out.print(" " + repeatedRows + " " + repeatedColumns);
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}