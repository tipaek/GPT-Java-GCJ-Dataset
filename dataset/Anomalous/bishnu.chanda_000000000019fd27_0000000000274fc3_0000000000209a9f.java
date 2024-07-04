import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            
            int previousDigit = Character.getNumericValue(input.charAt(0));
            appendBraces(result, previousDigit, '(');
            result.append(previousDigit);
            
            for (int i = 1; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                
                if (currentDigit > previousDigit) {
                    appendBraces(result, currentDigit - previousDigit, '(');
                } else if (currentDigit < previousDigit) {
                    appendBraces(result, previousDigit - currentDigit, ')');
                }
                
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            appendBraces(result, previousDigit, ')');
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static void appendBraces(StringBuilder result, int count, char brace) {
        for (int i = 0; i < count; i++) {
            result.append(brace);
        }
    }
}