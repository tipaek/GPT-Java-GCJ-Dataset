import java.util.Scanner;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            processVestigium(inputString, i);
        }
    }

    private static void processVestigium(String str, int caseNumber) {
        StringBuilder result = new StringBuilder();
        str = "0" + str + "0";

        for (int i = 0; i < str.length() - 1; i++) {
            char currentChar = str.charAt(i);
            char nextChar = str.charAt(i + 1);
            int difference = Character.getNumericValue(currentChar) - Character.getNumericValue(nextChar);
            int absoluteDifference = Math.abs(difference);

            if (difference > 0) {
                while (difference > 0) {
                    result.append(")");
                    difference--;
                }
                if (i < str.length() - 2) {
                    result.append(nextChar);
                }
            } else if (difference < 0) {
                while (difference < 0) {
                    result.append("(");
                    difference++;
                }
                if (i < str.length() - 2) {
                    result.append(absoluteDifference);
                }
            } else {
                if (i < str.length() - 2) {
                    result.append(currentChar);
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}