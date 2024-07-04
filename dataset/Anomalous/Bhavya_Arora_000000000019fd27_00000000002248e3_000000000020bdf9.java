import java.io.*;
import java.util.*;

public class Solution {

    InputStream is;
    PrintWriter o;

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.end == other.end) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }
    }

    void solve() {
        int testCases = ni();
        for (int t = 1; t <= testCases; t++) {
            int n = ni();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(ni(), ni(), i);
            }
            Arrays.sort(activities);
            int cameronEnd = 0;
            int jamieEnd = 0;
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    result.append("C");
                    cameronEnd = activity.end;
                } else if (activity.start >= jamieEnd) {
                    result.append("J");
                    jamieEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                o.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                char[] answer = new char[n];
                for (int i = 0; i < n; i++) {
                    answer[activities[i].index] = result.charAt(i);
                }
                o.print("Case #" + t + ": ");
                for (char c : answer) {
                    o.print(c);
                }
                o.println();
            }
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }

    void run() {
        is = System.in;
        o = new PrintWriter(System.out);
        solve();
        o.flush();
    }

    byte[] inputBuffer = new byte[1024];
    int lenBuffer = 0, ptrBuffer = 0;

    int readByte() {
        if (ptrBuffer >= lenBuffer) {
            ptrBuffer = 0;
            try {
                lenBuffer = is.read(inputBuffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenBuffer <= 0) return -1;
        }
        return inputBuffer[ptrBuffer++];
    }

    boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    char nc() {
        return (char) skip();
    }

    String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    int ni() {
        int num = 0;
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

    long nl() {
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

    double nd() {
        return Double.parseDouble(ns());
    }

    float nf() {
        return Float.parseFloat(ns());
    }

    int[] nia(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = ni();
        }
        return array;
    }

    long[] nla(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nl();
        }
        return array;
    }

    int[][] nim(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ni();
            }
        }
        return matrix;
    }

    long[][] nlm(int n) {
        long[][] matrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nl();
            }
        }
        return matrix;
    }

    char[] ns(int n) {
        char[] chars = new char[n];
        int i, b = skip();
        for (i = 0; i < n; i++) {
            if (isSpaceChar(b)) break;
            chars[i] = (char) b;
            b = readByte();
        }
        return i == n ? chars : Arrays.copyOf(chars, i);
    }

    void printIntArray(int[] array) {
        for (int value : array) {
            o.print(value + " ");
        }
        o.println();
    }

    void printLongArray(long[] array) {
        for (long value : array) {
            o.print(value + " ");
        }
        o.println();
    }

    void printIntMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                o.print(value);
            }
            o.println();
        }
    }

    void printLongMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long value : row) {
                o.print(value);
            }
            o.println();
        }
    }
}