import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int testCaseIndex = 0; testCaseIndex < testCaseCount; testCaseIndex++) {
            String numbers = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentLevel = 0;
            
            for (char digitChar : numbers.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);
                while (currentLevel < digit) {
                    result.append('(');
                    currentLevel++;
                }
                while (currentLevel > digit) {
                    result.append(')');
                    currentLevel--;
                }
                result.append(digitChar);
            }
            
            while (currentLevel > 0) {
                result.append(')');
                currentLevel--;
            }
            
            System.out.println("Case #" + (testCaseIndex + 1) + ": " + result);
        }
        
        scanner.close();
    }
}