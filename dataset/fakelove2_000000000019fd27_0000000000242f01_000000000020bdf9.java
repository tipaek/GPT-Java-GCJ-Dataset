import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int s, e;
        char name = 0;

        Pair(int start, int end) {
            this.s = start;
            this.e = end;
        }
    }

    public static void main(String[] args) {
        try {
            InputStream is = System.in;
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
            int t = scanner.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                System.out.print("Case #");
                System.out.print(i);
                System.out.print(": ");
                solve(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }

        ArrayList<Pair> jamie = new ArrayList<>();
        ArrayList<Pair> came = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (valid(jamie, a[i])) {
                a[i].name = 'C';
                jamie.add(a[i]);
            } else if (valid(came, a[i])) {
                a[i].name = 'J';
                came.add(a[i]);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        for (int i = 0; i < n; i++)
            System.out.print(a[i].name);
        System.out.println();
    }

    private static boolean valid(ArrayList<Pair> list, Pair p) {
        for (Pair t : list) {
            if ((t.e >= p.s && t.s <= p.s)
                    || (t.s <= p.e && t.e >= p.s)
                    || (p.s <= t.s && p.e >= t.e)
                    || (t.s <= p.s && t.e >= p.e))
                return false;
        }
        return true;
    }
}
