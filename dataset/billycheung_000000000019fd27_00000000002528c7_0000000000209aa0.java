import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(), k = in.nextInt();
            System.out.println("Case #" + i + ": " + getData(n, k));
        }
    }

    private static String getData(int n, int k) {
        int[][] A = new int[n][n];
        Set<Integer>[] rows = new HashSet[n + 1];
        Set<Integer>[] cols = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        boolean success = backtrack(n, k, A, 0, rows, cols);
        return !success ? "IMPOSSIBLE" : "POSSIBLE\n" + construct(A);
    }

    private static boolean backtrack(int n, int k, int[][] A, int index, Set<Integer>[] rows, Set<Integer>[] cols) {
        if (k < 0) {
            return false;
        }
        int row = index / n, col = index % n;
        if (index == n * n) {
            if (k == 0) {
                return true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (rows[row].contains(i) || cols[col].contains(i)) {
                continue;
            }
            A[row][col] = i;
            rows[row].add(i);
            cols[col].add(i);
            if (backtrack(n, (row == col) ? k - i : k, A, index + 1, rows, cols)) {
                return true;
            }
            rows[row].remove(i);
            cols[col].remove(i);
            A[row][col] = 0;
        }
        return false;
    }

    private static String construct(int[][] A) {
        StringBuilder sb = new StringBuilder();
        for (int[] a : A) {
            sb.append(Arrays.stream(a)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(" "))).append("\n");

        }
        return sb.toString();
    }
}