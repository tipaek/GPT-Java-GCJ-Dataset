import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String input = scanner.nextLine();
            StringBuilder resultBuilder = new StringBuilder();
            int currentLevel = 0;
            
            for (int charIndex = 0; charIndex < input.length(); charIndex++) {
                int digit = Character.getNumericValue(input.charAt(charIndex));
                
                while (currentLevel < digit) {
                    resultBuilder.append('(');
                    currentLevel++;
                }
                
                while (currentLevel > digit) {
                    resultBuilder.append(')');
                    currentLevel--;
                }
                
                resultBuilder.append(input.charAt(charIndex));
            }
            
            while (currentLevel > 0) {
                resultBuilder.append(')');
                currentLevel--;
            }
            
            System.out.println("Case #" + (caseIndex + 1) + ": " + resultBuilder.toString());
        }
        
        scanner.close();
    }
}