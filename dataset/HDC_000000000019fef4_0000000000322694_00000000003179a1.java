import java.lang.*;
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nt; ++t) {
            long U = Integer.parseInt(br.readLine()), upper = (long) Math.pow(10, U) - 1;
            int[][] edge = new int[10][26];
            for (int i = 0; i < 10000; ++i) {
                String[] data = br.readLine().split("\\s+");
                char[] Q = data[0].toCharArray();
                char[] R = data[1].toCharArray();
                Long val = Long.parseLong(data[0]);
                if ('-' == Q[0] || val > upper) continue;
                if (Q.length == R.length) {
                    for (int j = 0; j < Q.length; ++j) {
                        int a = Q[j] - '0', b = R[j] - 'A';
                        edge[a][b]++;
                    }
                } else {
                    for (int p = 0; p < Q.length; ++p) {
                        for (int q = 0; q < R.length; ++q) {
                            int a = Q[p] - '0', b = R[q] - 'A';
                            edge[a][b]++;
                        }
                    }
                }
            }
            PriorityQueue<int[]>[] pqs = new PriorityQueue[10];
            for (int i = 0; i < 10; ++i) {
                pqs[i] = new PriorityQueue<int[]>(1, (a, b) -> b[0] - a[0]);
                for (int j = 0; j < 26; ++j) {
                    if (0 == edge[i][j]) continue;
                    pqs[i].add(new int[]{edge[i][j], 'A' + j});
                }
            }
            System.out.format("Case #%d: %s\n", t, solve(pqs));
        }
        br.close();
    }
    private static String solve(PriorityQueue<int[]>[] edge) {
        StringBuilder sb = new StringBuilder();
        dfs(edge, 0, sb, new HashSet<Character>());
        return sb.toString();
    }
    private static boolean dfs(PriorityQueue<int[]>[] edge, int i, StringBuilder sb, Set<Character> used) {
        if (edge.length == i) return true;
        while (!edge[i].isEmpty()) {
            char c = (char) edge[i].poll()[1];
            if (used.contains(c)) continue;
            used.add(c);
            sb.append(c);
            if (dfs(edge, i + 1, sb, used)) return true;
            used.remove(c);
            sb.setLength(i + 1);
        }
        return false;
    }
}
