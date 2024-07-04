import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline
        StringBuilder output = new StringBuilder();
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String inputLine = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (char character : inputLine.toCharArray()) {
                int digit = Character.getNumericValue(character);
                
                if (digit > currentDepth) {
                    result.append("(".repeat(digit - currentDepth));
                } else if (digit < currentDepth) {
                    result.append(")".repeat(currentDepth - digit));
                }
                
                currentDepth = digit;
                result.append(digit);
            }
            
            result.append(")".repeat(currentDepth));
            output.append("Case #").append(caseIndex + 1).append(": ").append(result).append("\n");
        }
        
        System.out.print(output);
    }
}