import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int t = 1; t <= testCases; t++) {
            String inputString = scanner.nextLine();
            processCase(t, inputString);
        }
    }

    private static void processCase(int caseNumber, String inputString) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;
        
        for (char ch : inputString.toCharArray()) {
            int currentDigit = Character.getNumericValue(ch);
            
            if (currentDigit > previousDigit) {
                result.append("(".repeat(currentDigit - previousDigit));
            } else if (currentDigit < previousDigit) {
                result.append(")".repeat(previousDigit - currentDigit));
            }
            
            result.append(currentDigit);
            previousDigit = currentDigit;
        }
        
        result.append(")".repeat(previousDigit));
        System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
    }
}