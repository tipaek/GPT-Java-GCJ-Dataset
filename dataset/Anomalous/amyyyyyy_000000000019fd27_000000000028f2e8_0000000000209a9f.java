import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            String input = br.readLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (openBrackets < digit) {
                    result.append("(");
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    result.append(")");
                    openBrackets--;
                }

                result.append(digit);
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}