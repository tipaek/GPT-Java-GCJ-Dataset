import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();

            int currentDepth = 0;
            for (int i = 0; i < inputString.length(); i++) {
                int digit = inputString.charAt(i) - '0';

                if (digit == currentDepth) {
                    result.append(digit);
                    continue;
                }

                int depthDifference = currentDepth - digit;

                if (depthDifference < 0) { // add '('
                    while (depthDifference < 0) {
                        result.append('(');
                        depthDifference++;
                    }
                } else { // add ')'
                    while (depthDifference > 0) {
                        result.append(')');
                        depthDifference--;
                    }
                }

                result.append(digit);
                currentDepth = digit;
            }

            // Close any remaining open parentheses
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
    }
}