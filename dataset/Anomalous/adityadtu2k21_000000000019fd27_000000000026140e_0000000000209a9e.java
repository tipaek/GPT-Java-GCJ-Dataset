import java.util.*;
import java.io.*;

public class Solution {
    static FastReader scn = new FastReader();
    static int tc, b;
    static int[] a = new int[100];
    static int sp = -1, dp = -1;
    static boolean reverse = false, complement = false;
    static int queryCount = 0;

    public static void main(String[] args) {
        tc = scn.nextInt();
        b = scn.nextInt();
        for (int t = 1; t <= tc; t++) {
            solve();
        }
    }

    public static int query(int idx) {
        queryCount++;
        System.out.println(idx + 1);
        return scn.nextInt();
    }

    public static void checkPair(int i) {
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
            checkPair(g);
            chan += 2;
        }

        if (b == 10) {
            printArray();
            scn.next();
            return;
        }

        determineChange();

        if (reverse) {
            reverseArray();
        }
        if (complement) {
            complementArray();
        }

        reverse = false;
        complement = false;
        chan += 2;

        for (; g < b / 2; g++) {
            if (chan % 10 == 1) {
                determineChange();
                if (reverse) {
                    reverseArray();
                }
                if (complement) {
                    complementArray();
                }
                reverse = false;
                complement = false;
                g--;
            } else {
                checkPair(g);
            }
            chan += 2;
        }

        printArray();
        scn.next();
    }

    public static void determineChange() {
        if (sp == -1) {
            int currentDp = query(dp);
            if (currentDp != a[dp]) {
                complement = true;
            }
            return;
        }
        if (dp == -1) {
            int currentSp = query(sp);
            if (currentSp != a[sp]) {
                complement = true;
            }
            return;
        }
        int currentSp = query(sp);
        int currentDp = query(dp);
        if (currentSp == a[sp] && currentDp != a[dp]) {
            reverse = true;
        } else if (currentSp != a[sp] && currentDp != a[dp]) {
            complement = true;
        } else if (currentSp != a[sp] && currentDp == a[dp]) {
            reverse = true;
            complement = true;
        }
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

    public static void printArray() {
        for (int i = 0; i < b; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
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