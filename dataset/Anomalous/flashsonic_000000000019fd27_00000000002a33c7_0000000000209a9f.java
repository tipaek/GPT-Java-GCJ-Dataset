import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        scanner.nextLine();
        
        for (int n = 0; n < cases; n++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            int currentDepth = 0;
            int previousDigit = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (i == 0) {
                    previousDigit = currentDigit;
                    currentDepth = currentDigit;
                    
                    result.append("(".repeat(currentDepth)).append(currentDigit);
                    
                    if (i == input.length() - 1) {
                        result.append(")".repeat(currentDepth));
                    }
                } else {
                    if (currentDigit > previousDigit) {
                        result.append("(".repeat(currentDigit - previousDigit));
                        currentDepth += (currentDigit - previousDigit);
                    } else {
                        result.append(")".repeat(previousDigit - currentDigit));
                        currentDepth -= (previousDigit - currentDigit);
                    }
                    
                    result.append(currentDigit);
                    previousDigit = currentDigit;

                    if (i == input.length() - 1) {
                        result.append(")".repeat(currentDepth));
                    }
                }
            }
            
            System.out.println(result);
        }

        scanner.close();
    }
}