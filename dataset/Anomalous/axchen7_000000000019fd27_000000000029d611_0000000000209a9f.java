import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0;
            
            for (char ch : input.toCharArray()) {
                int currentDigit = ch - '0';
                int difference = currentDigit - previousDigit;
                
                if (difference > 0) {
                    output.append("(".repeat(difference));
                } else if (difference < 0) {
                    output.append(")".repeat(-difference));
                }
                
                output.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            output.append(")".repeat(previousDigit));
            System.out.println("Case #" + caseNumber + ": " + output);
        }
    }
}