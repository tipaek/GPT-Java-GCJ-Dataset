import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int n = s.length();
            int currentLevel = 0;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int digit = s.charAt(j) - '0';

                if (digit == currentLevel) {
                    result.append(s.charAt(j));
                } else if (digit > currentLevel) {
                    int diff = digit - currentLevel;
                    result.append(generateParentheses(diff, '(')).append(s.charAt(j));
                    currentLevel = digit;
                } else {
                    int diff = currentLevel - digit;
                    result.append(generateParentheses(diff, ')')).append(s.charAt(j));
                    currentLevel = digit;
                }
            }

            if (currentLevel > 0) {
                result.append(generateParentheses(currentLevel, ')'));
            }

            System.out.println(result.toString());
        }
    }

    private static String generateParentheses(int count, char parenthesis) {
        return String.join("", Collections.nCopies(count, String.valueOf(parenthesis)));
    }
}