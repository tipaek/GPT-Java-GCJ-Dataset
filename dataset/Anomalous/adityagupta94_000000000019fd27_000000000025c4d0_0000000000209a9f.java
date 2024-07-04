import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; testCaseIndex++) {
            String inputDigits = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();
            
            for (int i = 0; i < inputDigits.length(); i++) {
                int digit = Character.getNumericValue(inputDigits.charAt(i));
                resultBuilder.append("(".repeat(digit))
                             .append(digit)
                             .append(")".repeat(digit));
            }
            
            String result = resultBuilder.toString();
            while (result.contains(")(")) {
                result = result.replace(")(", "");
            }
            
            System.out.printf("Case #%d: %s%n", testCaseIndex + 1, result);
        }
        
        scanner.close();
    }
}