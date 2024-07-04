import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberTests = Integer.parseInt(br.readLine());
            for (int i = 0; i < numberTests; i++) {
                processTestCase(i + 1, br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processTestCase(int testNumber, String input) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (char ch : input.toCharArray()) {
            int currentDigit = ch - '0';
            while (openParentheses < currentDigit) {
                result.append('(');
                openParentheses++;
            }
            while (openParentheses > currentDigit) {
                result.append(')');
                openParentheses--;
            }
            result.append(currentDigit);
        }

        while (openParentheses > 0) {
            result.append(')');
            openParentheses--;
        }

        System.out.println("Case #" + testNumber + ": " + result.toString());
    }
}