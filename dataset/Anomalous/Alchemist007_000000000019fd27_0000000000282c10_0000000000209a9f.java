import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int testCaseNumber = 1; testCaseNumber <= testCaseCount; testCaseNumber++) {
            String inputString = scanner.next();
            String result = formatStringWithParentheses(inputString, 0);
            System.out.println("Case #" + testCaseNumber + ": " + result);
        }
    }
    
    public static String formatStringWithParentheses(String input, int baseCount) {
        if (input.isEmpty()) {
            return "";
        }
        
        int minimumDigit = findMinimumDigit(input);
        StringBuilder formattedString = new StringBuilder();
        int segmentStart = 0;
        
        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            if (currentDigit == minimumDigit) {
                formattedString.append(formatStringWithParentheses(input.substring(segmentStart, i), minimumDigit))
                               .append(input.charAt(i));
                segmentStart = i + 1;
            }
        }
        
        formattedString.append(formatStringWithParentheses(input.substring(segmentStart), minimumDigit));
        
        for (int i = baseCount; i < minimumDigit; i++) {
            formattedString.insert(0, "(").append(")");
        }
        
        return formattedString.toString();
    }
    
    public static int findMinimumDigit(String input) {
        int minimumDigit = Character.getNumericValue(input.charAt(0));
        
        for (int i = 1; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            if (currentDigit < minimumDigit) {
                minimumDigit = currentDigit;
            }
        }
        
        return minimumDigit;
    }

}