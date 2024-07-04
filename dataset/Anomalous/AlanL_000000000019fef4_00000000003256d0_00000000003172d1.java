import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int tests = 1; tests <= t; tests++) {
            pr.print("Case #" + tests + ": ");
            int n = readInt(), d = readInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = readLong();
            processTest(n, d, arr);
        }
        pr.flush();
    }

    private static void processTest(int n, int d, long[] arr) {
        Arrays.sort(arr);
        if (d == 2) {
            handleD2(n, arr);
        } else if (d == 3) {
            handleD3(n, arr);
        }
    }

    private static void handleD2(int n, long[] arr) {
        if (n == 1) {
            pr.println(1);
        } else {
            boolean hasDuplicate = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    pr.println(0);
                    hasDuplicate = true;
                    break;
                }
            }
            if (!hasDuplicate) {
                pr.println(1);
            }
        }
    }

    private static void handleD3(int n, long[] arr) {
        if (n == 1) {
            pr.println(2);
        } else if (n == 2) {
            if (arr[1] % 2 == 0 && arr[1] / 2 == arr[0]) {
                pr.println(1);
            } else {
                pr.println(2);
            }
        } else if (n == 3) {
            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                pr.println(0);
            } else if (arr[0] == arr[1] || (arr[1] % 2 == 0 && arr[1] / 2 == arr[0]) ||
                    (arr[2] % 2 == 0 && (arr[2] / 2 == arr[0] || arr[2] / 2 == arr[1]))) {
                pr.println(1);
            } else {
                pr.println(2);
            }
        } else {
            int maxCount = findMaxCount(arr);
            if (maxCount >= 3) {
                pr.println(0);
            } else if (maxCount == 2) {
                pr.println(1);
            } else {
                pr.println(2);
            }
        }
    }

    private static int findMaxCount(long[] arr) {
        int maxCount = 1, currentCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 1;
            }
        }
        return Math.max(maxCount, currentCount);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return input.readLine().trim();
    }
}