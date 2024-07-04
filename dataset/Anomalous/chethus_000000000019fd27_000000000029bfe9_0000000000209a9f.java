import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int caseIndex = 0; caseIndex < testCaseCount; caseIndex++) {
            String inputString = reader.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char character : inputString.toCharArray()) {
                int digit = Character.getNumericValue(character);
                
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(character);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
        }
    }
}