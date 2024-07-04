import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int currentNestingLevel = 0;

            for (int j = input.length() - 1; j >= 0; j--) {
                int digit = Character.getNumericValue(input.charAt(j));

                if (digit == 0) {
                    output.insert(0, "0");
                    currentNestingLevel = 0;
                } else {
                    if (currentNestingLevel <= digit) {
                        StringBuilder nestedValue = new StringBuilder(String.valueOf(digit));
                        for (int k = 0; k < digit - currentNestingLevel; k++) {
                            nestedValue.insert(0, "(").append(")");
                        }
                        output.insert(0, nestedValue);
                        currentNestingLevel = digit;
                    } else {
                        output.insert(0, digit);
                        currentNestingLevel = digit;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + output);
        }
        scanner.close();
    }
}