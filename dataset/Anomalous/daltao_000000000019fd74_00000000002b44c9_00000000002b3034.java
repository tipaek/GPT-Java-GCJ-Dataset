import java.io.*;
import java.util.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 27);
        thread.start();
        thread.join();
    }

    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            PatternMatching solver = new PatternMatching();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
            out.close();
        }
    }

    static class PatternMatching {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.printf("Case #%d: ", testNumber);
            int n = in.readInt();
            List<String> ps = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                ps.add(in.readString());
            }

            List<String> prefix = new ArrayList<>();
            List<String> suffix = new ArrayList<>();
            String fix = null;
            for (String s : ps) {
                int index = s.indexOf('*');
                int lastIndex = s.lastIndexOf('*');
                if (index == -1) {
                    fix = s;
                } else {
                    prefix.add(s.substring(0, index));
                    suffix.add(s.substring(lastIndex + 1));
                }
            }
            if (fix != null) {
                for (String s : ps) {
                    if (!match(fix, s)) {
                        out.println("*");
                        return;
                    }
                }
                out.println(fix);
                return;
            }

            prefix.sort(Comparator.comparingInt(String::length));
            suffix.sort(Comparator.comparingInt(String::length));
            for (int i = 1; i < prefix.size(); i++) {
                if (!prefix.get(i).startsWith(prefix.get(i - 1))) {
                    out.println("*");
                    return;
                }
            }
            for (int i = 1; i < suffix.size(); i++) {
                if (!suffix.get(i).endsWith(suffix.get(i - 1))) {
                    out.println("*");
                    return;
                }
            }

            StringBuilder ans = new StringBuilder();
            ans.append(prefix.get(prefix.size() - 1));
            for (String p : ps) {
                int index = p.indexOf('*');
                int lastIndex = p.lastIndexOf('*');
                for (int i = index; i <= lastIndex; i++) {
                    char c = p.charAt(i);
                    if (c != '*') {
                        ans.append(c);
                    }
                }
            }
            ans.append(suffix.get(suffix.size() - 1));
            out.println(ans);
        }

        public boolean match(String fix, String s) {
            int n = fix.length();
            int m = s.length();
            boolean[][] match = new boolean[n + 1][m + 1];
            match[0][0] = true;
            for (int i = 1; i <= m && s.charAt(i - 1) == '*'; i++) {
                match[0][i] = true;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(j - 1) == fix.charAt(i - 1) && match[i - 1][j - 1]) {
                        match[i][j] = true;
                    } else if (s.charAt(j - 1) == '*' && (match[i - 1][j] || match[i][j - 1])) {
                        match[i][j] = true;
                    }
                }
            }
            return match[n][m];
        }
    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        public FastOutput append(char c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(Object c) {
            cache.append(c);
            return this;
        }

        public FastOutput printf(String format, Object... args) {
            cache.append(String.format(format, args));
            return this;
        }

        public FastOutput println(String c) {
            return append(c).println();
        }

        public FastOutput println(Object c) {
            return append(c).println();
        }

        public FastOutput println() {
            cache.append(System.lineSeparator());
            return this;
        }

        public FastOutput flush() {
            try {
                os.append(cache);
                os.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }

        @Override
        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        @Override
        public String toString() {
            return cache.toString();
        }
    }

    static class FastInput {
        private final InputStream is;
        private StringBuilder defaultStringBuf = new StringBuilder(1 << 13);
        private byte[] buf = new byte[1 << 20];
        private int bufLen;
        private int bufOffset;
        private int next;

        public FastInput(InputStream is) {
            this.is = is;
        }

        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }

        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }

        public String next() {
            return readString();
        }

        public int readInt() {
            int sign = 1;

            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }

            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }

            return val;
        }

        public String readString(StringBuilder builder) {
            skipBlank();

            while (next > 32) {
                builder.append((char) next);
                next = read();
            }

            return builder.toString();
        }

        public String readString() {
            defaultStringBuf.setLength(0);
            return readString(defaultStringBuf);
        }
    }
}