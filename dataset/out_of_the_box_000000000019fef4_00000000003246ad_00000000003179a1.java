import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Map;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;
import java.util.stream.Stream;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.Writer;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author out_of_the_box
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Overrandomized solver = new Overrandomized();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Overrandomized {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
//        System.out.println("testNumber = " + testNumber);
            int u = in.nextInt();
//        System.out.println("u = " + u);
            int N = 10000;
            List<Pair<Long, String>> input = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                long q = in.nextLong();
                String r = in.nextString();
                input.add(Pair.of(q, r));
            }

            String ans;
            if (u == 2) {
                //TODO
                ans = solve(input, N, u);
            } else if (u == 16) {
                ans = solve(input, N, u);
            } else {
                throw new RuntimeException("Unexpected input");
            }
            out.println(String.format("Case #%d: %s", testNumber, ans));
        }

        private String solve(List<Pair<Long, String>> input, int N, int u) {

            TreeMap<Character, Integer> mp = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                Pair<Long, String> pr = input.get(i);
//            char firstChar = pr.getRight().charAt(0);
//            int val = mp.getOrDefault(firstChar, 0);
//            mp.put(firstChar, val+1);
                String str = pr.getRight();
                int strLen = str.length();
                if (strLen == u) {
                    char firstChar = str.charAt(0);
                    int val = mp.getOrDefault(firstChar, 0);
                    mp.put(firstChar, val + 1);
                    for (int j = 0; j < strLen; j++) {
                        char c = str.charAt(j);
                        int vall = mp.getOrDefault(c, 0);
                        mp.put(c, vall);
                    }
                }
            }
            List<Pair<Character, Integer>> mpList = mp.entrySet().stream()
                    .map(en -> Pair.of(en.getKey(), en.getValue())).collect(Collectors.toList());
            Comparator<Pair<Character, Integer>> comparator = Comparator.comparing(Pair::getRight);
            mpList.sort(comparator);
//        System.out.println("mp = " + mp);
            List<Character> charList = mpList.stream().map(Pair::getLeft).collect(Collectors.toList());
            Collections.reverse(charList);
//        System.out.println("charList = " + charList);
            if (charList.size() < 10) {
                //TODO: Add case for additional missing letters
                throw new RuntimeException("Missing letters");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(charList.get(9));
            for (int i = 0; i < 9; i++) {
                stringBuilder.append(charList.get(i));
            }
            return stringBuilder.toString();
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class Pair<L, R> {
        private L left;
        private R right;

        private Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() {
            return left;
        }

        public R getRight() {
            return right;
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<>(a, b);
        }

        public String toString() {
            return "Pair{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(left, pair.left) &&
                    Objects.equals(right, pair.right);
        }

        public int hashCode() {
            return Objects.hash(left, right);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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

        public int nextInt() {
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

