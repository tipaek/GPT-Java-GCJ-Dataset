import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                
                while (previousDigit < currentDigit) {
                    result.append("(");
                    previousDigit++;
                }
                
                while (previousDigit > currentDigit) {
                    result.append(")");
                    previousDigit--;
                }
                
                result.append(currentDigit);
            }
            
            while (previousDigit > 0) {
                result.append(")");
                previousDigit--;
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}