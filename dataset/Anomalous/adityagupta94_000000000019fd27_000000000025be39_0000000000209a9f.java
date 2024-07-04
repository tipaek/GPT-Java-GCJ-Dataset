import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the number of test cases
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String digits = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            
            for (char ch : digits.toCharArray()) {
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
            System.out.println(String.format("Case #%d: %s", testCase, result.toString()));
        }
        
        scanner.close();
    }
}