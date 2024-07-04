import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String ans = "";

    public static void find(long x, long y, long i, long cx, long cy, String path) {
        if (Math.abs(cx) > 100 || Math.abs(cy) > 100) {
            return;
        }
        if (cx == x && cy == y) {
            if (ans.isEmpty()) {
                ans = path;
            } else if (ans.length() > path.length()) {
                ans = path;
            }
            return;
        }

        long step = (long) Math.pow(2, i - 1);
        find(x, y, i + 1, cx + step, cy, path + "E");
        find(x, y, i + 1, cx, cy + step, path + "N");
        find(x, y, i + 1, cx - step, cy, path + "W");
        find(x, y, i + 1, cx, cy - step, path + "S");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            String[] input = br.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);

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