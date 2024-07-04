import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static String ans = "";

    public static void find(long x, long y, long i, long cx, long cy, String p) {
        if (Math.abs(cx) > Math.abs(x) * Math.abs(x) || Math.abs(cy) > Math.abs(y) * Math.abs(y)) {
            return;
        }
        if (cx == x && cy == y) {
            if (ans.isEmpty()) {
                ans = p;
            } else if (ans.length() > p.length()) {
                ans = p;
            }
            return;
        }

        long step = (long) Math.pow(2, i - 1);
        find(x, y, i + 1, cx + step, cy, p + "E");
        find(x, y, i + 1, cx, cy + step, p + "N");
        find(x, y, i + 1, cx - step, cy, p + "W");
        find(x, y, i + 1, cx, cy - step, p + "S");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test <= t; test++) {
            String[] inputs = br.readLine().split(" ");
            long x = Long.parseLong(inputs[0]);
            long y = Long.parseLong(inputs[1]);
            find(x, y, 1, 0, 0, "");
            if (ans.isEmpty()) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + ans);
            }
            ans = "";
        }
    }
}