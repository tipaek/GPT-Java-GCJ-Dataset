import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder result = new StringBuilder();
            String inputString = scanner.nextLine();
            int currentDepth = 0;
            
            for (char ch : inputString.toCharArray()) {
                int digit = ch - '0';
                int difference = digit - currentDepth;
                
                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }
                
                result.append(digit);
                currentDepth = digit;
            }
            
            result.append(")".repeat(currentDepth));
            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
    }
}