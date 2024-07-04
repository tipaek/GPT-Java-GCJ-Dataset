import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        solve(in, out);
        out.close();
    }

    static void solve(Scanner in, PrintWriter out) {
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int x = in.nextInt(), y = in.nextInt();
            String m = in.next();
            int tt = 0;
            boolean res = false;
            for (int i = 0; i < m.length(); i++) {
                if (x == 0 && y == 0) break;

                // move
                char c = m.charAt(i);
                if (c == 'N') {
                    y++;
                } else if (c == 'S') {
                    y--;
                } else if (c == 'W') {
                    x--;
                } else {
                    x++;
                }
                tt++;

                if (Math.abs(x) + Math.abs(y) <= tt) {
                    res = true;
                    break;
                }
            }
            out.println("Case #" + (t+1) + ": " + (res ? tt : "IMPOSSIBLE"));
        }
    }
}
