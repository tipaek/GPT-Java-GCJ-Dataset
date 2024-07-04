import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine() + "0"; // Append "0" to handle closing parentheses
            StringBuilder result = new StringBuilder();
            int currentLevel = 0;
            
            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));
                
                while (currentLevel != digit) {
                    if (currentLevel < digit) {
                        result.append("(");
                        currentLevel++;
                    } else {
                        result.append(")");
                        currentLevel--;
                    }
                }
                
                result.append(input.charAt(j));
            }
            
            // Remove the last character added due to the appended "0"
            System.out.println(result.substring(0, result.length() - 1));
        }
        
        scanner.close();
    }
}