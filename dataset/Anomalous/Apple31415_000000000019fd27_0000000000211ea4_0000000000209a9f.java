import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();
            
            while (reader.ready()) {
                int digit = reader.read() - '0';
                if (digit == -38) // ASCII value of newline is 10, so 10 - 48 = -38
                    break;

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digit);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.printf("Case #%d: %s%n", caseIndex + 1, result.toString());
        }
    }
}