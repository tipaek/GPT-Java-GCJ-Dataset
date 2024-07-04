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
        A solver = new A();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            String[] names = new String[N];
            for (int i = 0; i < N; i++) {
                names[i] = in.next();
            }
            boolean wrong = false;
            StringBuilder pref = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < names[i].length(); j++) {
                    if (names[i].charAt(j) == '*') {
                        break;
                    }
                    if (pref.length() <= j) {
                        pref.append(names[i].charAt(j));
                    }
                    if (names[i].charAt(j) != pref.charAt(j)) {
                        wrong = true;
                        break;
                    }
                }
            }
            StringBuilder suf = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < names[i].length(); j++) {
                    int ind = names[i].length() - j - 1;
                    if (names[i].charAt(ind) == '*') {
                        break;
                    }
                    if (suf.length() <= j) {
                        suf.append(names[i].charAt(ind));
                    }
                    if (names[i].charAt(ind) != suf.charAt(j)) {
                        wrong = true;
                        break;
                    }
                }
            }
            suf.reverse();
            for (int i = 0; i < N; i++) {
                int firstAst = names[i].length();
                for (int j = 0; j < names[i].length(); j++) {
                    if (names[i].charAt(j) == '*') {
                        firstAst = j;
                        break;
                    }
                }
                int lastAst = -1;
                for (int j = 0; j < names[i].length(); j++) {
                    int ind = names[i].length() - j - 1;
                    if (names[i].charAt(ind) == '*') {
                        lastAst = ind;
                        break;
                    }
                }
                for (int j = firstAst + 1; j < lastAst; j++) {
                    if (names[i].charAt(j) != '*') {
                        pref.append(names[i].charAt(j));
                    }
                }
            }
            if (wrong) {
                out.println("Case #" + testNumber + ": *");
            } else {
                pref.append(suf);
                out.println("Case #" + testNumber + ": " + pref);
            }
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public String nextLine() {

            try {

                return reader.readLine();

            } catch (IOException e) {

                return null;

            }

        }

        public String next() {

            while (stt == null || !stt.hasMoreTokens()) {

                stt = new StringTokenizer(nextLine());

            }

            return stt.nextToken();

        }

        public int nextInt() {

            return Integer.parseInt(next());

        }

    }
}

