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
 *
 * @author Nikita Mikhailov
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        private String[] split(String a) {
            boolean rev = false;
            if (a.startsWith("*")) {
                rev = true;
            }

            if (rev) {
                a = Utils.reverseString(a);
            }

            String[] res;

            int index = a.indexOf('*');
            res = new String[]{a.substring(0, index), a.substring(index + 1).replaceAll("\\*", "")};

            if (rev) {
                res = new String[]{
                        Utils.reverseString(res[0]),
                        Utils.reverseString(res[1])
                };
            }

            return res;
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            String prefix = "";
            String suffix = "";
            StringBuilder middle = new StringBuilder();

            int n = in.readInt();

            boolean fail = false;

            for (int i = 0; i < n; i++) {
                String s = in.readToken();
                if (fail) {
                    continue;
                }

                boolean hasMiddle = false;
                boolean hasStart = false;
                boolean hasEnd = false;

                String startValue = "", middleValue = "", endValue = "";


                if (s.startsWith("*") && s.endsWith("*")) {
                    hasMiddle = true;
                    middleValue = s;
                } else if (s.startsWith("*")) {
                    hasStart = true;

                    String[] tmp = this.split(s);
                    startValue = tmp[0];
                    middleValue = tmp[1];

                    if (middleValue.length() > 0) {
                        hasMiddle = true;
                    }
                } else if (s.endsWith("*")) {
                    hasEnd = true;

                    String[] tmp = this.split(s);
                    endValue = tmp[0];
                    middleValue = tmp[1];

                    if (middleValue.length() > 0) {
                        hasMiddle = true;
                    }
                } else {
                    hasStart = true;
                    hasEnd = true;

                    int firstIndex = s.indexOf('*'), lastIndex = s.lastIndexOf('*');
                    endValue = s.substring(0, firstIndex);
                    startValue = s.substring(lastIndex + 1);
                    if (lastIndex > firstIndex + 1) {
                        middleValue = s.substring(firstIndex + 1, lastIndex).replaceAll("\\*", "");
                        if (middleValue.length() > 0) {
                            hasMiddle = true;
                        }
                    }
                }

                if (hasMiddle) {
                    middle.append(middleValue.replaceAll("\\*", ""));
                }

                if (hasStart) {
                    String a, b;
                    if (startValue.length() > suffix.length()) {
                        a = startValue;
                        b = suffix;
                    } else {
                        a = suffix;
                        b = startValue;
                    }

                    if (a.endsWith(b)) {
                        suffix = a;
                    } else {
                        fail = true;
                        continue;
                    }
                }

                if (hasEnd) {
                    String a, b;
                    if (endValue.length() > prefix.length()) {
                        a = endValue;
                        b = prefix;
                    } else {
                        a = prefix;
                        b = endValue;
                    }

                    if (a.startsWith(b)) {
                        prefix = a;
                    } else {
                        fail = true;
                        continue;
                    }
                }

            }

            out.print("Case #" + testNumber + ": ");
            if (fail) {
                out.println('*');
            } else {
                out.println(prefix + middle.toString() + suffix);
            }
        }

    }

    static class FastScanner {
        private StringTokenizer st;
        private BufferedReader in;

        public FastScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String readToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(readToken());
        }

        public String next() {
            return readToken();
        }

    }

    static final class Utils {
        private Utils() {
        }

        public static String reverseString(String str) {
            return new StringBuilder(str).reverse().toString();
        }

    }
}

