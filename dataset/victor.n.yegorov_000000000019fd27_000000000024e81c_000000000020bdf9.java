import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static String solve(Scanner sc) {
        class Point {
            final int x, k;
            final boolean open;

            Point(int x, int k, boolean open) {
                this.x = x;
                this.k = k;
                this.open = open;
            }
        }

        final int n = sc.nextInt();
        final List<Point> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            a.add(new Point(sc.nextInt(), i + 1, true));
            a.add(new Point(sc.nextInt(), i + 1, false));
        }
        a.sort(Comparator.<Point>comparingInt(p -> p.x).thenComparingInt(p -> p.open ? 1 : 0));

        final char[] res = new char[n];
        int kc = 0, kj = 0;
        for (Point p : a) {
            final int k = p.k;
            if (p.open) {
                if (((kc > 0) && (kj > 0)) || (kc == k) || (kj == k)) {
                    return "IMPOSSIBLE";
                }
                if (kc > 0) {
                    kj = k;
                    res[k - 1] = 'J';
                } else {
                    kc = k;
                    res[k - 1] = 'C';
                }
            } else {
                if ((kc != k) && (kj != k)) {
                    return "IMPOSSIBLE";
                }
                kc = (kc == k) ? 0 : kc;
                kj = (kj == k) ? 0 : kj;
            }
        }

        return new String(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; ++i) {
            String output = solve(sc);
            sb.append("Case #").append(i).append(": ").append(output).append("\n");
        }

        System.out.print(sb);
    }
}