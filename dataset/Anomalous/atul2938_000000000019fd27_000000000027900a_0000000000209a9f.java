import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter writer = new PrintWriter(System.out);
        
        int T = reader.nextInt();
        for (int t = 1; t <= T; t++) {
            String S = reader.next();
            S = expand(S);

            Stack<Character> stack = new Stack<>();
            stack.push(S.charAt(0));
            for (int i = 1; i < S.length(); i++) {
                if (stack.peek() == ')' && S.charAt(i) == '(') {
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            }

            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) {
                ans.append(stack.pop());
            }

            writer.printf("Case #%d: %s \n", t, ans.reverse().toString());
        }

        reader.close();
        writer.close();
    }

    static String expand(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            sb.append(surround(S.charAt(i)));
        }
        return sb.toString();
    }

    static String surround(char c) {
        String s = "" + c;
        for (int i = 0; i < c - '0'; i++) {
            s = "(" + s + ")";
        }
        return s;
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        Reader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StringTokenizer("");
        }

        String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        void close() throws IOException {
            reader.close();
        }
    }
}