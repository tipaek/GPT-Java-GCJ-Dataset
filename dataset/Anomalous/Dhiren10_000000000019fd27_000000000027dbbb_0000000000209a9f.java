import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            String input = reader.nextLine();
            int length = input.length();
            Stack<Character> stack = new Stack<>();
            
            char lastChar = input.charAt(length - 1);
            int lastDigit = Character.getNumericValue(lastChar);
            
            for (int i = 0; i < lastDigit; i++) {
                stack.push(')');
            }
            stack.push(lastChar);
            
            for (int i = length - 2; i >= 0; i--) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int nextDigit = Character.getNumericValue(input.charAt(i + 1));
                
                if (currentDigit < nextDigit) {
                    for (int j = 0; j < (nextDigit - currentDigit); j++) {
                        stack.push('(');
                    }
                } else {
                    for (int j = 0; j < (currentDigit - nextDigit); j++) {
                        stack.push(')');
                    }
                }
                stack.push(input.charAt(i));
            }
            
            int firstDigit = Character.getNumericValue(input.charAt(0));
            for (int i = 0; i < firstDigit; i++) {
                stack.push('(');
            }
            
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            
            System.out.println("Case #" + test + ": " + result.toString());
        }
    }
}

class FastReader {
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