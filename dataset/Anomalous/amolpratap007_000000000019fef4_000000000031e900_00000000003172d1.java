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
                return other.second - this.second;
            } else {
                return this.first - other.first;
            }
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
        public int compareTo(Triplet other) {
            return Long.compare(this.third, other.third);
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
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
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

    public void run() {
        try {
            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int t = in.nextInt();

            for (int q = 1; q <= t; q++) {
                out.print("Case #" + q + ": ");
                int n = in.nextInt();
                int d = in.nextInt();
                TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
                int max = 0;

                for (int i = 1; i <= n; i++) {
                    int x = in.nextInt();
                    max = Math.max(max, x);
                    frequencyMap.put(x, frequencyMap.getOrDefault(x, 0) + 1);
                }

                if (d == 2) {
                    int ans = 1;
                    for (int count : frequencyMap.values()) {
                        if (count >= 2) {
                            ans = 0;
                            break;
                        }
                    }
                    out.println(ans);
                } else if (d == 3) {
                    int ans = 2;
                    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                        int value = entry.getKey();
                        int count = entry.getValue();
                        if (count >= 3) {
                            ans = 0;
                            break;
                        }
                        if (count == 2 && value < max) {
                            ans = 1;
                        }
                        if (count == 1 && frequencyMap.containsKey(2 * value)) {
                            ans = 1;
                        }
                    }
                    out.println(ans);
                }
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int currentChar, numberOfChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numberOfChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numberOfChars) {
                currentChar = 0;
                try {
                    numberOfChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numberOfChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
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

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
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