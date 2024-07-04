import java.util.*;
import java.io.*;

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

public class Solution {
    private static String insertLeftParentheses(String str, int count, int pos) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < count; i++) {
            sb.insert(pos, '(');
        }
        return sb.toString();
    }

    private static String insertRightParentheses(String str, int count, int pos) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < count; i++) {
            sb.insert(pos, ')');
        }
        return sb.toString();
    }

    private static String appendRightParentheses(String str, int count) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < count; i++) {
            sb.append(')');
        }
        return sb.toString();
    }

    private static String solve(String str) {
        StringBuilder result = new StringBuilder(str);
        int balance = 0;
        int lastDigit = 0;

        for (int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            if (Character.isDigit(ch)) {
                int digit = Character.getNumericValue(ch);
                if (lastDigit < digit) {
                    int diff = digit - lastDigit;
                    result = new StringBuilder(insertLeftParentheses(result.toString(), diff, i));
                    i += diff;
                    if (digit > balance) {
                        balance += diff;
                    }
                } else if (lastDigit > digit) {
                    int diff = lastDigit - digit;
                    result = new StringBuilder(insertRightParentheses(result.toString(), diff, i));
                    i += diff;
                    balance -= diff;
                }
                lastDigit = digit;
            }
        }
        result = new StringBuilder(appendRightParentheses(result.toString(), balance));
        return result.toString();
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            String S = in.nextLine();
            String result = solve(S);
            System.out.printf("Case #%d: %s\n", i, result);
        }
    }
}