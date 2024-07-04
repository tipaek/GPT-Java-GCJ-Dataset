import java.util.Scanner;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            processVestigium(input, i);
        }
    }

    public static void processVestigium(String input, int caseNumber) {
        StringBuilder result = new StringBuilder();
        String modifiedInput = "0" + input + "0";
        
        for (int i = 0; i < modifiedInput.length() - 1; i++) {
            char currentChar = modifiedInput.charAt(i);
            char nextChar = modifiedInput.charAt(i + 1);
            int difference = Character.getNumericValue(currentChar) - Character.getNumericValue(nextChar);
            int absDifference = Math.abs(difference);
            
            if (difference > 0) {
                result.append(")".repeat(difference));
                if (i < modifiedInput.length() - 2) {
                    result.append(nextChar);
                }
            } else if (difference < 0) {
                result.append("(".repeat(absDifference));
                if (i < modifiedInput.length() - 2) {
                    result.append(Character.getNumericValue(nextChar));
                }
            } else {
                if (i < modifiedInput.length() - 2) {
                    result.append(currentChar);
                }
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}