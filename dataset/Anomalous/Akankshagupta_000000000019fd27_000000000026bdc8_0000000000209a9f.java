import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= numberOfCases; i++) {
            String inputStr = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParens = 0;
            Integer previousDigit = null;
            
            for (int j = 0; j < inputStr.length(); j++) {
                int currentDigit = inputStr.charAt(j) - '0';
                
                if (previousDigit == null) {
                    openParens = currentDigit;
                    previousDigit = currentDigit;
                    result.append("(".repeat(currentDigit));
                } else if (previousDigit > currentDigit) {
                    int difference = previousDigit - currentDigit;
                    openParens -= difference;
                    result.append(")".repeat(difference));
                } else if (previousDigit < currentDigit) {
                    int difference = currentDigit - previousDigit;
                    openParens += difference;
                    result.append("(".repeat(difference));
                }
                
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            result.append(")".repeat(openParens));
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}