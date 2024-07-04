import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x % 2 == 1 && y % 2 == 1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (i + 1) + ": ");
                solve(x, y, 0, 0, 0, "");
            }
        }
    }

    public static void solve(int x, int y, int dx, int dy, int curStep, String ans) {
        if (dx == x && dy == y) {
            System.out.println(ans);
        } else if (Math.abs(dx) <= Math.abs(x) && Math.abs(dy) <= Math.abs(y)) {
            solve(x, y, dx + (int) Math.pow(2, curStep), dy, curStep + 1, ans + "E");
            solve(x, y, dx - (int) Math.pow(2, curStep), dy, curStep + 1, ans + "W");
            solve(x, y, dx, dy + (int) Math.pow(2, curStep), curStep + 1, ans + "N");
            solve(x, y, dx, dy - (int) Math.pow(2, curStep), curStep + 1, ans + "S");
        }
    }
}