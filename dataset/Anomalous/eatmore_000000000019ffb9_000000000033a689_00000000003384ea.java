import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static void solve() throws Exception {
        long l = readLong(), r = readLong();
        long difference = Math.abs(l - r);
        long left = 0, right = 3000000000L;

        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (mid * (mid + 1) / 2 > difference) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        long n = left;
        if (l >= r) {
            l -= n * (n + 1) / 2;
        } else {
            r -= n * (n + 1) / 2;
        }

        left = n;
        right = 3000000000L;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            long mid1 = (mid - n) % 2 == 0 ? mid - 1 : mid;
            long mid2 = (mid - n) % 2 == 0 ? mid : mid - 1;
            long cost1 = (n + 1 + mid1) * ((mid1 - n - 1) / 2 + 1) / 2;
            long cost2 = (n + 2 + mid2) * ((mid2 - n - 2) / 2 + 1) / 2;
            if (l >= r ? l >= cost1 && r >= cost2 : r >= cost1 && l >= cost2) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        long nn = left;
        long mid1 = (nn - n) % 2 == 0 ? nn - 1 : nn;
        long mid2 = (nn - n) % 2 == 0 ? nn : nn - 1;
        long cost1 = (n + 1 + mid1) * ((mid1 - n - 1) / 2 + 1) / 2;
        long cost2 = (n + 2 + mid2) * ((mid2 - n - 2) / 2 + 1) / 2;

        if (l >= r) {
            l -= cost1;
            r -= cost2;
        } else {
            r -= cost1;
            l -= cost2;
        }

        printCase();
        out.println(nn + " " + l + " " + r);
    }

    static int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    static long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    static String readString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static void printCase() {
        out.print("Case #" + testCaseNumber + ": ");
    }

    static BufferedReader reader;
    static PrintWriter out;
    static StringTokenizer tokenizer;
    static int testCaseNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCases = readInt();
            for (testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
                solve();
            }
            reader.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}