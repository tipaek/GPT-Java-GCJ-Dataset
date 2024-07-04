import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;
import java.math.BigInteger;

public class Solution {
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static FastReader s = new FastReader();

    public static void main(String[] args) {
        int t = s.nextInt();
        int caseNumber = 1;
        while (t-- > 0) {
            String str = s.next();
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int n = str.length();
            int prev = 0;

            for (int i = 0; i < n; i++) {
                int currentDigit = str.charAt(i) - '0';
                int diff = currentDigit - prev;

                while (diff > 0) {
                    sb.append('(');
                    stack.push('(');
                    diff--;
                }

                while (diff < 0) {
                    sb.append(')');
                    stack.pop();
                    diff++;
                }

                sb.append(currentDigit);
                prev = currentDigit;

                if (i == n - 1) {
                    while (!stack.isEmpty()) {
                        sb.append(')');
                        stack.pop();
                    }
                }
            }
            System.out.println("Case #" + caseNumber + ": " + sb.toString());
            caseNumber++;
        }
    }

    public static String factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact.toString();
    }

    public static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}