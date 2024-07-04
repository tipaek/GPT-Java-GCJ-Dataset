import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution {
    static Map<String, Integer> memo = new HashMap<String, Integer>();
    static int[][] ops = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nt; ++t) {
            int n = Integer.parseInt(br.readLine());
            Deque<int[]> res = new LinkedList<int[]>();
            solve(n, 1, 1, res, new HashSet<String>());
            System.out.format("Case #%d:\n", t);
            for (int[] step : res) System.out.format("%d %d\n", step[0], step[1]);
        }
        br.close();
    }
    private static int cal(int i, int j) {
        if (1 == j || i == j) return 1;
        int a = cal(i - 1, j), b = cal(i - 1, j - 1), c = a + b;
        memo.put(i + " " + j, c);
        return c;
    }
    private static boolean solve(int n, int i, int j, Deque<int[]> res, Set<String> used) {
        if (0 >= i || j > i || 0 >= j) return false;
        if (0 == n) return true;
        int val = cal(i, j);
        if (val > n) return false;
        res.add(new int[]{i, j});
        n -= val;
        for (int[] op: ops) {
            int x = i + op[0], y = j + op[1];
            String key = x + " " + y;
            if (used.contains(key)) continue;
            used.add(key);
            if (solve(n, x, y, res, used)) return true;
            used.remove(key);
        }
        res.pollLast();
        return false;
    }
}
