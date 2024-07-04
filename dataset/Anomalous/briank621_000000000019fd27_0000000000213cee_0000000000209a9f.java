import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = br.readLine();
            int openParentheses = 0;

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';
                while (openParentheses < currentDigit) {
                    result.append("(");
                    openParentheses++;
                }
                while (openParentheses > currentDigit) {
                    result.append(")");
                    openParentheses--;
                }
                result.append(currentDigit);
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println(result);
        }

        br.close();
    }
}