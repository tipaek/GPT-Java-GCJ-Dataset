import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(in.nextInt(), in.nextInt());
            }
            pw.println("Case #" + t + ": " + solve(n, pairs));
        }

        pw.close();
    }

    static boolean isIntersection(Pair a, Pair b) {
        int maxStart = max(a.start, b.start);
        int minEnd = min(a.end, b.end);
        return maxStart < minEnd;
    }

    static String solve(int n, Pair[] pairs) {
        TwoSat twoSat = new TwoSat(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isIntersection(pairs[i], pairs[j])) {
                    twoSat.addNand(true, i, true, j);
                    twoSat.addNand(false, i, false, j);
                }
            }
        }
        if (!twoSat.solve()) return "IMPOSSIBLE";

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = twoSat.getVal(i) ? 'J' : 'C';
        }
        return new String(result);
    }

    static class TwoSat {
        int n;
        int[] stackArray;
        boolean[] mark;
        ArrayDeque<Integer>[] graph;
        Stack<Integer> stack;
        int stackPointer;

        TwoSat(int n) {
            this.n = n;
            stackArray = new int[2 * n];
            mark = new boolean[2 * n];
            stack = new Stack<>();
            graph = new ArrayDeque[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                graph[i] = new ArrayDeque<>();
            }
        }

        void addImpl(boolean xFlag, int x, boolean yFlag, int y) {
            int xIndex = x * 2 + (xFlag ? 1 : 0);
            int yIndex = y * 2 + (yFlag ? 1 : 0);
            addEdge(xIndex, yIndex);
            addEdge(yIndex ^ 1, xIndex ^ 1);
        }

        void addEdge(int from, int to) {
            graph[from].addLast(to);
            stack.add(from);
        }

        void removeLastImpl() {
            graph[stack.pop()].removeLast();
            graph[stack.pop()].removeLast();
        }

        void addNand(boolean aFlag, int a, boolean bFlag, int b) {
            addImpl(aFlag, a, !bFlag, b);
        }

        void addOr(boolean aFlag, int a, boolean bFlag, int b) {
            addImpl(!aFlag, a, bFlag, b);
        }

        void addXor(boolean aFlag, int a, boolean bFlag, int b) {
            addImpl(!aFlag, a, bFlag, b);
            addImpl(aFlag, a, !bFlag, b);
        }

        void addForce(int a, boolean aFlag) {
            addImpl(!aFlag, a, aFlag, a);
        }

        boolean getVal(int v) {
            return mark[v * 2];
        }

        boolean dfs(int u) {
            if (mark[u ^ 1]) return false;
            if (mark[u]) return true;
            mark[u] = true;
            stackArray[stackPointer++] = u;
            for (int i : graph[u]) {
                if (!dfs(i)) return false;
            }
            return true;
        }

        boolean solve() {
            Arrays.fill(mark, false);
            for (int i = 0; i < 2 * n; i += 2) {
                if (!mark[i] && !mark[i + 1]) {
                    stackPointer = 0;
                    if (!dfs(i)) {
                        while (stackPointer != 0) mark[stackArray[--stackPointer]] = false;
                        if (!dfs(i + 1)) return false;
                    }
                }
            }
            return true;
        }
    }

    static class Pair implements Comparable<Pair> {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start == other.start) return this.end - other.end;
            return this.start - other.start;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }

    static class FastReader {
        InputStream is;
        byte[] buffer = new byte[1024];
        int bufferLength = 0, bufferPointer = 0;

        FastReader(InputStream is) {
            this.is = is;
        }

        int readByte() {
            if (bufferLength == -1) throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                bufferPointer = 0;
                try {
                    bufferLength = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (bufferLength <= 0) return -1;
            }
            return buffer[bufferPointer++];
        }

        boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (c != '\n' && c != '\r' && c != -1) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !isSpaceChar(b)) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        char readChar() {
            return (char) skip();
        }
    }
}