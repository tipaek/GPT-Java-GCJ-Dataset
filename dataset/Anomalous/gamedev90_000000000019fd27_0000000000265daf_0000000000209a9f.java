import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            String input = reader.readLine();
            String result = processBinaryString(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processBinaryString(String input) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentSequence = new StringBuilder();
        boolean insideParentheses = false;

        for (char ch : input.toCharArray()) {
            if (ch == '1') {
                if (!insideParentheses) {
                    currentSequence.append('(');
                    insideParentheses = true;
                }
                currentSequence.append('1');
            } else {
                if (insideParentheses) {
                    currentSequence.append(')');
                    insideParentheses = false;
                }
                currentSequence.append('0');
            }
        }

        if (insideParentheses) {
            currentSequence.append(')');
        }

        result.append(currentSequence);
        return result.toString();
    }
}