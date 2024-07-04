import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            String result = generateOutput(inputString);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String generateOutput(String s) {
        StringBuilder output = new StringBuilder();
        int currentDepth = 0;
        for (char character : s.toCharArray()) {
            int numericValue = Character.getNumericValue(character);
            if (currentDepth != numericValue) {
                output.append(generateBrackets(numericValue - currentDepth));
                currentDepth = numericValue;
            }
            output.append(numericValue);
        }
        output.append(generateBrackets(-currentDepth));
        return output.toString();
    }

    private static String generateBrackets(int depthChange) {
        if (depthChange > 0) {
            return String.join("", Collections.nCopies(depthChange, "("));
        } else if (depthChange < 0) {
            return String.join("", Collections.nCopies(-depthChange, ")"));
        }
        return "";
    }
}