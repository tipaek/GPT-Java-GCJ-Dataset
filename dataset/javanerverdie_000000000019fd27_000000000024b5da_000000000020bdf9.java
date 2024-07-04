import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int s, e, index;
        char name = 0;

        Pair(int start, int end, int i) {
            this.s = start;
            this.e = end;
            this.index = i;
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
            a[i] = new Pair(scanner.nextInt(), scanner.nextInt(), i);
        }
        Arrays.sort(a, new Comparator<Pair>() {
            @Override
            public int compare(Pair t1, Pair t2) {
                return Integer.compare(t1.s, t2.s);
            }
        });
        ArrayList<Pair> jamie = new ArrayList<>();
        ArrayList<Pair> came = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!isConflict(jamie, a[i])) {
                a[i].name = 'C';
                jamie.add(a[i]);
            } else if (!isConflict(came, a[i])) {
                a[i].name = 'J';
                came.add(a[i]);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        Arrays.sort(a, new Comparator<Pair>() {
            @Override
            public int compare(Pair t1, Pair t2) {
                return Integer.compare(t1.index, t2.index);
            }
        });
        for (int i = 0; i < n; i++)
            System.out.print(a[i].name);
        System.out.println();
    }

    private static boolean isConflict(ArrayList<Pair> list, Pair p) {
        for (Pair t : list) {
            if ((t.e > p.s && t.s < p.s)
                    || (t.s < p.e && t.e > p.s)
                    || (p.s < t.s && p.e > t.e)
                    || (t.s < p.s && t.e > p.e))
                return true;
        }
        return false;
    }
}
