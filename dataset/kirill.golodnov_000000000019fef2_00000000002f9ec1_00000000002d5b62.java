import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, UTF_8));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, UTF_8))) {
            int tests = parseInt(in.readLine().trim());
            for (int t = 1; t <= tests; t++) {
                StringTokenizer tokens = new StringTokenizer(in.readLine());
                int x = parseInt(tokens.nextToken());
                int y = parseInt(tokens.nextToken());
                Pair p = f(x, y, 0, "");
                if (p == null) {
                    out.write("Case #" + t + ": IMPOSSIBLE");
                    out.newLine();
                } else {
                    out.write("Case #" + t + ": " + p.s);
                    out.newLine();
                }
            }
        }
    }

    private static Pair f(int x, int y, int stepsNow, String wayNow) {
//        System.out.println("Running " + x + "; " + y + "; " + stepsNow + "; " + wayNow);
        if (x == 0 && y == 0) {
            return new Pair(stepsNow, wayNow);
        }
        if (x == 1 && y == 0) {
            return new Pair(stepsNow + 1, wayNow + "E");
        } else if (x == -1 && y == 0) {
            return new Pair(stepsNow + 1, wayNow + "W");
        } else if (x == 0 && y == 1) {
            return new Pair(stepsNow + 1, wayNow + "N");
        } else if (x == 0 && y == -1) {
            return new Pair(stepsNow + 1, wayNow + "S");
        }
        if ((even(x) && even(y)) || (odd(x) && odd(y))) {
            return null;
        }
        if (odd(x)) {
            Pair s1 = f((x - 1) / 2, y / 2, stepsNow + 1, wayNow + "E");
            Pair s2 = f((x + 1) / 2, y / 2, stepsNow + 1, wayNow + "W");
            if (s1 == null) {
                return s2;
            } else if (s2 == null) {
                return s1;
            }
            return s1.steps >= s2.steps ? s2 : s1;
        }
        if (odd(y)) {
            Pair s1 = f(x / 2, (y - 1) / 2, stepsNow + 1, wayNow + "N");
            Pair s2 = f(x / 2, (y + 1) / 2, stepsNow + 1, wayNow + "S");
            if (s1 == null) {
                return s2;
            } else if (s2 == null) {
                return s1;
            }
            return s1.steps >= s2.steps ? s2 : s1;
        }
        return null;
    }

    private static boolean even(int s) {
        return (s & 1) == 0;
    }

    private static boolean odd(int s) {
        return (s & 1) == 1;
    }

    private static class Pair {

        int steps;
        String s;

        public Pair(int steps, String s) {
            this.steps = steps;
            this.s = s;
        }
    }
}
