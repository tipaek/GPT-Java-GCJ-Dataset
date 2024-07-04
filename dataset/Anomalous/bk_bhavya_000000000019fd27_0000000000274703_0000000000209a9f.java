import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int caseNumber = t;

        while (t-- > 0) {
            String s = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            Deque<Character> output = new LinkedList<>();
            int index = 0;
            int openCount = 0;
            int lastDigit = -1;

            while (index < s.length()) {
                char currentChar = s.charAt(index);
                int currentDigit = Character.getNumericValue(currentChar);

                if (stack.isEmpty()) {
                    stack.push(currentChar);
                } else {
                    char topChar = stack.peek();
                    int topDigit = Character.getNumericValue(topChar);

                    if (currentChar == topChar) {
                        stack.push(currentChar);
                    } else {
                        if (currentDigit < topDigit) {
                            addParentheses(output, openCount, topDigit - currentDigit);
                            openCount -= topDigit - currentDigit;
                        } else {
                            addParentheses(output, openCount, currentDigit - topDigit);
                            openCount += currentDigit - topDigit;
                        }

                        while (!stack.isEmpty()) {
                            output.add(stack.pop());
                        }

                        stack.push(currentChar);
                    }
                }
                index++;
            }

            while (!stack.isEmpty()) {
                output.add(stack.pop());
            }

            addParentheses(output, openCount, -openCount);

            StringBuilder result = new StringBuilder();
            while (!output.isEmpty()) {
                result.append(output.removeFirst());
            }

            System.out.println("Case #" + (caseNumber - t) + ": " + result.toString());
        }
    }

    private static void addParentheses(Deque<Character> output, int openCount, int difference) {
        if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                output.add('(');
            }
        } else {
            for (int i = 0; i < -difference; i++) {
                output.add(')');
            }
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