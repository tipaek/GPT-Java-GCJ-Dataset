import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            
            for (char currentChar : inputString.toCharArray()) {
                int currentDigit = Character.getNumericValue(currentChar);
                
                if (currentDigit > previousDigit) {
                    for (int i = 0; i < currentDigit - previousDigit; i++) {
                        result.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int i = 0; i < previousDigit - currentDigit; i++) {
                        result.append(')');
                    }
                }
                
                result.append(currentChar);
                previousDigit = currentDigit;
            }
            
            for (int i = 0; i < previousDigit; i++) {
                result.append(')');
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}