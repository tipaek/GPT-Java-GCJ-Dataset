import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scn = new FastReader();
    static int tc, b;
    static int[] a = new int[100];
    static int sp = -1, dp = -1;
    static boolean r = false, c = false;
    static int q = 0;
    static OutputStream out = new BufferedOutputStream(System.out);

    public static void main(String[] args) throws IOException {
        tc = scn.nextInt();
        b = scn.nextInt();
        for (int t = 1; t <= tc; t++) {
            solve();
        }
    }

    public static int query(int idx) throws IOException {
        q++;
        out.write(((idx + 1) + "\n").getBytes());
        out.flush();
        return scn.nextInt();
    }

    public static void checkPair(int i) throws IOException {
        a[i] = query(i);
        a[b - i - 1] = query(b - i - 1);
        if (a[i] == a[b - i - 1]) {
            sp = i;
        } else {
            dp = i;
        }
    }

    public static void solve() throws IOException {
        int g = 0;
        int chan = 0;
        for (; g < 5; g++) {
            checkPair(g);
            chan += 2;
        }
        if (b == 10) {
            printArray();
            scn.next();
            return;
        }
        determineChange();
        applyChanges();
        chan += 2;
        for (; g < b / 2; g++) {
            if ((q + 1) % 10 == 1) {
                determineChange();
                applyChanges();
                g--;
            } else {
                checkPair(g);
            }
            chan += 2;
        }
        printArray();
        scn.next();
    }

    public static void determineChange() throws IOException {
        if (sp == -1) {
            handleDpOnly();
            return;
        }
        if (dp == -1) {
            handleSpOnly();
            return;
        }
        handleBothSpAndDp();
    }

    public static void handleDpOnly() throws IOException {
        int cdp = query(dp);
        int rdp = query(b - dp - 1);
        if (cdp != a[dp]) {
            c = true;
        }
    }

    public static void handleSpOnly() throws IOException {
        int csp = query(sp);
        int rsp = query(b - sp - 1);
        if (csp != a[sp]) {
            c = true;
        }
    }

    public static void handleBothSpAndDp() throws IOException {
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

    public static void applyChanges() {
        if (r) {
            reverseArray();
        }
        if (c) {
            complementArray();
        }
        r = false;
        c = false;
    }

    public static void reverseArray() {
        for (int i = 0; i < b / 2; i++) {
            swap(i, b - i - 1);
        }
    }

    public static void complementArray() {
        for (int i = 0; i < b; i++) {
            a[i] = (a[i] == 0) ? 1 : 0;
        }
    }

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray() throws IOException {
        for (int i = 0; i < b; i++) {
            out.write((a[i] + "").getBytes());
        }
        out.write("\n".getBytes());
        out.flush();
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