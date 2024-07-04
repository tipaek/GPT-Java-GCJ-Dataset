import java.io.*;
import java.util.*;

class Solution {
    
    public static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private final BufferedReader br;

        public InputReader(InputStream stream) {
            this.stream = stream;
            this.br = new BufferedReader(new InputStreamReader(stream));
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

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
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
                res = res * 10 + c - '0';
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
                res = res * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
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

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }

    public static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[col]));
    }

    public static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return (first == null ? 0 : first.hashCode() * 31) + (second == null ? 0 : second.hashCode());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int compareTo(Pair<U, V> b) {
            int cmpU = first.compareTo(b.first);
            return cmpU != 0 ? cmpU : second.compareTo(b.second);
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", first, second);
        }
    }

    static LinkedList<Integer>[] li = new LinkedList[100001];
    static int ans1 = 0, ans2 = 0, max1 = -1;
    static int[] dist = new int[100001];
    static int[] visited = new int[100001];
    static ArrayList<Integer>[] adj = new ArrayList[100001];

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            Pair<Integer, Integer>[] a = new Pair[n];
            int[][] arr = new int[n][2];
            int[][] mat = new int[n][4];

            for (int j = 0; j < n; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
                a[j] = new Pair<>(arr[j][0], arr[j][1]);
            }
            Arrays.sort(a);

            int jo = -1, jc = -1, co = -1, cc = -1;
            mat[0][2] = 1;
            for (int j = 0; j < n; j++) {
                mat[j][0] = a[j].first;
                mat[j][1] = a[j].second;
            }
            jo = mat[0][0];
            jc = mat[0][1];
            int j = 1;
            int y = 0;
            while (co == -1 && j < n) {
                if (jc <= mat[j][0]) {
                    jc = mat[j][1];
                    jo = mat[j][0];
                    mat[j][2] = 1;
                } else {
                    co = mat[j][0];
                    cc = mat[j][1];
                    mat[j][2] = 2;
                }
                j++;
                y = j;
            }
            int flag = 0;
            for (j = y; j < n; j++) {
                if (jc <= mat[j][0]) {
                    jc = mat[j][1];
                    jo = mat[j][0];
                    mat[j][2] = 1;
                } else if (cc <= mat[j][0]) {
                    co = mat[j][0];
                    cc = mat[j][1];
                    mat[j][2] = 2;
                } else {
                    flag = -1;
                }
            }
            StringBuilder s1 = new StringBuilder();
            if (flag == -1) {
                s1.append("IMPOSSIBLE");
            } else {
                for (j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (arr[j][0] == mat[k][0] && arr[j][1] == mat[k][1] && mat[k][3] == 0) {
                            if (mat[k][2] == 1) {
                                s1.append('C');
                            } else {
                                s1.append('J');
                            }
                            mat[k][3] = 1;
                            break;
                        }
                    }
                }
            }

            w.println("Case #" + (i + 1) + ": " + s1);
        }
        w.close();
    }
}