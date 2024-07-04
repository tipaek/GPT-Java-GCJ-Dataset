import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();

        for (int i = 0; i < numberOfTest; i++) {
            // Input
            String line = sc.nextToken();

            String result = solve(line);
            System.out.println("Case #" + (i+1) + ": " + result);
        }
    }

    private static String solve(String line) {
        List<Character> result = new ArrayList<>();
        int opened = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '0') {
                if (opened == 0) {
                    result.add(c);
                } else {
                    addCloseParentheses(result, opened);
                    result.add(c);
                    opened = 0;
                }
                continue;
            }

            // Get the number
            int d = c - '0';

            if (d == opened) {
                // do nothing
            } else if (d > opened) {
                addOpenParentheses(result, d - opened);
                opened = d;
            } else {
                addCloseParentheses(result, opened - d);
                opened = d;
            }
            result.add(c);
        }

        addCloseParentheses(result, opened);

        return toStringResult(result);
    }

    private static void addCloseParentheses(List<Character> result, int number) {
        for (int i = 0; i < number; i++) {
            result.add(')');
        }
    }

    private static void addOpenParentheses(List<Character> result, int number) {
        for (int i = 0; i < number; i++) {
            result.add('(');
        }
    }

    private static String toStringResult(List<Character> result) {
        // create object of StringBuilder class 
        StringBuilder sb = new StringBuilder();

        // Appends characters one by one 
        for (Character ch : result) {
            sb.append(ch);
        }

        // convert in string 
        return sb.toString();
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
