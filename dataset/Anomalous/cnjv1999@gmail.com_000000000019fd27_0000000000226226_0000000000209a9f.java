import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int testCaseCount = readInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String inputString = readLine();
            StringBuilder resultBuilder = new StringBuilder();
            int[] digits = new int[inputString.length() + 2];
            int index = 1;
            for (char character : inputString.toCharArray()) {
                digits[index++] = character - '0';
            }
            int balance = 0;
            for (index = 1; index < digits.length; index++) {
                int difference = digits[index] - digits[index - 1];
                balance += difference;
                if (difference > 0) {
                    while (difference-- > 0) {
                        resultBuilder.append("(");
                    }
                } else if (difference < 0) {
                    difference = -difference;
                    while (difference-- > 0) {
                        resultBuilder.append(")");
                    }
                }
                if (index != digits.length - 1) {
                    resultBuilder.append(digits[index]);
                }
            }
            while (balance-- > 0) {
                resultBuilder.append(")");
            }

            printf("Case #%d: %s\n", testCase, resultBuilder.toString());
        }
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static void print(Object obj) {
        System.out.print(obj);
    }

    static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    static void println(Object obj) {
        System.out.println(obj);
    }

    static BufferedReader bufferedReader;
    static StringTokenizer stringTokenizer;

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    static String nextToken() {
        while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringTokenizer.nextToken();
    }

    static int readInt() {
        return Integer.parseInt(nextToken());
    }

    static long readLong() {
        return Long.parseLong(nextToken());
    }

    static double readDouble() {
        return Double.parseDouble(nextToken());
    }

    static String readLine() {
        String line = "";
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}