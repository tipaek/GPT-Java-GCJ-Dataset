import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution {
    static int[][] ops = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static char[] dir = new char[]{'E','W','N','S'};
    public static void main(String[] argu) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nt; ++t) {
            String[] data = br.readLine().split("\\s+");
            int x = Integer.parseInt(data[0]), y = Integer.parseInt(data[1]);
            String res = solve(0, 0, x, y, 0);
            System.out.format("Case #%d: %s\n", t, null == res ? "IMPOSSIBLE" : res);
        }
        br.close();
    }
    private static String solve(long i, long j, long x, long y, int step) {
        if (33 == step) return null;
        if (i == x && j == y) return "";
        long dist = 1L << step, mask = (1L << (step + 1)) - 1;
        int len = Integer.MAX_VALUE;
        String ret = null;
        for (int p = 0; p < 4; ++p) {
            long pi = i + ops[p][0] * dist, pj = j + ops[p][1] * dist;
            long dx = Math.abs(pi - x), dy = Math.abs(pj - y);
            if (0 != (dx & dy) || 0 != ((dx | dy) & mask)) continue;
            String cand = solve(pi, pj, x, y, step + 1);
            if (null == cand) continue;
            String res = dir[p] + cand;
            if (len > res.length()) {
                len = res.length();
                ret = res;
            }
        }
        return ret;
    }/*
    private static String solve(int x, int y) {
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    for (int step = 0; step < 32; ++step) {
    int p = 0, dist = 1 << step, best = Integer.MAX_VALUE, candidate = -1, mask = (1 << (step + 1)) - 1;
    int ox = Math.abs(i - x), oy = Math.abs(j - y), far = ox & oy;
    for (;p < 4; ++p) {
    int pi = i + ops[p][0] * dist, pj = j + ops[p][1] * dist;
    int dx = Math.abs(pi - x), dy = Math.abs(pj - y);
    if (0 != (dx & dy) || 0 != ((dx | dy) & mask)) continue;
    if ((0 != far && ox + oy < dx + dy) || (0 == far && ox + oy > dx + dy)){
    candidate = p;
    best = dx + dy;
    }
    }
    if (-1 == candidate) return "IMPOSSIBLE";
    i += ops[candidate][0] * dist;
    j += ops[candidate][1] * dist;
    int dx = Math.abs(i - x), dy = Math.abs(j - y);
    if (1 == ((dx >> step) & 1) || 1 == ((dy >> step) & 1)) return "IMPOSSIBLE";
    sb.append(dir[candidate]);
    if (i == x && j == y) break;
    }
    return sb.toString();
    }*/
}
