import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfTests; i++) {
            String inputString = scanner.next();
            String result = processString(inputString);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String processString(String input) {
        if (!containsNonZeroDigit(input)) {
            return input;
        }

        if (!input.contains("0")) {
            return "(" + input + ")";
        }

        StringBuilder output = new StringBuilder();
        boolean isOpen = false;

        for (int j = 0; j < input.length(); j++) {
            char currentChar = input.charAt(j);

            if (currentChar != '0' && !isOpen) {
                output.append('(');
                isOpen = true;
            } else if (currentChar == '0' && isOpen) {
                output.append(')');
                isOpen = false;
            }

            output.append(currentChar);
        }

        if (isOpen) {
            output.append(')');
        }

        return output.toString();
    }

    private static boolean containsNonZeroDigit(String input) {
        for (char c : input.toCharArray()) {
            if (c != '0') {
                return true;
            }
        }
        return false;
    }
}