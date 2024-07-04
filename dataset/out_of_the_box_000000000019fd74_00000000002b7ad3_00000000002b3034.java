import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.io.Writer;
import java.util.Optional;
import java.io.OutputStreamWriter;
import java.util.Comparator;
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
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PatternMatching {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            List<String> p = new ArrayList<>();
//        int completedIndex = -1;
            for (int i = 0; i < n; i++) {
                String s = in.nextString();
//            if (isComplete(s)) {
//                completedIndex = i;
//            }
                p.add(s);
            }
            String ans = p.stream().map(this::rem).collect(Collectors.joining(""));
            List<String> starters = p.stream().filter(this::start).collect(Collectors.toList());
            int sLen = starters.size();
            List<String> enders = p.stream().filter(this::end).collect(Collectors.toList());
            int eLen = enders.size();
            //.out.println("eLen = " + eLen);
            //.out.println("sLen = " + sLen);
            Optional<String> pre = getStart(starters);
            if (pre.isEmpty()) {
                //.out.println("Pre is empty");
            }
            Optional<String> post = getEnd(enders);
            if (post.isEmpty()) {
                //.out.println("Post is empty");
            }
            if (pre.isEmpty() || post.isEmpty()) {
                out.println(String.format("Case #%d: *", testNumber));
            } else {
                String rans = pre.get() + ans + post.get();
                out.println(String.format("Case #%d: %s", testNumber, rans));
            }
        }

        private Optional<String> getStart(List<String> starters) {
            List<String> starts = starters.stream().map(this::getPre).collect(Collectors.toList());
            int ns = starts.size();
            for (int i = 0; i < ns; i++) {
                //.out.println("starts.get(i) = " + starts.get(i));
            }
            Comparator<Pair<String, Integer>> comp = Comparator.comparing(Pair::getRight);
            Optional<String> maxString = starts.stream().map(s -> Pair.of(s, s.length())).max(comp).map(Pair::getLeft);
            if (!maxString.isPresent()) {
                return Optional.of("");
            } else {
                String maxStr = maxString.get();
                //.out.println("maxStr = " + maxStr);
                int n = starts.size();
                for (int i = 0; i < n; i++) {
                    String thisStr = starts.get(i);
                    //.out.println("thisStr = " + thisStr);
                    int tlen = thisStr.length();
                    //.out.println("tlen = " + tlen);
                    if (!thisStr.equals(maxStr.substring(0, tlen))) {
                        return Optional.empty();
                    }
                }
                return Optional.ofNullable(maxStr);
            }
        }

        private Optional<String> getEnd(List<String> enders) {
            List<String> ends = enders.stream().map(this::getPost).collect(Collectors.toList());
            Comparator<Pair<String, Integer>> comp = Comparator.comparing(Pair::getRight);
            Optional<String> maxString = ends.stream().map(s -> Pair.of(s, s.length())).max(comp).map(Pair::getLeft);
            if (!maxString.isPresent()) {
                return Optional.of("");
            } else {
                String maxStr = maxString.get();
                //.out.println("maxStr = " + maxStr);
                int maxN = maxStr.length();
                //.out.println("maxN = " + maxN);
                int n = ends.size();
                for (int i = 0; i < n; i++) {
                    String thisStr = ends.get(i);
                    //.out.println("thisStr = " + thisStr);
                    int tlen = thisStr.length();
                    //.out.println("tlen = " + tlen);
                    if (!thisStr.equals(maxStr.substring(maxN - tlen, maxN))) {
                        return Optional.empty();
                    }
                }
                return Optional.ofNullable(maxStr);
            }
        }

        private String getPost(String s) {
            StringBuilder builder = new StringBuilder();
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '*') {
                    return builder.reverse().toString();
                } else {
                    builder.append(c);
                }
            }
            return builder.reverse().toString();
        }

        private String getPre(String s) {
            StringBuilder builder = new StringBuilder();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '*') {
                    return builder.toString();
                } else {
                    builder.append(c);
                }
            }
            return builder.toString();
        }

        private boolean start(String s) {
            return s.charAt(0) != '*';
        }

        private boolean end(String s) {
            int len = s.length();
            return s.charAt(len - 1) != '*';
        }

        private String rem(String str) {
            StringBuilder build = new StringBuilder();
            int n = str.length();
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) != '*') {
                    build.append(str.charAt(i));
                }
            }
            return build.toString();
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

