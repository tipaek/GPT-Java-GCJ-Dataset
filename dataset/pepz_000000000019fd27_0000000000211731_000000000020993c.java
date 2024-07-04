import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void solve(int t, int N, int[][] matrix) {
        int k = trace(matrix);
        int r = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {
            if (hasRepeteadRow(matrix, i)) r++;
            if (hasRepeteadColumn(matrix, i)) c++;
        }

        System.out.println(String.format("Case #%d: %d %d %d", t, k, r, c));
    }

    public static boolean hasRepeteadRow(int[][] matrix, int i) {
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < matrix.length; j++) {
            if (set.contains(matrix[i][j])) return true;
            set.add(matrix[i][j]);
        }
        return false;
    }

    public static boolean hasRepeteadColumn(int[][] matrix, int j) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            if (set.contains(matrix[i][j])) return true;
            set.add(matrix[i][j]);
        }
        return false;
    }

    public static int trace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int N = sc.nextInt();
                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = sc.nextInt();
                    }
                }

                solve(t, N, matrix);
            }
        }
    }
}