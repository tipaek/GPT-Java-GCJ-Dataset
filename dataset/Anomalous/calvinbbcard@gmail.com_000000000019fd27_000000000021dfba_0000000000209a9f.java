import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentLevel = Character.getNumericValue(input.charAt(0));
            
            // Add initial opening brackets
            for (int i = 0; i < currentLevel; i++) {
                result.append("(");
            }
            result.append(currentLevel);
            
            // Process the rest of the digits
            for (int i = 1; i < input.length(); i++) {
                int previousLevel = currentLevel;
                currentLevel = Character.getNumericValue(input.charAt(i));
                int levelDifference = currentLevel - previousLevel;
                
                if (levelDifference > 0) {
                    for (int j = 0; j < levelDifference; j++) {
                        result.append("(");
                    }
                } else if (levelDifference < 0) {
                    for (int j = 0; j < -levelDifference; j++) {
                        result.append(")");
                    }
                }
                result.append(currentLevel);
            }
            
            // Add closing brackets to balance the initial opening brackets
            for (int i = 0; i < currentLevel; i++) {
                result.append(")");
            }
            
            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
        
        scanner.close();
    }
}