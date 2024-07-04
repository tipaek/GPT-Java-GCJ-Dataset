import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            System.out.println("Case #" + i + ": " + calculateNestingDepth(inputString));
        }
    }

    public static String calculateNestingDepth(String str) {
        StringBuilder result = new StringBuilder();
        str = "0" + str + "0";
        
        for (int i = 0; i < str.length() - 1; i++) {
            int currentDigit = Character.getNumericValue(str.charAt(i));
            int nextDigit = Character.getNumericValue(str.charAt(i + 1));
            int difference = currentDigit - nextDigit;
            
            if (difference > 0) {
                result.append(")".repeat(difference));
            } else if (difference < 0) {
                result.append("(".repeat(-difference));
            }
            
            if (i < str.length() - 2) {
                result.append(str.charAt(i + 1));
            }
        }
        
        return result.toString();
    }
}