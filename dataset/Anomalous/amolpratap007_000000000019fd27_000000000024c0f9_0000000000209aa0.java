import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.second > other.second) {
                return -1;
            }
            if (this.second == other.second) {
                return Integer.compare(this.first, other.first);
            }
            return 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public class Triplet implements Comparable<Triplet> {
        int first;
        int second;
        int third;

        Triplet(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return first == triplet.first && second == triplet.second && third == triplet.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }

        @Override
        public int compareTo(Triplet other) {
            return Integer.compare(this.third, other.third);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    private void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private int[][] a, b;
    private int kk = 0;

    private void solve1(int n, int k, int i) {
        if (k < 0) return;
        if (i == n + 1) {
            if (k == 0) {
                solve2(n, 1, 1);
            }
            return;
        }
        for (int j = 1; j <= n; j++) {
            a[i][i] = j;
            solve1(n, k - j, i + 1);
            a[i][i] = 0;
        }
    }

    private void solve2(int n, int i, int j) {
        if (i == j) {
            if (i == n) {
                for (int ii = 1; ii <= n; ii++) {
                    System.arraycopy(a[ii], 1, b[ii], 1, n);
                }
                kk = 1;
                return;
            } else {
                solve2(n, i, j + 1);
                return;
            }
        }

        Set<Integer> hs = new HashSet<>();
        for (int ii = 1; ii <= n; ii++) hs.add(ii);
        for (int ii = 1; ii <= n; ii++) hs.remove(a[ii][j]);
        for (int jj = 1; jj <= n; jj++) hs.remove(a[i][jj]);

        for (int ii : hs) {
            a[i][j] = ii;
            int nexti = (j == n) ? i + 1 : i;
            int nextj = (j == n) ? 1 : j + 1;
            solve2(n, nexti, nextj);
            a[i][j] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Solution", 1 << 27).start();
    }

    @Override
    public void run() {
        try (InputReader in = new InputReader(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            int t = in.ni();
            for (int q = 1; q <= t; q++) {
                kk = 0;
                out.print("Case #" + q + ": ");
                int n = in.ni();
                int k = in.ni();
                a = new int[n + 1][n + 1];
                b = new int[n + 1][n + 1];
                solve1(n, k, 1);
                if (kk == 0) {
                    out.println("IMPOSSIBLE");
                } else {
                    out.println("POSSIBLE");
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n; j++) {
                            out.print(b[i][j] + " ");
                        }
                        out.println();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static class InputReader implements Closeable {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int currentChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        public int ni() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nl() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = ni();
            }
            return array;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        @Override
        public void close() throws IOException {
            stream.close();
        }
    }
}