import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    private int MB = 1<<20;
    private int SIZE = 20 * MB;

    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    static int readInt() throws IOException {
        String line = br.readLine();
        return Integer.parseInt(line.trim());
    }

    static int[] readIntArray(int n) throws IOException {
        int[] arr = new int[n];
        String line = br.readLine();
        Scanner scanner = new Scanner(line);
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        for (int i = 0; i < T; ++i) {
            int N = readInt();
            int[][] M = new int[N][];
            for (int j = 0; j < N; ++j) {
                M[j] = readIntArray(N);
            }
            Result res = solve(i+1, N, M);
            sb.append(res.toString());
        }
        System.out.print(sb);
    }

    public static Result solve(int x, int N, int[][] M) {
        Result res = new Result();
        res.x = x;
        res.k = diagonalSum(N, M);
        res.r = sameRows(N, M);
        res.c = sameCols(N, M);
        return res;
    }

    private static int sameRows(int N, int[][] M) {
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            if (hasDuplicates(N, M, r, 0,0, 1)) {
                ++cnt;
            }
        }
        return cnt;
    }

    private static int sameCols(int N, int[][] M) {
        int cnt = 0;
        for (int c = 0; c < N; c++) {
            if (hasDuplicates(N, M, 0, c,1, 0)) {
                ++cnt;
            }
        }
        return cnt;
    }

    private static boolean hasDuplicates(int N, int[][] M, int r, int c, int rd, int cd) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(M[r][c]);
            r += rd;
            c += cd;
        }
        return set.size() < N;
    }

    private static int diagonalSum(int N, int[][] M) {
        int sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += M[i][i];
        }
        return sum;
    }

    static class Result {
        int x, k, r, c;

        @Override
        public String toString() {
            return String.format("Case #%d: %d %d %d%n", x, k, r, c);
        }
    }
}
