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
                return Integer.compare(other.second, this.second);
            }
            return Integer.compare(this.first, other.first);
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
        long third;

        Triplet(int first, int second, long third) {
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
            return Long.compare(this.third, other.third);
        }
    }

    void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        while (j < n2) {
            arr[k++] = rightArray[j++];
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
        new Thread(null, new Solution(), "Solution", 1 << 27).start();
    }

    @Override
    public void run() {
        try {
            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int testCases = in.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                out.print("Case #" + caseNum + ": ");
                int n = in.nextInt();
                int d = in.nextInt();
                Map<Long, Integer> occurrences = new HashMap<>();
                long max = 0;
                for (int i = 0; i < n; i++) {
                    long x = in.nextLong();
                    max = Math.max(max, x);
                    occurrences.put(x, occurrences.getOrDefault(x, 0) + 1);
                }

                if (occurrences.values().stream().anyMatch(count -> count >= d)) {
                    out.println("0");
                } else if (d == 2) {
                    out.println("1");
                } else {
                    boolean found = false;
                    for (Map.Entry<Long, Integer> entry : occurrences.entrySet()) {
                        long key = entry.getKey();
                        int value = entry.getValue();
                        if (value == 2 && key < max || occurrences.containsKey(2 * key)) {
                            found = true;
                            break;
                        }
                    }
                    out.println(found ? "1" : "2");
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int curChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
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
            while (isSpaceChar(c)) c = read();
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

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}