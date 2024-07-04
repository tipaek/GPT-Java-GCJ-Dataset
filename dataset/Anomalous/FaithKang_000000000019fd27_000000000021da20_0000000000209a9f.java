import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                
                if (i == 0) {
                    appendBrackets(result, currentDigit, '(');
                    openBrackets = currentDigit;
                } else {
                    int previousDigit = Character.getNumericValue(input.charAt(i - 1));
                    if (currentDigit > previousDigit) {
                        appendBrackets(result, currentDigit - previousDigit, '(');
                        openBrackets += currentDigit - previousDigit;
                    } else if (currentDigit < previousDigit) {
                        appendBrackets(result, previousDigit - currentDigit, ')');
                        openBrackets -= previousDigit - currentDigit;
                    }
                }
                
                result.append(currentDigit);
            }
            
            appendBrackets(result, openBrackets, ')');
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }

    private static void appendBrackets(StringBuilder result, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
    }
}