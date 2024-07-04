import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int u = in.nextInt();
            int n = 10000;
            long[] m = new long[n];
            String[] r = new String[n];
            for (int i = 0; i < n; i++) {
                m[i] = in.nextLong();
                r[i] = in.next();
            }

            if (u == 2) {
                pw.println("Case #" + t + ": " + solveTest1(m, r));
            } else {
                pw.println("Case #" + t + ": " + solveTest2And3(m, r));
            }
        }
        pw.close();
    }

    static String solveTest1(long[] m, String[] r) {
        int n = 10000;
        TreeSet<String>[] sets = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            sets[(int) m[i]].add(r[i]);
        }

        char[] map = new char[10];
        for (int i = 99; i >= 0; i--) {
            sets[i + 1].removeAll(sets[i]);
            if (sets[i + 1].isEmpty()) continue;
            String num = String.valueOf(i + 1);
            String dig = sets[i + 1].first();
            if (num.length() != dig.length()) continue;
            for (int j = 0; j < num.length(); j++) {
                map[num.charAt(j) - '0'] = dig.charAt(j);
            }
        }

        return new String(map);
    }

    static String solveTest2And3(long[] m, String[] r) {
        int n = 10000;
        HashSet<Character> set = new HashSet<>();
        int[] limits = new int[250];
        for (int i = 0; i < n; i++) {
            String dig = r[i];
            if (m[i] == -1) {
                for (char c : dig.toCharArray()) {
                    if (limits[c - 'A'] == 0) limits[c - 'A'] = 9;
                }
            } else {
                String num = String.valueOf(m[i]);
                if (num.length() > dig.length()) {
                    for (char c : dig.toCharArray()) {
                        if (limits[c - 'A'] == 0) limits[c - 'A'] = 9;
                    }
                } else {
                    int d = dig.charAt(0) - 'A', v = num.charAt(0) - '0';
                    if (limits[d] == 0) limits[d] = v;
                    else limits[d] = Math.min(limits[d], v);
                    boolean b = true;
                    for (int j = 1; j < dig.length(); j++) {
                        if (b) {
                            d = dig.charAt(j) - 'A';
                            v = num.charAt(j) - '0';
                            if (limits[d] == 0) limits[d] = v;
                            else limits[d] = Math.min(limits[d], v);
                            b = d == 0;
                        }
                    }
                }
            }
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < limits.length; i++) {
            if (limits[i] != 0) pairs.add(new Pair(limits[i], i));
        }

        Collections.sort(pairs);
        StringBuilder result = new StringBuilder();
        for (Pair p : pairs) {
            result.append((char) (p.s + 'A'));
            set.add((char) (p.s + 'A'));
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (!set.contains(c) && result.length() < 10) {
                set.add(c);
                result.append(c);
            }
        }

        return result.toString();
    }

    static class Pair implements Comparable<Pair> {
        int f, s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public int compareTo(Pair p) {
            if (f == p.f) return s - p.s;
            return f - p.f;
        }

        @Override
        public String toString() {
            return f + " " + s;
        }
    }

    static class FastReader {
        private final InputStream is;
        private final byte[] buffer = new byte[1024];
        private int bufferLen = 0, bufferPtr = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        private int readByte() {
            if (bufferLen == -1) throw new InputMismatchException();
            if (bufferPtr >= bufferLen) {
                bufferPtr = 0;
                try {
                    bufferLen = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (bufferLen <= 0) return -1;
            }
            return buffer[bufferPtr++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(c)) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !isSpaceChar(b)) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}