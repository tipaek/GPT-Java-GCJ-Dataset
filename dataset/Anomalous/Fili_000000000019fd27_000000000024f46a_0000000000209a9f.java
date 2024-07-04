import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            
            for (int index = 0; index < input.length(); index++) {
                int currentDigit = Character.getNumericValue(input.charAt(index));
                
                if (currentDigit > previousDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                }
                
                result.append(input.charAt(index));
                previousDigit = currentDigit;
            }
            
            result.append(")".repeat(previousDigit));
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}