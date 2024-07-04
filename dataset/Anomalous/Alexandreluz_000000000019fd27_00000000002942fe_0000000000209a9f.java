import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberTests = Integer.parseInt(br.readLine());
            for (int i = 0; i < numberTests; i++) {
                processTestCase(i + 1, br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processTestCase(int testNumber, String input) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (char ch : input.toCharArray()) {
            int currentDigit = ch - '0';

            while (openParentheses < currentDigit) {
                stack.push('(');
                result.append('(');
                openParentheses++;
            }

            while (openParentheses > currentDigit) {
                stack.pop();
                result.append(')');
                openParentheses--;
            }

            result.append(currentDigit);
        }

        while (!stack.isEmpty()) {
            result.append(')');
            stack.pop();
        }

        System.out.println(result.toString());
    }
}