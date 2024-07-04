import java.io.*;
import java.util.*;

public class Solution {
    public static final long MOD = 1_000_000_007L;
    public static String[] s;
    public static char[][] str;

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t = in.readInt();
        StringBuilder sb = new StringBuilder();
        int cases = 1;

        while (t-- > 0) {
            int n = in.readInt();
            s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.readString();
            }

            Arrays.sort(s, new SortByLength());

            str = new char[n][101];
            for (int i = 0; i < n; i++) {
                Arrays.fill(str[i], '*');
            }

            for (int i = 0; i < s.length; i++) {
                int k = 100;
                for (int j = s[i].length() - 1; j >= 0; j--) {
                    str[i][k--] = s[i].charAt(j);
                }
            }

            boolean isPossible = true;
            for (int i = 100; i >= 1; i--) {
                char kth = str[0][i];
                int flag = 0;
                for (int j = 1; j < n; j++) {
                    if (str[j][i] != '*' && str[j][i] != kth) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                sb.append("Case #").append(cases).append(": *\n");
            } else {
                String st = s[0].substring(1);
                if (st.contains("*") || st.isEmpty()) {
                    sb.append("Case #").append(cases).append(": H\n");
                } else {
                    sb.append("Case #").append(cases).append(": ").append(st).append("\n");
                }
            }
            cases++;
        }

        out.printLine(sb);
        out.close();
    }

    static class SortByLength implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return Integer.compare(b.length(), a.length());
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
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

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void printLine(Object... objects) {
            for (Object obj : objects) {
                writer.print(obj);
            }
            writer.println();
        }

        public void close() {
            writer.close();
        }
    }
}