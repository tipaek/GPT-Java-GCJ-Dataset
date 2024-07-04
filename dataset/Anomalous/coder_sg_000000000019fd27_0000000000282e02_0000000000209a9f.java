import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                if (currentDepth < digit) {
                    for (int i = 0; i < digit - currentDepth; i++) {
                        result.append('(');
                    }
                } else if (currentDepth > digit) {
                    for (int i = 0; i < currentDepth - digit; i++) {
                        result.append(')');
                    }
                }

                result.append(ch);
                currentDepth = digit;
            }

            for (int i = 0; i < currentDepth; i++) {
                result.append(')');
            }

            output.append("Case #").append(caseNumber).append(": ").append(result).append("\n");
        }

        System.out.print(output);
    }
}