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
 * @author natsuf
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyReader in = new MyReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Expogo solver = new Expogo();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Expogo {
        public void solve(int testNumber, MyReader in, PrintWriter out) {
            long a = in.nextLong();
            long b = in.nextLong();
            boolean aflip = false, bflip = false;
            if (a < 0) {
                a *= -1;
                aflip = true;
            }
            if (b < 0) {
                b *= -1;
                bflip = true;
            }

            String as = Long.toBinaryString(a);
            String bs = Long.toBinaryString(b);

            int n = Math.max(as.length(), bs.length());
            int[] av = new int[n + 1];
            int[] bv = new int[n + 1];
            for (int i = 0; i < as.length(); i++) {
                if (as.charAt(as.length() - i - 1) == '1') av[i] = 1;
            }
            for (int i = 0; i < bs.length(); i++) {
                if (bs.charAt(bs.length() - i - 1) == '1') bv[i] = 1;
            }

            if ((av[0] == 0 && bv[0] == 0) || (av[0] == 1 && bv[0] == 1)) {
                out.println("Case #" + testNumber + ": " + "IMPOSSIBLE");
                return;
            }

            for (int i = 1; i < n; i++) {
                if (av[i] == 1 && bv[i] == 0) {
                    continue;
                }
                if (av[i] == 0 && bv[i] == 1) {
                    continue;
                }
                if (av[i] == 0 && bv[i] == 0) {
                    if (av[i - 1] == 1) {
                        av[i] = 1;
                        av[i - 1] = -1;
                    } else {
                        bv[i] = 1;
                        bv[i - 1] = -1;
                    }
                    continue;
                }
                if (av[i] == 1 && bv[i] == 1) {
                    if (av[i + 1] == 1 || bv[i + 1] == 1) {
                        out.println("Case #" + testNumber + ": " + "IMPOSSIBLE");
                        return;
                    }
                    if (av[i - 1] == 1) {
                        av[i + 1] = 1;
                        av[i] = 0;
                        av[i - 1] = -1;
                        continue;
                    }
                    if (bv[i - 1] == 1) {
                        bv[i + 1] = 1;
                        bv[i] = 0;
                        bv[i - 1] = -1;
                        continue;
                    }
                }
            }
            String ans = "";
            for (int i = 0; i < n + 1; i++) {
                int av1 = av[i];
                if (aflip) av1 *= -1;
                if (av1 != 0) {
                    if (av1 == 1) {
                        ans += "E";
                    } else {
                        ans += "W";
                    }
                }
                int bv1 = bv[i];
                if (bflip) bv1 *= -1;
                if (bv1 != 0) {
                    if (bv1 == 1) {
                        ans += "N";
                    } else {
                        ans += "S";
                    }
                }
            }


            out.println("Case #" + testNumber + ": " + ans);
        }

    }

    static class MyReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public MyReader(InputStream stream) {
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

