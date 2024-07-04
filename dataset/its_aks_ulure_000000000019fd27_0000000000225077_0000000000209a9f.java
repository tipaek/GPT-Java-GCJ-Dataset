import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Vector;
import java.io.IOException;
import java.util.Stack;
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
        Task solver = new Task();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task {
        PrintWriter out;
        InputReader in;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            String s = n();
            int n = s.length();
            Stack<Character> st = new Stack<>();
            int i = 0;
            StringBuilder str = new StringBuilder();
            for (i = 0; i < n; i++) {
                if (st.size() > s.charAt(i) - '0') {
                    int diff = st.size() - (s.charAt(i) - '0');
                    while (diff-- > 0) {
                        str.append(')');
                        st.pop();
                    }
                } else if (st.size() < s.charAt(i) - '0') {
                    int diff = (s.charAt(i) - '0') - st.size();
                    while (diff-- > 0) {
                        str.append('(');
                        st.push('(');
                    }
                }
                str.append(s.charAt(i));
            }
            while (st.size() > 0) {
                str.append(')');
                st.pop();
            }
            pn("Case #" + testNumber + ": " + str);
        }

        String n() {
            return in.next();
        }

        void pn(String zx) {
            out.println(zx);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

