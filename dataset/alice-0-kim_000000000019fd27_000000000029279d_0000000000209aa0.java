import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int[][] board = new int[N][N];
            int[] diag = new int[N];
            if (isValid(diag, N, K)) {
                for (int i = 0; i < N; i++) board[i][i] = diag[i];
                if (solve(board, N))
                    System.out.printf("Case #%d: %s\n%s\n", t, "POSSIBLE", print(board, N));
                else
                    System.out.printf("Case #%d: %s\n", t, "IMPOSSIBLE");
            }
            else
                System.out.printf("Case #%d: %s\n", t, "IMPOSSIBLE");
        }
    }
    
    public static boolean solve(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= N; k++) {
                        board[i][j] = k;
                        if (isValid(board, i, j, N) && solve(board, N)) return true;
                        board[i][j] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isValid(int[] diag, int N, int K) {
        Arrays.fill(diag, N);
        for (int i = 0, sum = N * N; i < N; i++) {
            if (sum == K) return true;
            diag[i] -= Math.min(sum - K, N - 1);
            sum -= Math.min(sum - K, N - 1);
        }
        return false;
    }
    
    public static boolean isValid(int[][] board, int i, int j, int N) {
        Set<Integer> set = new HashSet();
        for (int k = 0; k < N; k++) {
            if (set.contains(board[i][k])) return false;
            if (board[i][k] != 0) set.add(board[i][k]);
        }
        set.clear();
        for (int k = 0; k < N; k++) {
            if (set.contains(board[k][j])) return false;
            if (board[k][j] != 0) set.add(board[k][j]);
        }
        return true;
    }
    
    public static String print(int[][] board, int N) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(board[i][j] + (j < N - 1 ? " " : "\n"));
            }
        }
        s.append("\n");
        return s.toString();
    }
}