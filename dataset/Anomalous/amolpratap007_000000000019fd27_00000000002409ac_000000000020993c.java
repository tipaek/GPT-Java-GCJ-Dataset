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
            if (this.second != other.second) {
                return Integer.compare(other.second, this.second); // Descending order
            }
            return Integer.compare(this.first, other.first); // Ascending order by first if seconds are equal
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
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
        public int compareTo(Triplet other) {
            return Integer.compare(this.third, other.third); // Ascending order
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Triplet triplet = (Triplet) obj;
            return first == triplet.first && second == triplet.second && third == triplet.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }

    void merge(int[] arr, int left, int mid, int right) {
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

    void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Solution", 1L << 27).start();
    }

    @Override
    public void run() {
        try {
            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int t = in.nextInt();
            for (int q = 1; q <= t; q++) {
                out.print("Case #" + q + ": ");
                int n = in.nextInt();
                int[][] matrix = new int[n + 1][n + 1];
                int sum = 0;

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        matrix[i][j] = in.nextInt();
                        if (i == j) {
                            sum += matrix[i][j];
                        }
                    }
                }

                int rowDuplicates = 0, colDuplicates = 0;

                for (int i = 1; i <= n; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 1; j <= n; j++) {
                        rowSet.add(matrix[i][j]);
                    }
                    if (rowSet.size() != n) {
                        rowDuplicates++;
                    }
                }

                for (int j = 1; j <= n; j++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int i = 1; i <= n; i++) {
                        colSet.add(matrix[i][j]);
                    }
                    if (colSet.size() != n) {
                        colDuplicates++;
                    }
                }

                out.println(sum + " " + rowDuplicates + " " + colDuplicates);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}