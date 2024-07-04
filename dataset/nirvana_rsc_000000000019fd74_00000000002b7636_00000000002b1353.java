import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Path {
        int r;
        int k;
        long d;
        List<List<Integer>> path;

        Path(int r, int k, long d, List<List<Integer>> path) {
            this.r = r;
            this.k = k;
            this.d = d;
            this.path = path;
        }
    }

    private static final int[][] DIRS = { { -1, -1 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final List<List<Integer>> triangle = generate(30);
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = in.nextInt();
            final List<List<Integer>> path = new ArrayList<>(Collections.singleton(Arrays.asList(1, 1)));
            final PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.d));
            final Set<String> visited = new HashSet<>(Collections.singleton("0,0,1"));
            pq.offer(new Path(0, 0, 1, path));
            List<List<Integer>> res = new ArrayList<>();
            while (!pq.isEmpty()) {
                final Path curr = pq.remove();
                if (curr.d == n) {
                    res = curr.path;
                    break;
                }
                for (int[] dir : DIRS) {
                    final int nr = curr.r + dir[0];
                    final int nk = curr.k + dir[1];
                    if (0 <= nr && nr < 30 && 0 <= nk && nk < triangle.get(nr).size()) {
                        final long nd = curr.d + triangle.get(nr).get(nk);
                        if (nd > n || curr.path.size() > 500 || visited.add(nr + "," + nk + ',' + nd)) {
                            final List<List<Integer>> npath = new ArrayList<>(curr.path);
                            npath.add(Arrays.asList(nr + 1, nk + 1));
                            pq.offer(new Path(nr, nk, nd, npath));
                        }
                    }
                }
            }
            System.out.println("Case #" + x + ':');
            for (List<Integer> p : res) {
                System.out.println(p.get(0) + " " + p.get(1));
            }
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            final List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int k = 1; k < i; k++) {
                curr.add(res.get(i - 1).get(k - 1) + res.get(i - 1).get(k));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}
