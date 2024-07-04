import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void appendParentheses(StringBuilder s, int diff) {
        char c = diff < 0 ? ')' : '(';
        for (int i = 0; i < Math.abs(diff); i++) {
            s.append(c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = reader.readLine();
            StringBuilder output = new StringBuilder();
            int balance = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                int difference = digit - balance;
                appendParentheses(output, difference);
                output.append(input.charAt(i));
                balance = digit;
            }
            appendParentheses(output, -balance);

            System.out.println("Case #" + caseNum + ": " + output);
        }

        reader.close();
    }
}