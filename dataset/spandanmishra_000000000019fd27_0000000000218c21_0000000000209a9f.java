import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Spandan Mishra
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        solver.solve(1, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.readInt();
            testNumber = 1;
            StringBuilder sb = new StringBuilder();
            while (T-- > 0) {
                String s = in.readString();
                StringBuilder res = new StringBuilder();
                Stack<Integer> st = new Stack<>();
                st.push(s.charAt(0) - '0');
//            System.out.println("stack-->" + st.peek());
                for (int i = 0; i < st.peek(); i++)
                    res.append("(");
                res.append(st.peek());
                int n = s.length();
                int ch;
                for (int i = 1; i < n; i++) {
                    ch = s.charAt(i) - '0';
                    if (ch == st.peek()) {
                        res.append(ch);
                    } else if (ch < st.peek()) {
                        for (int j = 0; j < st.peek() - ch; j++)
                            //append }
                            res.append(")");
                        res.append(ch);
                        st.pop();
                        st.push(ch);
                    } else {
                        for (int j = 0; j < ch - st.peek(); j++) {
                            res.append("(");
                        }
                        res.append(ch);
                        st.push(st.peek() + ch - st.pop());
                    }
                }
                int var = st.peek();
                for (int i = 0; i < var; i++)
                    res.append(")");

                sb.append("Case #" + testNumber++ + ": " + res + "\n");
            }
            System.out.println(sb);
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
                throw new RuntimeException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String readString() {
            final StringBuilder stringBuilder = new StringBuilder();
            int c = read();
            while (isSpaceChar(c))
                c = read();
            do {
                stringBuilder.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return stringBuilder.toString();
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

