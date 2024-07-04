import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String result = calculateNestingDepth(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String calculateNestingDepth(String str) {
        StringBuilder result = new StringBuilder();
        str = "0" + str + "0";
        
        for (int i = 0; i < str.length() - 1; i++) {
            char currentChar = str.charAt(i);
            char nextChar = str.charAt(i + 1);
            int difference = Character.getNumericValue(currentChar) - Character.getNumericValue(nextChar);
            
            if (difference > 0) {
                for (int j = 0; j < difference; j++) {
                    result.append(")");
                }
            } else if (difference < 0) {
                for (int j = 0; j < -difference; j++) {
                    result.append("(");
                }
            }
            
            if (i < str.length() - 2) {
                result.append(nextChar);
            }
        }
        
        return result.toString();
    }
}