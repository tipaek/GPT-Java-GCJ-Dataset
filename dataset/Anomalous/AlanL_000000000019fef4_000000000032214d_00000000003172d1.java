import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int tests = 1; tests <= t; tests++) {
            System.out.print("Case #" + tests + ": ");
            int n = readInt(), d = readInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = readLong();

            if (d == 2) {
                handleD2(n, arr);
            } else if (d == 3) {
                handleD3(n, arr);
            }
        }
    }

    private static void handleD2(int n, long[] arr) {
        if (n == 1) {
            System.out.println(1);
        } else if (n >= 2) {
            Arrays.sort(arr);
            boolean duplicateFound = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    System.out.println(0);
                    duplicateFound = true;
                    break;
                }
            }
            if (!duplicateFound) System.out.println(1);
        }
    }

    private static void handleD3(int n, long[] arr) {
        Arrays.sort(arr);
        if (n == 1) {
            System.out.println(2);
        } else if (n == 2) {
            if (arr[1] % 2 == 0 && arr[1] / 2 == arr[0]) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        } else if (n == 3) {
            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println(0);
            } else if (arr[0] == arr[1] || arr[1] == arr[2]) {
                System.out.println(1);
            } else if (arr[1] % 2 == 0 && arr[1] / 2 == arr[0]) {
                System.out.println(1);
            } else if (arr[2] % 2 == 0 && (arr[2] / 2 == arr[0] || arr[2] / 2 == arr[1])) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        } else {
            int maxCount = getMaxCount(arr);
            if (maxCount == 3) {
                System.out.println(0);
            } else if (maxCount == 2) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }

    private static int getMaxCount(long[] arr) {
        int counter = 1, max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                counter++;
            } else {
                max = Math.max(max, counter);
                counter = 1;
            }
        }
        return Math.max(max, counter);
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