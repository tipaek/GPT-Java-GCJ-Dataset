import java.util.*;

public class Solution {
    private final Scanner in = new Scanner(System.in);

    private void solve501(int t, int n) {
        List<int[]> pos = new ArrayList<>();
        if (n <= 500) {
            for (int i = 0; i < n; i++) {
                pos.add(new int[]{i + 1, i + 1});
            }
        } else {
            pos.add(new int[]{1, 1});
            pos.add(new int[]{2, 2});
            pos.add(new int[]{3, 2});
            n -= 4;
            int i = 3;
            while (n > 0) {
                pos.add(new int[]{i, i});
                i++;
                n--;
            }
        }
        printCase(t, pos);
    }

    private void solve1000(int t, int n) {
        List<int[]> pos = new ArrayList<>();
        pos.add(new int[]{1, 1});
        n--;
        int i = 1;
        while (i * (i + 1) / 2 <= n) {
            i++;
        }
        i--;
        int k;
        for (k = 1; k <= i; k++) {
            pos.add(new int[]{k + 1, 2});
            n -= k;
        }
        k--;
        while (n > 0) {
            pos.add(new int[]{k + 1, 1});
            k++;
            n--;
        }
        printCase(t, pos);
    }

    private void solve(int t, int n) {
        if (n <= 501) {
            solve501(t, n);
        } else {
            solve1000(t, n);
        }
    }

    private long val(int x, int y, Map<Integer, Map<Integer, Long>> memo) {
        if (x <= 2 || x == y || y == 1) {
            return 1;
        }
        if (memo.containsKey(x) && memo.get(x).containsKey(y)) {
            return memo.get(x).get(y);
        }
        long result = val(x - 1, y, memo) + val(x - 1, y - 1, memo);
        memo.computeIfAbsent(x, k -> new HashMap<>()).put(y, result);
        return result;
    }

    private void verify(List<int[]> pos, int n) {
        if (pos.size() > 500) {
            throw new RuntimeException("Len: " + n);
        }
        int sum = 0;
        Map<Integer, Map<Integer, Long>> memo = new HashMap<>();
        for (int[] p : pos) {
            sum += val(p[0], p[1], memo);
        }
        if (sum != n) {
            throw new RuntimeException("" + n);
        }
    }

    private void printCase(int t, List<int[]> pos) {
        System.out.println(String.format("Case #%d:", t));
        for (int[] p : pos) {
            System.out.println(p[0] + " " + p[1]);
        }
    }

    private void run() {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            solve(t, n);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}