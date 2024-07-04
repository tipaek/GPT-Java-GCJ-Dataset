
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt(); //num max
            int s = in.nextInt(); //semi max
            solve(r, s, i);

        }
    }

    public static class card {

        int r = 0, s = 0;

        public card(int r, int s) {
            this.r = r;
            this.s = s;
        }
    }

    public static void solve(int r, int s, int caso) {
        int b = (r * s) - (r + 1), a = r, m = 1;
        int counta = 0;
        m = (r - 1) * (s - 1);

        System.out.println("Case #" + caso + ": " + m);
        for (int j = 0; j < m; j++) {
            System.out.println(a + " " + b);
            b--;
            counta++;
            if (counta == (s - 1)) {
                counta = 0;
                a--;
            }
        }
    }

}
