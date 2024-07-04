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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            loop:
            for (int test = 1; test <= T; test++) {
                int xF = 0;
                int yF = 0;
                xyLoop:
                for (int x = -1_000_000_000; x <= 1_000_000_000; x += 500_000_000) {
                    for (int y = -1_000_000_000; y <= 1_000_000_000; y += 500_000_000) {
                        out.println(x + " " + y);
                        out.flush();
                        String res = in.next();
                        if (res.equals("CENTER")) {
                            continue loop;
                        } else if (res.equals("HIT")) {
                            xF = x;
                            yF = y;
                            break xyLoop;
                        }
                    }
                }
                int UP_CLEAR = 1_000_000_001;
                int UP_TARGET = yF;
                while (UP_CLEAR - UP_TARGET > 1) {
                    int m = (UP_CLEAR + UP_TARGET) / 2;
                    out.println(xF + " " + m);
                    out.flush();
                    String res = in.next();
                    if (res.equals("CENTER")) {
                        continue loop;
                    } else if (res.equals("HIT")) {
                        UP_TARGET = m;
                    } else {
                        UP_CLEAR = m;
                    }
                }
                int DOWN_CLEAR = -1_000_000_001;
                int DOWN_TARGET = yF;
                while (DOWN_TARGET - DOWN_CLEAR > 1) {
                    int m = (DOWN_TARGET + DOWN_CLEAR) / 2;
                    out.println(xF + " " + m);
                    out.flush();
                    String res = in.next();
                    if (res.equals("CENTER")) {
                        continue loop;
                    } else if (res.equals("HIT")) {
                        DOWN_TARGET = m;
                    } else {
                        DOWN_CLEAR = m;
                    }
                }
                int LEFT_CLEAR = -1_000_000_001;
                int LEFT_TARGET = xF;
                while (LEFT_TARGET - LEFT_CLEAR > 1) {
                    int m = (LEFT_TARGET + LEFT_CLEAR) / 2;
                    out.println(m + " " + yF);
                    out.flush();
                    String res = in.next();
                    if (res.equals("CENTER")) {
                        continue loop;
                    } else if (res.equals("HIT")) {
                        LEFT_TARGET = m;
                    } else {
                        LEFT_CLEAR = m;
                    }
                }
                int RIGHT_CLEAR = 1_000_000_001;
                int RIGHT_TARGET = xF;
                while (RIGHT_CLEAR - RIGHT_TARGET > 1) {
                    int m = (RIGHT_CLEAR + RIGHT_TARGET) / 2;
                    out.println(m + " " + yF);
                    out.flush();
                    String res = in.next();
                    if (res.equals("CENTER")) {
                        continue loop;
                    } else if (res.equals("HIT")) {
                        RIGHT_TARGET = m;
                    } else {
                        RIGHT_CLEAR = m;
                    }
                }
                out.println(((LEFT_TARGET + RIGHT_TARGET) / 2) + " " + ((UP_TARGET + DOWN_TARGET) / 2));
                out.flush();
                String res = in.next();
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

