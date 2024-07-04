import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            processNestingDepth(inputString, i);
        }
    }

    public static void processNestingDepth(String input, int caseNumber) {
        StringBuilder result = new StringBuilder();
        input = "0" + input + "0";
        
        for (int i = 0; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);
            int difference = Character.getNumericValue(currentChar) - Character.getNumericValue(nextChar);
            int absDifference = Math.abs(difference);
            
            if (difference > 0) {
                while (difference > 0) {
                    result.append(")");
                    difference--;
                }
                if (i < input.length() - 2) {
                    result.append(nextChar);
                }
            } else if (difference < 0) {
                while (difference < 0) {
                    result.append("(");
                    difference++;
                }
                if (i < input.length() - 2) {
                    result.append(nextChar);
                }
            } else {
                if (i < input.length() - 2) {
                    result.append(currentChar);
                }
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}