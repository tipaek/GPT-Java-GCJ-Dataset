import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = bufferedReader.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            int openParentheses = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));
                if (digit > currentDepth) {
                    for (int j = 0; j < digit - currentDepth; j++) {
                        result.append("(");
                        openParentheses++;
                    }
                } else if (digit < currentDepth) {
                    for (int j = 0; j < currentDepth - digit; j++) {
                        result.append(")");
                        openParentheses--;
                    }
                }
                result.append(digit);
                currentDepth = digit;
            }

            for (int j = 0; j < openParentheses; j++) {
                result.append(")");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        bufferedReader.close();
    }
}