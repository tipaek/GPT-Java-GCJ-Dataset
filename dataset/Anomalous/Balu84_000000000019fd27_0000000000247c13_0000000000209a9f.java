import java.util.*;
import java.io.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s"; // Output format for each test case
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); // Number of test cases
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.nextLine().trim();
            int[] digits = new int[input.length()];
            
            for (int i = 0; i < input.length(); i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                int currentDigit = digits[i];
                
                if (currentDigit == 0) {
                    result.append(currentDigit);
                } else {
                    if (i == 0) {
                        result.append(encloseWithParentheses(currentDigit, currentDigit));
                    } else {
                        int previousDigit = digits[i - 1];
                        
                        if (previousDigit == currentDigit) {
                            int lastPos = result.lastIndexOf(String.valueOf(previousDigit));
                            result.insert(lastPos + 1, currentDigit);
                        } else if (previousDigit < currentDigit) {
                            int diff = currentDigit - previousDigit;
                            int lastPos = result.lastIndexOf(String.valueOf(previousDigit));
                            result.insert(lastPos + 1, encloseWithParentheses(diff, currentDigit));
                        } else {
                            result.insert(result.length() - previousDigit, currentDigit);
                        }
                    }
                }
            }
            System.out.println(String.format(OUTPUT_FORMAT, testCase, result.toString()));
        }
    }
    
    private static String repeatString(int count, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    private static String encloseWithParentheses(int count, int digit) {
        String leftParentheses = repeatString(count, LEFT_PARENTHESIS);
        String rightParentheses = repeatString(count, RIGHT_PARENTHESIS);
        return leftParentheses + digit + rightParentheses;
    }
}