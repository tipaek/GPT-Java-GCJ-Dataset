
import java.util.*;

public class Solution {
    Scanner in = new Scanner(System.in);

    void solve501(int t, int n) {
        int N = n;
        List<int[]> pos = new ArrayList<>();
        if (n <= 500) {
            for (int i=0;i<n;i++) pos.add(new int[]{i+1, i+1});
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
//        verify(pos, N);
        System.out.println(String.format("Case #%d:", t));
        for (int[] p : pos) {
            System.out.println(p[0] + " " + p[1]);
        }
    }

    void solve1000(int t, int n) {
        int N = n;
        List<int[]> pos = new ArrayList<>();
        pos.add(new int[]{1, 1});
        n--;
        int i = 1;
        while (i*(i+1)/2 <= n) {
            i++;
        }
        i--;
        int k;
        for (k=1;k<=i;k++) {
            pos.add(new int[]{k+1, 2});
            n -= k;
        }
        k--;
        while (n > 0) {
            pos.add(new int[]{k+1, 1});
            k++;
            n--;
        }

//        verify(pos, N);

        System.out.println(String.format("Case #%d:", t));
        for (int[] p : pos) {
            System.out.println(p[0] + " " + p[1]);
        }
    }

    void solve(int t, int n) {
        if (n <= 501) solve501(t, n);
        else {
            solve1000(t, n);
        }
    }

    long val(int x, int y, Map<Integer, Map<Integer, Long>> memo) {
        if (x <= 2 || x == y || y == 1) return 1;
        if (memo.containsKey(x) && memo.get(x).containsKey(y)) return memo.get(x).get(y);
        long r = val(x-1, y, memo) + val(x-1, y-1, memo);
        memo.computeIfAbsent(x, k -> new HashMap<>()).put(y, r);
        return r;
    }

    void verify(List<int[]> pos, int n) {
        if (pos.size() > 500) throw new RuntimeException("Len: " + n);
        int sum = 0;
        Map<Integer, Map<Integer, Long>> memo = new HashMap<>();
        for (int[] p : pos) {
            sum += val(p[0], p[1], memo);
        }
        if (sum != n) {
            throw new RuntimeException("" + n);
        }
    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            int n = in.nextInt();
            solve(t, n);
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
