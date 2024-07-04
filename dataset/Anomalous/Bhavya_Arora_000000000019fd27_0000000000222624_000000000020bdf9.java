import java.io.*;
import java.util.*;

public class Solution {

    InputStream is;
    PrintWriter out;

    static class Activity implements Comparable<Activity> {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return this.end - other.end;
        }
    }

    void solve() {
        int t = nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = nextInt();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(nextInt(), nextInt());
            }
            Arrays.sort(activities);
            int cameronEnd = 0;
            int jamieEnd = 0;
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    result.append('C');
                    cameronEnd = activity.end;
                } else if (activity.start >= jamieEnd) {
                    result.append('J');
                    jamieEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            out.println("Case #" + testCase + ": " + result);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }

    void run() {
        is = System.in;
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    byte[] buffer = new byte[1024];
    int lenBuffer = 0, ptrBuffer = 0;

    int readByte() {
        if (ptrBuffer >= lenBuffer) {
            ptrBuffer = 0;
            try {
                lenBuffer = is.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenBuffer <= 0) return -1;
        }
        return buffer[ptrBuffer++];
    }

    boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    char nextChar() {
        return (char) skip();
    }

    String nextString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    String nextLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (b != '\n' && b != '\r' && b != -1) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    int nextInt() {
        int num = 0, b = readByte();
        boolean negative = false;
        while (b != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            b = readByte();
        }
        if (b == '-') {
            negative = true;
            b = readByte();
        }
        while (b >= '0' && b <= '9') {
            num = num * 10 + (b - '0');
            b = readByte();
        }
        return negative ? -num : num;
    }

    long nextLong() {
        long num = 0;
        int b = readByte();
        boolean negative = false;
        while (b != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            b = readByte();
        }
        if (b == '-') {
            negative = true;
            b = readByte();
        }
        while (b >= '0' && b <= '9') {
            num = num * 10 + (b - '0');
            b = readByte();
        }
        return negative ? -num : num;
    }

    double nextDouble() {
        return Double.parseDouble(nextString());
    }

    float nextFloat() {
        return Float.parseFloat(nextString());
    }

    int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    int[][] nextIntMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nextInt();
            }
        }
        return matrix;
    }

    long[][] nextLongMatrix(int n) {
        long[][] matrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nextLong();
            }
        }
        return matrix;
    }

    char[] nextCharArray(int n) {
        char[] array = new char[n];
        int b = skip();
        for (int i = 0; i < n; i++) {
            if (isSpaceChar(b)) break;
            array[i] = (char) b;
            b = readByte();
        }
        return array.length == n ? array : Arrays.copyOf(array, n);
    }

    void printIntArray(int[] array) {
        for (int value : array) {
            out.print(value + " ");
        }
        out.println();
    }

    void printLongArray(long[] array) {
        for (long value : array) {
            out.print(value + " ");
        }
        out.println();
    }

    void printIntMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                out.print(value + " ");
            }
            out.println();
        }
    }

    void printLongMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long value : row) {
                out.print(value + " ");
            }
            out.println();
        }
    }
}