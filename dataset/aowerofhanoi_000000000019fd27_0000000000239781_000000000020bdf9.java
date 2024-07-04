import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class Interval {
        int s, t;

        public Interval(int s, int t) {
            this.s = s;
            this.t = t;
        }

        boolean overlap(Interval iv) {
            boolean notOverlap = t <= iv.s || iv.t <= s;
            return !notOverlap;
        }
    }

    static void rec(ArrayList<Integer>[] G, int[] colors, int v, int color) {
        if (colors[v] == 2) { // already invalid
            return;
        } else if (colors[v] == -1) { // not visited
            colors[v] = color;
            for (int w: G[v]) {
                rec(G, colors, w, (color + 1) % 2);
            }
        } else if (colors[v] != color) {// already visited but color is not consistent
            colors[v] = 2;
        }
    }

    static String innerSolve(Scanner sc) {
        int N = sc.nextInt();
        Interval iv[] = new Interval[N];
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            iv[i] = new Interval(s, t);
        }
        ArrayList<Integer>[] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (iv[i].overlap(iv[j])) {
                    G[i].add(j);
                }
            }
        }
        int colors[] = new int[N]; // -1 not yet, 0 C, 1 J, 2 invalid
        Arrays.fill(colors, -1);

        for (int v = 0; v < N; v++) {
            if (colors[v] == -1) {
                rec(G, colors, v, 0);
            }
        }

        StringBuilder out = new StringBuilder();
        for (int v = 0; v < N; v++) {
            if (colors[v] == 0) {
                out.append('C');
            } else if (colors[v] == 1) {
                out.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String ans = innerSolve(sc);
            System.out.println("Case #" + t + ": " + ans);
        }
    }
}
