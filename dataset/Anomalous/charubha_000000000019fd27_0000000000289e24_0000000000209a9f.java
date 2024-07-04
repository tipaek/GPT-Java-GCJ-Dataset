import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(sc.nextLine());
        String[] results = new String[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            results[i] = "";
        }

        for (int i = 0; i < testCaseCount; i++) {
            String input = sc.nextLine();
            StringBuilder tempOutput = new StringBuilder();
            String[] inputChars = input.split("");
            int[] digits = new int[inputChars.length];

            for (int j = 0; j < inputChars.length; j++) {
                digits[j] = Integer.parseInt(inputChars[j]);
            }

            int previousDigit = digits[0];
            tempOutput.append("(".repeat(previousDigit)).append(previousDigit);

            for (int j = 1; j < digits.length; j++) {
                if (digits[j] < previousDigit) {
                    int diff = previousDigit - digits[j];
                    tempOutput.append(")".repeat(diff)).append(digits[j]);
                } else if (digits[j] > previousDigit) {
                    int diff = digits[j] - previousDigit;
                    tempOutput.append("(".repeat(diff)).append(digits[j]);
                } else {
                    tempOutput.append(digits[j]);
                }
                previousDigit = digits[j];
            }

            tempOutput.append(")".repeat(previousDigit));
            results[i] = tempOutput.toString();
        }

        for (int i = 0; i < testCaseCount; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        sc.close();
    }
}