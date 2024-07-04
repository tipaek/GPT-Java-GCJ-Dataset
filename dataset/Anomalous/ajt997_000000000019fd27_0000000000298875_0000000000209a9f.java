import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(reader.readLine());
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String inputString = reader.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : inputString.toCharArray()) {
                int digit = ch - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }
}