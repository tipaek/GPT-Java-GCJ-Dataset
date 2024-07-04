import java.io.*;
import java.util.*;

public class Solution {
    static int X, Y;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            X = in.nextInt();
            Y = in.nextInt();
            TreeSet<String> set = new TreeSet(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });
            solve(0, 0, 0, "", set);
            System.out.printf("Case #%d: %s\n", t, set.isEmpty() ? "IMPOSSIBLE" : set.first());
        }
        in.close();
    }
    private static void solve(int x, int y, int d, String jumps, TreeSet<String> set) {
        if (!set.isEmpty() && d > set.first().length() || Math.abs(x) > Math.abs(X) || Math.abs(y) > Math.abs(Y)) return;
        if (x == X && y == Y) set.add(jumps);
        else {
            solve(x + (int) Math.pow(2, d), y, d + 1, jumps + "E", set);
            solve(x - (int) Math.pow(2, d), y, d + 1, jumps + "W", set);
            solve(x, y + (int) Math.pow(2, d), d + 1, jumps + "N", set);
            solve(x, y - (int) Math.pow(2, d), d + 1, jumps + "S", set);
        }
    }
}