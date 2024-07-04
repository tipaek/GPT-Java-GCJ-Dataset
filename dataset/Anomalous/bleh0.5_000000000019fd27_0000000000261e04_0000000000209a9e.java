import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        Task solver = new Task();
        int t = scan.nextInt();
        int l = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            solver.solve(i, scan, out, l);
        }
        out.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader sc, PrintWriter pw, int l) {
            int[] ans = new int[l];
            int reverse = 0;
            int flipped = 0;
            int got = 0;
            int firstOp = -1;
            int firstSa = -1;

            for (int i = 0; i < 5; i++) {
                processPair(sc, pw, ans, l, got, reverse, flipped);
                if (ans[l - got - 1] == ans[got] && firstSa == -1) firstSa = got;
                if (ans[l - got - 1] != ans[got] && firstOp == -1) firstOp = got;
                got++;
            }

            while (got < l / 2) {
                if (firstOp == -1 || firstSa == -1) {
                    handleSingleBitCheck(sc, pw, ans, flipped);
                } else {
                    handlePairCheck(sc, pw, ans, l, firstOp, firstSa, flipped, reverse);
                }

                for (int i = 0; i < 4; i++) {
                    processPair(sc, pw, ans, l, got, reverse, flipped);
                    if (ans[l - got - 1] == ans[got] && firstSa == -1) firstSa = got;
                    if (ans[l - got - 1] != ans[got] && firstOp == -1) firstOp = got;
                    got++;
                    if (got >= l / 2) break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : ans) {
                sb.append(x ^ flipped);
            }
            if (reverse > 0) sb.reverse();
            pw.println(sb);
            if (sc.nextLine().charAt(0) == 'N') System.exit(0);
        }

        private void processPair(FastReader sc, PrintWriter pw, int[] ans, int l, int got, int reverse, int flipped) {
            pw.println(got + 1);
            if (reverse == 1) {
                ans[l - got - 1] = sc.nextInt() ^ flipped;
            } else {
                ans[got] = sc.nextInt() ^ flipped;
            }
            pw.println(l - got);
            if (reverse == 1) {
                ans[got] = sc.nextInt() ^ flipped;
            } else {
                ans[l - got - 1] = sc.nextInt() ^ flipped;
            }
        }

        private void handleSingleBitCheck(FastReader sc, PrintWriter pw, int[] ans, int flipped) {
            pw.println(1);
            if ((ans[0] ^ flipped) != sc.nextInt()) {
                flipped ^= 1;
            }
            pw.println(1);
            sc.nextInt();
        }

        private void handlePairCheck(FastReader sc, PrintWriter pw, int[] ans, int l, int firstOp, int firstSa, int flipped, int reverse) {
            pw.println(firstSa + 1);
            if ((ans[firstSa] ^ flipped) != sc.nextInt()) {
                flipped ^= 1;
            }
            pw.println(firstOp + 1);
            int bit = sc.nextInt();
            if (reverse == 1) {
                if ((ans[l - firstOp - 1] ^ flipped) != bit) reverse = 0;
            } else {
                if ((ans[firstOp] ^ flipped) != bit) reverse = 1;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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