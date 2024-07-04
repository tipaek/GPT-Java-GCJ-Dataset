import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            processVestigium(inputString, i);
        }
        scanner.close();
    }

    public static void processVestigium(String inputString, int caseNumber) {
        StringBuilder result = new StringBuilder();
        inputString = "0" + inputString + "0";
        
        for (int i = 0; i < inputString.length() - 1; i++) {
            char currentChar = inputString.charAt(i);
            char nextChar = inputString.charAt(i + 1);
            int difference = Character.getNumericValue(currentChar) - Character.getNumericValue(nextChar);
            int absDifference = Math.abs(difference);

            if (difference > 0) {
                while (difference > 0) {
                    result.append(")");
                    difference--;
                }
                if (i < inputString.length() - 2) {
                    result.append(nextChar);
                }
            } else if (difference < 0) {
                while (difference < 0) {
                    result.append("(");
                    difference++;
                }
                if (i != inputString.length() - 2) {
                    result.append(absDifference);
                }
            } else {
                if (i != inputString.length() - 2) {
                    result.append(currentChar);
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}