import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader scn = new FastReader();
    static int tc, b;
    static int[] a = new int[100];
    static int sp = -1, dp = -1;
    static boolean r = false, c = false;
    static int q = 0;

    public static void main(String[] args) {
        tc = scn.nextInt();
        b = scn.nextInt();
        for (int t = 1; t <= tc; t++) {
            solve();
        }
    }

    public static int query(int idx) {
        q++;
        System.out.println(idx + 1);
        return scn.nextInt();
    }

    public static void check_p(int i) {
        a[i] = query(i);
        a[b - i - 1] = query(b - i - 1);
        if (a[i] == a[b - i - 1]) {
            sp = i;
        } else {
            dp = i;
        }
    }

    public static void solve() {
        int g = 0;
        int chan = 0;
        for (; g < 5; g++) {
            check_p(g);
            chan += 2;
        }
        if (b == 10) {
            printArray();
            return;
        }
        det_change();
        if (r) {
            reverseArray();
        }
        if (c) {
            invertArray();
        }
        r = false;
        c = false;
        chan += 2;
        for (; g < b / 2; g++) {
            if ((q + 1) % 10 == 1) {
                det_change();
                if (r) {
                    reverseArray();
                }
                if (c) {
                    invertArray();
                }
                r = false;
                c = false;
                g--;
            } else {
                check_p(g);
            }
            chan += 2;
        }
        printArray();
    }

    public static void det_change() {
        if (sp == -1) {
            int cdp = query(dp);
            int rdp = query(b - dp - 1);
            if (cdp != a[dp]) {
                c = true;
            }
            return;
        }
        if (dp == -1) {
            int csp = query(sp);
            int rsp = query(b - sp - 1);
            if (csp != a[sp]) {
                c = true;
            }
            return;
        }
        int csp = query(sp);
        int cdp = query(dp);
        if (csp == a[sp] && cdp != a[dp]) {
            r = true;
        } else if (csp != a[sp] && cdp != a[dp]) {
            c = true;
        } else if (csp != a[sp] && cdp == a[dp]) {
            r = true;
            c = true;
        }
    }

    public static void reverseArray() {
        for (int i = 0; i < b / 2; i++) {
            swap(i, b - i - 1);
        }
    }

    public static void invertArray() {
        for (int i = 0; i < b; i++) {
            a[i] = a[i] == 0 ? 1 : 0;
        }
    }

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray() {
        for (int i = 0; i < b; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        scn.nextLine();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}