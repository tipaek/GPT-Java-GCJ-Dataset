import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }
                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }
                result.append(ch);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.printf("Case #%d: %s\n", caseNum, result.toString());
        }

        reader.close();
    }
}