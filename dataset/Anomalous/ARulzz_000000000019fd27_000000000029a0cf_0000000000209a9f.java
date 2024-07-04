import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            String result = formatWithParentheses(inputString);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String formatWithParentheses(String input) {
        StringBuilder formattedString = new StringBuilder();
        int currentDepth = 0;

        for (char character : input.toCharArray()) {
            int digit = Character.digit(character, 10);
            
            while (currentDepth < digit) {
                formattedString.append("(");
                currentDepth++;
            }
            while (currentDepth > digit) {
                formattedString.append(")");
                currentDepth--;
            }
            formattedString.append(character);
        }
        
        while (currentDepth > 0) {
            formattedString.append(")");
            currentDepth--;
        }

        return formattedString.toString();
    }
}