
import java.util.*;

public class Solution {
    static int n;
    static int k;
    static int testCase;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nt = sc.nextInt();
        for (int tc = 1; tc <= nt; tc++) {
            testCase = tc;
            n = sc.nextInt();
            k = sc.nextInt();
            if (!comb(0, 1, new int[n], 0)) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
        }
    }

    static boolean comb(int ind, int start, int[] comb, int sum) {
        if (ind == n) {
            if (sum == k) {
                if (check(comb)) return true;
            }
            return false;
        }
        if (k - sum < (n - ind) * start) return false;
        for (int i = start; i <= n; i++) {
            comb[ind] = i;
            if (comb(ind + 1, i, comb, sum + i)) return true;
        }
        return false;
    }

    static boolean check(int[] comb) {
        int[][] map = new int[n][n];
        HashSet<Integer>[][] cands = new HashSet[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cands[i][j] = new HashSet<>();
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return cands[ints[0]][ints[1]].size() - cands[t1[0]][t1[1]].size();
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    map[i][j] = comb[i];
                    continue;
                }
                for (int k = 1; k <= n; k++) {
                    if (k == comb[i] || k == comb[j]) continue;
                    cands[i][j].add(k);
                }
                pq.offer(new int[] {i, j});
            }
        }
        int cnt = n * n - n;
        while (!pq.isEmpty() && cnt > 0) {
            int[] curr = pq.poll();
            if (map[curr[0]][curr[1]] != 0) continue;
            if (cands[curr[0]][curr[1]].isEmpty()) return false;
            cnt--;
            int num = cands[curr[0]][curr[1]].iterator().next();
            map[curr[0]][curr[1]] = num;
            for (int i = 0; i < n; i++) {
                if (cands[curr[0]][i].remove(num)) pq.offer(new int[] {curr[0], i});
                if (cands[i][curr[1]].remove(num)) pq.offer(new int[] {i, curr[1]});
            }
        }
        if (cnt == 0) {
            System.out.println("Case #" + testCase + ": POSSIBLE");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        return false;
    }
}
