import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.DoubleToIntFunction;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int K = in.nextInt();
            System.out.print("Case #" + i + ": ");
            int[][] res = build(N, K);
            if (res.length != 0) {
                System.out.println("POSSIBLE");
                for (int[] row : res) {
                    for (int c = 0; c < N - 1; c++) {
                        System.out.print(row[c] + " ");
                    }
                    System.out.println(row[N - 1]);
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static int[][] build(int N, int K) {
        List<List<Integer>> combination = getCombination(N, K);
        for (List<Integer> com : combination) {
            List<Set<Integer>> row = new ArrayList<>();
            List<Set<Integer>> col = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                row.add(new HashSet<>());
                col.add(new HashSet<>());
            }
            int[][] res = new int[N][N];
            for (int i = 0; i < com.size(); i++) {
                int num = com.get(i);
                res[i][i] = num;
                row.get(i).add(num);
                col.get(i).add(num);
            }
            boolean f = dfs2(res, row, col, 0, 1, N);
            if (f) {
                return res;
            }
        }
        return new int[0][0];
    }

    public static boolean dfs2(int[][] res, List<Set<Integer>> row, List<Set<Integer>> col, int x, int y, int N) {
        if (x == N) {
            return true;
        }
        int nextX = x;
        int nextY = y;
        nextY++;
        if (nextY == nextX) {
            nextY++;
        }
        nextX += nextY / N;
        nextY = nextY % N;
        for (int i = 1; i <= N; i++) {
            if (row.get(x).contains(i) || col.get(y).contains(i)) {
                continue;
            }
            res[x][y] = i;
            row.get(x).add(i);
            col.get(y).add(i);
            boolean f = dfs2(res, row, col, nextX, nextY, N);
            if (f) {
                return true;
            }
            row.get(x).remove(i);
            col.get(y).remove(i);
        }

        return false;
    }

    public static List<List<Integer>> getCombination(int N, int K) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, 0, N, K);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> comb, int last, int sum, int N, int target) {
        if (comb.size() == N) {
            if (sum == target) {
                res.add(new ArrayList<>(comb));
            }
            return;
        }
        for (int i = last; i <= N; i++) {
            if (sum + i > target) {
                continue;
            }
            comb.add(i);
            dfs(res, comb, i, sum + i, N, target);
            comb.remove(comb.size() - 1);
        }
    }
}