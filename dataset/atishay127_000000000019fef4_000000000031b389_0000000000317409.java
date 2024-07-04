import static java.lang.Math.abs;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(final String[] args) throws Exception {
        final int testcases = in.nextInt();
        for (int i = 0; i < testcases; i++) {
            out.print("Case #" + (i + 1) + ": ");
            new Solution().solve();
        }
        out.flush();
    }

    private long solve() throws Exception {
        int x = in.nextInt();
        int y = in.nextInt();
        String m = in.next().trim();
        for (int i = 0; i < m.length(); i++) {
            char ch = m.charAt(i);
            if (ch == 'N') {
                y++;
            } else if (ch == 'S') {
                y--;
            } else if (ch == 'E') {
                x++;
            } else {
                --x;
            }
            if (abs(x) + abs(y) <= i + 1) {
                out.println(i + 1);
                return -1;
            }
        }
        out.println("IMPOSSIBLE");
        return 1;
    }
}