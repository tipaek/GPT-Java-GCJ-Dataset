import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static FastReader scn = new FastReader();
    static int tc, b;
    static int[] a = new int[100];
    static int sp = -1, dp = -1;
    static boolean r = false, c = false;
    static int q = 0;
    static OutputStream out = new BufferedOutputStream(System.out);
    static boolean wa = false;

    public static void main(String[] args) throws IOException {
        tc = scn.nextInt();
        b = scn.nextInt();
        for (int t = 1; t <= tc; t++) {
            solve();
            if (wa) break;
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
            for (int i = 0; i < b; i++) {
                out.write((a[i] + "").getBytes());
            }
            out.write("\n".getBytes());
            out.flush();
            scn.next();
            return;
        }
        determineChange();
        if (r) {
            for (int i = 0; i < b / 2; i++) {
                swap(i, b - i - 1);
            }
        }
        if (c) {
            for (int i = 0; i < b; i++) {
                a[i] = (a[i] == 0) ? 1 : 0;
            }
        }
        r = false;
        c = false;
        chan += 2;
        for (; g < b / 2; g++) {
            if ((q + 1) % 10 == 1) {
                determineChange();
                if (r) {
                    for (int i = 0; i < b / 2; i++) {
                        swap(i, b - i - 1);
                    }
                }
                if (c) {
                    for (int i = 0; i < b; i++) {
                        a[i] = (a[i] == 0) ? 1 : 0;
                    }
                }
                r = false;
                c = false;
                g--;
            } else {
                checkPair(g);
            }
            chan += 2;
        }
        for (int i = 0; i < b; i++) {
            out.write((a[i] + "").getBytes());
        }
        out.write("\n".getBytes());
        out.flush();
        String inp = scn.next();
        if (inp.charAt(0) == 'N') {
            wa = true;
        }
    }

    public static void determineChange() throws IOException {
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
            return;
        }
        if (csp != a[sp] && cdp != a[dp]) {
            c = true;
            return;
        }
        if (csp != a[sp] && cdp == a[dp]) {
            r = true;
            c = true;
        }
    }

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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