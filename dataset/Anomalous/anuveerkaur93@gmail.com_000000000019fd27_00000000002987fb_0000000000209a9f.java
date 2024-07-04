import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String inputString = scanner.next();
            int length = inputString.length();
            StringBuilder result = new StringBuilder();
            
            char previousChar = '0';
            int openBrackets = 0;
            
            for (int i = 0; i < length; i++) {
                char currentChar = inputString.charAt(i);
                int currentDigit = currentChar - '0';
                int previousDigit = previousChar - '0';
                
                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append('(');
                        openBrackets++;
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(')');
                        openBrackets--;
                    }
                }
                
                result.append(currentChar);
                previousChar = currentChar;
            }
            
            for (int i = 0; i < openBrackets; i++) {
                result.append(')');
            }
            
            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
        
        scanner.close();
    }
}