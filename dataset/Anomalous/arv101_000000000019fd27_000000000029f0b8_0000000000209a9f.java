import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (int q = 1; q <= T; q++) {
            String line = in.readLine();
            int[] numbers = new int[line.length()];

            for (int s = 0; s < line.length(); s++) {
                numbers[s] = Character.getNumericValue(line.charAt(s));
            }

            StringBuilder answer = new StringBuilder();
            for (int num : numbers) {
                answer.append("(".repeat(num)).append(num).append(")".repeat(num));
            }

            String result = simplifyNestedParentheses(answer.toString());
            System.out.println("Case #" + q + ": " + result);
        }
    }

    private static String simplifyNestedParentheses(String str) {
        StringBuilder result = new StringBuilder(str);
        boolean changesMade;

        do {
            changesMade = false;
            for (int i = 0; i < result.length() - 1; i++) {
                if (result.charAt(i) == ')' && result.charAt(i + 1) == '(') {
                    result.delete(i, i + 2);
                    changesMade = true;
                    break;
                }
            }
        } while (changesMade);

        return result.toString();
    }
}