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

    static class Triplet implements Comparable<Triplet> {
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
            return Integer.compare(this.third, other.third);
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

    private void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, middle + 1, rightArray, 0, n2);

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

    private void sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private String toBinaryString(long x) {
        StringBuilder binaryString = new StringBuilder();
        while (x != 0) {
            binaryString.insert(0, x % 2);
            x /= 2;
        }
        return binaryString.toString();
    }

    private String twoComplement(String binary) {
        StringBuilder oneComplement = new StringBuilder();
        for (char bit : binary.toCharArray()) {
            oneComplement.append(bit == '0' ? '1' : '0');
        }

        StringBuilder twoComplement = new StringBuilder(oneComplement);
        for (int i = oneComplement.length() - 1; i >= 0; i--) {
            if (oneComplement.charAt(i) == '1') {
                twoComplement.setCharAt(i, '0');
            } else {
                twoComplement.setCharAt(i, '1');
                break;
            }
        }

        if (twoComplement.indexOf("1") == -1) {
            twoComplement.insert(0, '1');
        }

        return twoComplement.toString();
    }

    private String equalizeLength(String s, int maxLength) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < maxLength) {
            sb.append('0');
        }
        return sb.toString();
    }

    private String findPath(String s1, int k1, String s2, int k2) {
        int maxLength = Math.max(s1.length(), s2.length());
        s1 = equalizeLength(s1, maxLength);
        s2 = equalizeLength(s2, maxLength);

        StringBuilder path = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                return "";
            }
            if (s1.charAt(i) == '1') {
                path.append(k1 == -1 || i != k1 ? 'W' : 'E');
            }
            if (s2.charAt(i) == '1') {
                path.append(k2 == -1 || i != k2 ? 'S' : 'N');
            }
        }
        return path.toString();
    }

    @Override
    public void run() {
        try (InputReader in = new InputReader(System.in); PrintWriter out = new PrintWriter(System.out)) {
            int t = in.nextInt();
            for (int q = 1; q <= t; q++) {
                out.print("Case #" + q + ": ");
                long xx = in.nextLong();
                long yy = in.nextLong();
                long x = Math.abs(xx);
                long y = Math.abs(yy);

                String s11 = toBinaryString(x);
                String s21 = toBinaryString(y);
                String s12 = twoComplement(s11);
                String s22 = twoComplement(s21);

                s12 = "1" + s12;
                int k1 = s12.length() - 1;
                s22 = "1" + s22;
                int k2 = s22.length() - 1;

                s11 = new StringBuilder(s11).reverse().toString();
                s12 = new StringBuilder(s12).reverse().toString();
                s21 = new StringBuilder(s21).reverse().toString();
                s22 = new StringBuilder(s22).reverse().toString();

                String ans = "";
                String[] paths = {
                        findPath(s11, -1, s21, -1),
                        findPath(s11, -1, s22, k2),
                        findPath(s12, k1, s21, -1),
                        findPath(s12, k1, s22, k2)
                };

                for (String path : paths) {
                    if (!path.isEmpty() && (ans.isEmpty() || path.length() < ans.length())) {
                        ans = path;
                    }
                }

                if (ans.isEmpty()) {
                    out.println("IMPOSSIBLE");
                } else {
                    char[] result = ans.toCharArray();
                    if (xx < 0) {
                        for (int i = 0; i < result.length; i++) {
                            if (result[i] == 'E') result[i] = 'W';
                            else if (result[i] == 'W') result[i] = 'E';
                        }
                    }
                    if (yy < 0) {
                        for (int i = 0; i < result.length; i++) {
                            if (result[i] == 'N') result[i] = 'S';
                            else if (result[i] == 'S') result[i] = 'N';
                        }
                    }
                    out.println(new String(result));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Solution", 1 << 27).start();
    }

    static class InputReader implements Closeable {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int currentChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
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
                result = result * 10 + (c - '0');
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
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public String next() {
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

        @Override
        public void close() throws IOException {
            stream.close();
        }
    }
}