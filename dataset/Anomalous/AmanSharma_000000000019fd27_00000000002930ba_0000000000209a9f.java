import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            int previousDigit = -1;
            
            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                
                if (i == 0) {
                    result.append("(".repeat(currentDigit));
                    openParentheses = currentDigit;
                } else {
                    if (currentDigit > previousDigit) {
                        result.append("(".repeat(currentDigit - previousDigit));
                        openParentheses += currentDigit - previousDigit;
                    } else if (currentDigit < previousDigit) {
                        result.append(")".repeat(previousDigit - currentDigit));
                        openParentheses -= previousDigit - currentDigit;
                    }
                }
                
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            result.append(")".repeat(openParentheses));
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}