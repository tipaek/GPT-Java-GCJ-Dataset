import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    static int[] a;
    static int b;
    static Scanner sc;
    static int same, diff;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        b = sc.nextInt();
        a = new int[b];
        out = new PrintWriter(System.out);

        for (int tst = 1; tst <= t; tst++) {
            int c = 0;
            same = -1;
            diff = -1;

            for (; c < 5; c++) {
                findPair(c);
            }

            findChange();

            while (c < b / 2) {
                int i = 0;
                for (; i < 4 && c < b / 2; i++, c++) {
                    findPair(c);
                }
                if (i != 4) continue;
                findChange();
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b; i++) sb.append(a[i]);
            out.println(sb);
            out.flush();

            String s = sc.next();
            if (s.equals("N")) {
                System.exit(0);
            }
        }

        out.close();
        sc.close();
    }

    static int q(int i) {
        out.println(i + 1);
        out.flush();
        return sc.nextInt();
    }

    static void findPair(int i) {
        a[i] = q(i);
        a[b - i - 1] = q(b - i - 1);

        if (same == -1 && a[i] == a[b - i - 1]) {
            same = i;
        }

        if (diff == -1 && a[i] != a[b - i - 1]) {
            diff = i;
        }
    }

    static void findChange() {
        boolean comp = false;
        if (same != -1 && a[same] != q(same)) {
            comp = true;
        }

        boolean rev = false;
        if (diff != -1 && a[diff] != q(diff)) {
            rev = !comp;
        }

        if (comp) {
            for (int i = 0; i < b; i++) {
                a[i] = a[i] == 0 ? 1 : 0;
            }
        }

        if (rev) {
            for (int i = 0; i < b / 2; i++) {
                int tmp = a[i];
                a[i] = a[b - i - 1];
                a[b - i - 1] = tmp;
            }
        }
    }
}