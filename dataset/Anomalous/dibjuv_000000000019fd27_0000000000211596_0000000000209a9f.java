import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentOpenParens = 0;
            
            for (int i = 0; i < inputString.length(); i++) {
                int digit = Character.getNumericValue(inputString.charAt(i));
                
                if (digit > currentOpenParens) {
                    result.append("(".repeat(digit - currentOpenParens));
                } else if (digit < currentOpenParens) {
                    result.append(")".repeat(currentOpenParens - digit));
                }
                
                currentOpenParens = digit;
                result.append(digit);
            }
            
            result.append(")".repeat(currentOpenParens));
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}