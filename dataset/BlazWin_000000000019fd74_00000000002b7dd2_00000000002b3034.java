import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class PatternMatching {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String[] ss = new String[n];
            String prefix = "";
            String syffix = "";
            for (int i = 0; i < n; i++) {
                String s = in.next();
                int h = 0;
                while (h < s.length() && s.charAt(h) != '*') {
                    h++;
                }
                if (h > prefix.length()) {
                    prefix = s.substring(0, h);
                }
                h = s.length() - 1;
                while (h >= 0 && s.charAt(h) != '*') {
                    h--;
                }
                if (s.length() - h - 1 > syffix.length()) {
                    syffix = s.substring(h + 1);
                }
                ss[i] = s;
            }
            int[] st = new int[n];
            int[] ed = new int[n];
            for (int i = 0; i < n; i++) {
                int cur = 0;
                for (int h = 0; h < prefix.length(); h++) {
                    if (cur >= ss[i].length()) {
                        printBad(testNumber, out);
                        return;
                    }
                    if (ss[i].charAt(cur) == prefix.charAt(h)) {
                        cur++;
                    } else if (ss[i].charAt(cur) != '*') {
                        printBad(testNumber, out);
                        return;
                    }
                }
                st[i] = cur;
                cur = ss[i].length() - 1;
                for (int h = syffix.length() - 1; h >= 0; h--) {
                    if (cur < 0) {
                        printBad(testNumber, out);
                        return;
                    }
                    if (ss[i].charAt(cur) == syffix.charAt(h)) {
                        cur--;
                    } else if (ss[i].charAt(cur) != '*') {
                        printBad(testNumber, out);
                        return;
                    }
                }
                ed[i] = cur;
            }
            out.print(String.format("Case #%d: %s", testNumber, prefix));
            for (int i = 0; i < n; i++) {
                for (int h = st[i]; h <= ed[i]; h++) {
                    if (ss[i].charAt(h) != '*') {
                        out.print(ss[i].charAt(h));
                    }
                }
            }
            out.println(syffix);
        }

        public static void printBad(int testNumber, PrintWriter out) {
            out.println(String.format("Case #%d: *", testNumber));
        }
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

