import java.io.*;
import java.util.*;

public class Solution {
    public static InputReader in = new InputReader(System.in);
    public static OutputWriter out = new OutputWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = in.nextInt();
        int B = in.nextInt();

        for (int cs = 1; cs <= T; cs++) {
            int[] A = new int[B];

            if (B == 10) {
                for (int i = 1; i <= B; i++) {
                    out.println(i);
                    out.flush();
                    A[i - 1] = in.nextInt();
                }
                for (int i = 0; i < B; i++) {
                    out.print(A[i]);
                }
                out.println();
                out.flush();
                if (in.next().equals("N")) {
                    return;
                }
                continue;
            }

            List<Group> groups = new ArrayList<>();
            for (int i = 0; i < B / 10; i++) {
                Group group = new Group();
                for (int j = i * 5 + 1; j <= (i + 1) * 5; j++) {
                    out.println(j);
                    out.flush();
                    int d1 = in.nextInt();

                    out.println(B - j + 1);
                    out.flush();
                    int d2 = in.nextInt();

                    if (d1 == d2) {
                        if (d1 == 0) group.s0.add(j);
                        else group.s1.add(j);
                    } else {
                        if (d1 == 0) group.d0.add(j);
                        else group.d1.add(j);
                    }
                }
                groups.add(group);
            }

            Group consolidatedGroup = new Group();
            int queryCount = 0;

            for (Group group : groups) {
                if (!group.s0.isEmpty()) {
                    queryCount++;
                    out.println(group.s0.get(0));
                    out.flush();
                    int d1 = in.nextInt();
                    if (d1 == 0) {
                        consolidatedGroup.s0.addAll(group.s0);
                        consolidatedGroup.s1.addAll(group.s1);
                    } else {
                        consolidatedGroup.s0.addAll(group.s1);
                        consolidatedGroup.s1.addAll(group.s0);
                    }
                } else if (!group.s1.isEmpty()) {
                    queryCount++;
                    out.println(group.s1.get(0));
                    out.flush();
                    int d1 = in.nextInt();
                    if (d1 == 0) {
                        consolidatedGroup.s0.addAll(group.s1);
                        consolidatedGroup.s1.addAll(group.s0);
                    } else {
                        consolidatedGroup.s0.addAll(group.s0);
                        consolidatedGroup.s1.addAll(group.s1);
                    }
                }
            }

            while (queryCount < 10) {
                queryCount++;
                out.println(1);
                out.flush();
                in.nextInt();
            }

            queryCount = 0;
            for (Group group : groups) {
                if (!group.d0.isEmpty()) {
                    queryCount++;
                    out.println(group.d0.get(0));
                    out.flush();
                    int d1 = in.nextInt();
                    if (d1 == 0) {
                        consolidatedGroup.d0.addAll(group.d0);
                        consolidatedGroup.d1.addAll(group.d1);
                    } else {
                        consolidatedGroup.d0.addAll(group.d1);
                        consolidatedGroup.d1.addAll(group.d0);
                    }
                } else if (!group.d1.isEmpty()) {
                    queryCount++;
                    out.println(group.d1.get(0));
                    out.flush();
                    int d1 = in.nextInt();
                    if (d1 == 0) {
                        consolidatedGroup.d0.addAll(group.d1);
                        consolidatedGroup.d1.addAll(group.d0);
                    } else {
                        consolidatedGroup.d0.addAll(group.d0);
                        consolidatedGroup.d1.addAll(group.d1);
                    }
                }
            }

            while (queryCount < 10) {
                queryCount++;
                out.println(1);
                out.flush();
                in.nextInt();
            }

            int s = 0, d = 0;
            if (!consolidatedGroup.s0.isEmpty()) {
                out.println(consolidatedGroup.s0.get(0));
                out.flush();
                s = in.nextInt();
            } else if (!consolidatedGroup.s1.isEmpty()) {
                out.println(consolidatedGroup.s1.get(0));
                out.flush();
                s = 1 - in.nextInt();
            }
            if (!consolidatedGroup.d0.isEmpty()) {
                out.println(consolidatedGroup.d0.get(0));
                out.flush();
                d = in.nextInt();
            } else if (!consolidatedGroup.d1.isEmpty()) {
                out.println(consolidatedGroup.d1.get(0));
                out.flush();
                d = 1 - in.nextInt();
            }

            for (int id : consolidatedGroup.s0) {
                A[id - 1] = s;
                A[B - id] = s;
            }
            for (int id : consolidatedGroup.s1) {
                A[id - 1] = 1 - s;
                A[B - id] = 1 - s;
            }
            for (int id : consolidatedGroup.d0) {
                A[id - 1] = d;
                A[B - id] = 1 - d;
            }
            for (int id : consolidatedGroup.d1) {
                A[id - 1] = 1 - d;
                A[B - id] = d;
            }

            for (int i = 0; i < B; i++) {
                out.print(A[i]);
            }
            out.println();
            out.flush();

            if (in.next().equals("N")) {
                return;
            }
        }
        out.close();
    }

    static class Group {
        List<Integer> s0 = new ArrayList<>();
        List<Integer> s1 = new ArrayList<>();
        List<Integer> d0 = new ArrayList<>();
        List<Integer> d1 = new ArrayList<>();
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void flush() {
            writer.flush();
        }

        public void close() {
            writer.close();
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

        public int read() throws IOException {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() throws IOException {
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
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() throws IOException {
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
}