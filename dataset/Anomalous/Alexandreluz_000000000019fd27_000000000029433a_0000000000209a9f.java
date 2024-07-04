import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberTests = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < numberTests; i++) {
                processTestCase(i + 1, br.readLine().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processTestCase(int testNumber, String input) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (char digit : input.toCharArray()) {
            int currentNumber = Character.getNumericValue(digit);

            while (openParentheses < currentNumber) {
                stack.push('(');
                result.append('(');
                openParentheses++;
            }

            while (openParentheses > currentNumber) {
                stack.pop();
                result.append(')');
                openParentheses--;
            }

            result.append(digit);
        }

        while (openParentheses > 0) {
            stack.pop();
            result.append(')');
            openParentheses--;
        }

        System.out.println(result.toString());
    }
}