import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] S = new int[R][C];

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    S[r][c] = in.nextInt();
                }
            }

            System.out.println("Case #" + i + ": " + solve(S, R, C));
        }
    }

    private static long solve(int[][] S, int R, int C) {
        long interest = currentInterest(S, R, C);
        long sum = interest;

        while (true) {
            long eliminated = runRound(S, R, C);
            if (eliminated == 0) return sum;

            interest -= eliminated;
            sum += interest;
        }
    }

    private static long runRound(int[][] S, int R, int C) {
        boolean[][] toEliminate = new boolean[R][C];
        long eliminated = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                toEliminate[r][c] = shouldEliminate(S, R, C, r, c);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (toEliminate[r][c]) {
                    eliminated += S[r][c];
                    S[r][c] = 0;
                }
            }
        }

        return eliminated;
    }

    private static boolean shouldEliminate(int[][] S, int R, int C, int r, int c) {
        if (S[r][c] == 0) return false;

        List<Integer> neighbours = new ArrayList<>();

        if (r > 0) {
            for (int i = r - 1; i >= 0; i--) {
                if (S[i][c] != 0) {
                    neighbours.add(S[i][c]);
                    break;
                }
            }
        }

        if (r < R - 1) {
            for (int i = r + 1; i < R; i++) {
                if (S[i][c] != 0) {
                    neighbours.add(S[i][c]);
                    break;
                }
            }
        }

        if (c > 0) {
            for (int i = c - 1; i >= 0; i--) {
                if (S[r][i] != 0) {
                    neighbours.add(S[r][i]);
                    break;
                }
            }
        }

        if (c < C - 1) {
            for (int i = c + 1; i < C; i++) {
                if (S[r][i] != 0) {
                    neighbours.add(S[r][i]);
                    break;
                }
            }
        }

        int sum = 0;
        for (int n : neighbours) sum += n;

        return S[r][c] * neighbours.size() < sum;
    }

    private static int currentInterest(int[][] S, int R, int C) {
        int interest = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                interest += S[r][c];
            }
        }

        return interest;
    }
}
