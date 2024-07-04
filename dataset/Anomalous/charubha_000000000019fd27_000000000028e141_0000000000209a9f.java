import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(sc.nextLine());
        String[] output = new String[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            String input = sc.nextLine();
            StringBuilder tempOutput = new StringBuilder();
            char[] digits = input.toCharArray();
            int[] digitValues = new int[digits.length];

            for (int j = 0; j < digits.length; j++) {
                digitValues[j] = Character.getNumericValue(digits[j]);
            }

            int currentDepth = 0;

            for (int j = 0; j < digitValues.length; j++) {
                int value = digitValues[j];
                while (currentDepth < value) {
                    tempOutput.append('(');
                    currentDepth++;
                }
                while (currentDepth > value) {
                    tempOutput.append(')');
                    currentDepth--;
                }
                tempOutput.append(value);
            }

            while (currentDepth > 0) {
                tempOutput.append(')');
                currentDepth--;
            }

            output[i] = tempOutput.toString();
        }

        for (int i = 0; i < testCaseCount; i++) {
            System.out.println("Case #" + (i + 1) + ": " + output[i]);
        }

        sc.close();
    }
}