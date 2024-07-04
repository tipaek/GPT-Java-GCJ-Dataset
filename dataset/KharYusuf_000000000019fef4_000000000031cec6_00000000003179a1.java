import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author KharYusuf
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Overrandomized solver = new Overrandomized();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Overrandomized {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int U = s.nextInt(), MX = (int) 1e4;
            char[] map = new char[10];
            TreeSet<Character> c = new TreeSet<>();
            ArrayList<char[]> a = new ArrayList<>();
            int[] m = new int[MX];
            for (int i = 0; i < MX; i++) {
                m[i] = s.nextInt();
                char[] cc = s.next().toCharArray();
                for (char b : cc) c.add(b);
                a.add(cc);
            }
            TreeSet<Character> tem = (TreeSet<Character>) c.clone();
            for (char[] cc : a) tem.remove(cc[0]);
            map[0] = tem.pollFirst();
            c.remove(map[0]);
            boolean[] used = new boolean['Z' + 1];
            used[map[0]] = true;
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < MX; j++)
                    if (a.get(j).length == 1 && m[j] == i && !used[a.get(j)[0]]) {
                        map[i] = a.get(j)[0];
                        used[map[i]] = true;
                        break;
                    }
            }
            w.print("Case #" + testNumber + ": ");
            w.println(map);
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {

            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {

                curChar = 0;

                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }

            return buf[curChar++];
        }

        public int nextInt() {

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
                if (c < '0' || c > '9')
                    throw new InputMismatchException();

                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public String next() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

            StringBuilder res = new StringBuilder();

            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {

            if (filter != null)
                return filter.isSpaceChar(c);

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

