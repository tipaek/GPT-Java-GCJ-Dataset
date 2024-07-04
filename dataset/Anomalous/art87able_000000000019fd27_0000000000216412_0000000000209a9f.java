import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            
            int previousDigit = 0;
            for (char currentChar : inputString.toCharArray()) {
                int currentDigit = currentChar - '0';
                
                if (currentDigit > previousDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                }
                
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            result.append(")".repeat(previousDigit));
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}