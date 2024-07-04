import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String word = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousNumber = 0;
            
            for (char character : word.toCharArray()) {
                int currentNumber = character - '0';
                int difference = currentNumber - previousNumber;
                
                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }
                
                result.append(currentNumber);
                previousNumber = currentNumber;
            }
            
            if (previousNumber > 0) {
                result.append(")".repeat(previousNumber));
            }
            
            System.out.println("Case #" + caseIndex + ": " + result);
        }
        
        scanner.close();
    }
}