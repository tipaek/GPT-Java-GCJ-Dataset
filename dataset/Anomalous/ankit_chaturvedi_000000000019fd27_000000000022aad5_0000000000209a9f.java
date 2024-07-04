import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            String value = br.readLine();
            int openParentheses = 0;
            List<Character> output = new ArrayList<>();

            for (int i = 0; i < value.length(); i++) {
                int digit = Character.getNumericValue(value.charAt(i));

                if (digit == 0) {
                    for (int k = openParentheses; k > 0; k--) {
                        output.add(')');
                    }
                    output.add(value.charAt(i));
                    openParentheses = 0;
                } else if (digit > openParentheses) {
                    for (int k = openParentheses; k < digit; k++) {
                        output.add('(');
                    }
                    output.add(value.charAt(i));
                    openParentheses = digit;
                } else if (digit < openParentheses) {
                    for (int k = openParentheses; k > digit; k--) {
                        output.add(')');
                    }
                    output.add(value.charAt(i));
                    openParentheses = digit;
                } else {
                    output.add(value.charAt(i));
                }
            }

            for (int k = openParentheses; k > 0; k--) {
                output.add(')');
            }

            result.append("Case #").append(caseNumber).append(": ");
            for (char ch : output) {
                result.append(ch);
            }
            result.append("\n");
            caseNumber++;
        }

        System.out.print(result);
    }
}